package com.example.esraabalbaa.graduationproject;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileEditMode extends AppCompatActivity {
    de.hdodenhof.circleimageview.CircleImageView hh;
    private static int RESULT_LOAD_IMAGE = 1;
    EditText ename,eemail,eaddress,emobile;
    Button savechanges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit_mode);

        ename = (EditText) findViewById(R.id.edname);
        eemail = (EditText) findViewById(R.id.edemail);
        eaddress = (EditText) findViewById(R.id.edaddress);
        emobile = (EditText) findViewById(R.id.edmobile);


        hh = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.imageView);
        hh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });


        Bundle extras = getIntent().getExtras();
        ename.setText(extras.getString("UserName"));
        eemail.setText(extras.getString("UserEmail"));
        emobile.setText(extras.getString("UserMobile"));
        eaddress.setText(extras.getString("UserAddress"));
        savechanges = (Button) findViewById(R.id.save);
        savechanges.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent n = new Intent(ProfileEditMode.this,CustomerProfile.class);

               n.putExtra("EditedUserName", ename .toString());
                n.putExtra("EditedUserEmail", eemail.getText().toString());
                n.putExtra("EditedUserMobile", emobile.getText().toString());
                n.putExtra("EditedUserAddress", eaddress.getText().toString());

                startActivity(n);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            hh.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }


    }
}
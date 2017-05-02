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
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    de.hdodenhof.circleimageview.CircleImageView uplo;
    private static int RESULT_LOAD_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);

        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etPhone = (EditText) findViewById(R.id.etPhone);
        final Button bRegister = (Button) findViewById(R.id.bRegister);
//upload profile image
        uplo = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.uploadimage);
        uplo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

//        uplo.buildDrawingCache();
//        final Bitmap bitmap = uplo.getDrawingCache();


        final TextView policiesLink = (TextView) findViewById(R.id.tvPolicies);
        policiesLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent policiesIntent = new Intent(RegisterActivity.this,PoliciesActivity.class);
                RegisterActivity.this.startActivity(policiesIntent);
            }
        });


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(RegisterActivity.this,MainActivity.class);
                //facebook
//                w.putExtra("Bitmap", bitmap);
                startActivity(w);

//                if (!validateEmail(etEmail.getText().toString())) {
//                    etEmail.setError(("تأكد من البريد الالكتروني!"));
//                    etEmail.requestFocus();
//
//
//                } else if (!validatePhone(etPhone.getText().toString())) {
//                    etPhone.setError(("تأكد من رقم الهاتف!"));
//                    etPhone.requestFocus();
//
//                } else if (!validatePassword(etPassword.getText().toString())) {
//                    etPassword.setError(("لاتقل عن 8 احرف"));
//                    etPassword.requestFocus();
//
//                } else if (!validateUsername(etUsername.getText().toString())) {
//                    etUsername.setError(("مثال:الاسم الثنائي_1234"));
//                    etUsername.requestFocus();
//                } else {
//                    Toast.makeText(RegisterActivity.this, "تم انشاء الحساب", Toast.LENGTH_LONG).show();
//
//                }

            }

        });

    }
    //to put the chosen image in place
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
            uplo.setImageBitmap(BitmapFactory.decodeFile(picturePath));


        }


    }
    //END IMAGE UPLOAD




    protected boolean validatePhone(String phone) {
        if (phone != null && phone.length() == 11 && phone.startsWith("010") || phone.startsWith("011") || phone.startsWith("012")) {
            return true;
        } else {
            return false;
        }
    }


    //Return true if email is valid and false if email is invalid
    protected boolean validateEmail(String email) {
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



    protected boolean validatePassword(String password) {
        if (password != null && password.length() > 7) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean validateUsername(String username) {
        if (username  != null && username.length() > 9)
            return true;
        else {
            return false;
        }
    }
}



package com.example.esraabalbaa.graduationproject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomerProfile extends AppCompatActivity {
Button btn1;
    public TextView username,useremail,usermobile,useraddress, rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        username = (TextView) findViewById(R.id.username);
        useremail = (TextView) findViewById(R.id.email);
        usermobile = (TextView) findViewById(R.id.mobile);
        useraddress = (TextView) findViewById(R.id.address);

        //Rate from google store
        rate = (TextView) findViewById(R.id.rateus);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent rate = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(rate);
            }catch(ActivityNotFoundException e){
                    Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                    Intent rate = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(rate);
                }
            }
        });

        btn1 = (Button) findViewById(R.id.editabletext);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CustomerProfile.this,ProfileEditMode.class);
                i.putExtra("UserName", username.getText().toString());
                i.putExtra("UserEmail", useremail.getText().toString());
                i.putExtra("UserMobile", usermobile.getText().toString());
                i.putExtra("UserAddress", useraddress.getText().toString());
                startActivity(i);
            }
        });
        //to save the edited changes
//        Bundle ex = getIntent().getExtras();
//        username.setText(ex.getString("EditedUserName"));
//        useremail.setText(ex.getString("EditedUserEmail"));
//        usermobile.setText(ex.getString("EditedUserMobile"));
//        useraddress.setText(ex.getString("EditedUserAddress"));
    }
}

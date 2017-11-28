package com.example.user.grantiecom.Auth;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.grantiecom.R;

public class PreviewPage extends AppCompatActivity {

    private Button signup, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_page);

        signup = (Button)findViewById(R.id.btnSignup);
        login = (Button)findViewById(R.id.btnLogin);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup.setBackgroundColor(Color.parseColor("#5ba5fe"));
                startActivity(new Intent(PreviewPage.this,Signup.class));
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setBackgroundColor(Color.parseColor("#5ba5fe"));
                startActivity(new Intent(PreviewPage.this,Login.class));
                finish();
            }
        });


    }
}

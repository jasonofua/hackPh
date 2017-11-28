package com.example.user.grantiecom.Auth;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.user.grantiecom.Activities.MainActivity;
import com.example.user.grantiecom.R;
import com.example.user.grantiecom.Utils.Validation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import dmax.dialog.SpotsDialog;

public class Login extends AppCompatActivity {

    private SharedPreferences preferences;
    private EditText emaill,password;
    private TextInputLayout tilEmail,tilPassword;
    private Button login;
    private LinearLayout register;
    private RelativeLayout smack;
    AlertDialog dialog;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        dialog = new SpotsDialog(Login.this, R.style.Custom);
        emaill = (EditText)findViewById(R.id.edtEmail);
        password = (EditText)findViewById(R.id.edtPassword);
        login = (Button)findViewById(R.id.buttonLogin);
        register = (LinearLayout)findViewById(R.id.linlayRegister);
        tilEmail = (TextInputLayout)findViewById(R.id.tilEmail);
        tilPassword = (TextInputLayout)findViewById(R.id.tilPassword);
        smack = (RelativeLayout)findViewById(R.id.rllayout);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Signup.class));
            }
        });

    }

    private void loginUser() {

        dialog.show();
        setError();
        int err = 0;

        String memail =emaill.getText().toString().trim();
        String mpassword =password.getText().toString().trim();

        if (!Validation.validateEmail(memail)) {
            err++;
            tilEmail.setError("Email should not be empty !");
            login.setEnabled(false);

        }

        if (!Validation.validateFields(mpassword)) {
            err++;
           tilPassword.setError("Password should not be empty !");
          login.setEnabled(false);

        }

        if (err == 0) {
          doLogin(memail,mpassword);

        } else {
            showToastMessage("Enter Valid Details !");

        }

    }

    private void doLogin(String memail, String mpassword) {

        mAuth.signInWithEmailAndPassword(memail,mpassword)
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if (!task.isSuccessful()) {
                            showToastMessage("Authentication failed.");
                        } else {
                            showToastMessage("Welcome Back.");
                            startActivity(new Intent(Login.this, MainActivity.class));
                            finish();
                        }

                    }
                });

    }

    private void showToastMessage(String s) {
        Snackbar.make(smack, s, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private void setError() {
        tilEmail.setError(null);
        tilPassword.setError(null);
    }

}

package com.example.user.grantiecom.Auth;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {


    private SharedPreferences preferences;
    private EditText emaill,password,conPassword;
    private TextInputLayout tilEmail,tilPassword,tilConfirm;
    private Button signup;
    private LinearLayout login;
    private RelativeLayout smack;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth =FirebaseAuth.getInstance();
        emaill = (EditText)findViewById(R.id.editTextEmail);
        password = (EditText)findViewById(R.id.editTextPassword);
        conPassword = (EditText)findViewById(R.id.editTextConfirmPass);
        signup = (Button)findViewById(R.id.buttonSignup);
        login = (LinearLayout)findViewById(R.id.linlaylogin);
        tilEmail = (TextInputLayout)findViewById(R.id.tilEmailSign);
        tilPassword = (TextInputLayout)findViewById(R.id.tilPasswordSign);
        tilConfirm = (TextInputLayout)findViewById(R.id.tilPasswordConfirm);
        smack = (RelativeLayout)findViewById(R.id.rllysmack);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupUser();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup.this,Login.class));
            }
        });

    }

    private void signupUser() {
        setError();
        int err = 0;


        String memail = emaill.getText().toString().trim();
        String mpassword = password.getText().toString().trim();
        String mpasswordConfirm = conPassword.getText().toString().trim();

        // checking if the password are the same
        if (!mpassword.equalsIgnoreCase(mpasswordConfirm)) {
            err++;
           tilPassword.setError("Password does not match !");
        }
        if (mpassword.length() < 6) {
            err++;
            tilPassword.setError("Password must be greater than 6");
        }



        if (!Validation.validateEmail(memail)) {
            err++;
           tilEmail.setError("Email should be valid !");
        }

        if (!Validation.validateFields(mpassword)) {
            err++;
            tilPassword.setError("Password should not be empty !");
        }

        if (!Validation.validateFields(mpasswordConfirm)) {
            err++;
           tilConfirm.setError("Confirm password!");
        }

        if (err == 0) {
          doSignUp(memail,mpassword);
        } else {
            showToastMessage("Enter Valid Details !");
        }

    }

    private void doSignUp(String memail, String mpassword) {
        mAuth.createUserWithEmailAndPassword(memail,mpassword)
                .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            showToastMessage("Registration failed.");
                        } else {
                            showToastMessage("Registration Successful");
                            startActivity(new Intent(Signup.this, MainActivity.class));
                            finish();
                        }
                    }
                });

    }

    private void setError() {

        tilPassword.setError(null);
        tilConfirm.setError(null);
        tilPassword.setError(null);
    }
    private void showToastMessage(String s) {
        Snackbar.make(smack, s, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}

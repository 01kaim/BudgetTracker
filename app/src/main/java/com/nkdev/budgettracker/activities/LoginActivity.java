package com.nkdev.budgettracker.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nkdev.budgettracker.MainActivity;
import com.nkdev.budgettracker.R;

public class LoginActivity extends AppCompatActivity {
    //Déclarez une instance de FirebaseAuth
    private FirebaseAuth mAuth;
    private Button Btn_new_reg,Btn_frgt,BtnGmail,BtnLog;
    private TextInputEditText EmailText,PasswordText;
    private String Email,Password;
    private CheckBox Remember;
    private ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BtnLog=findViewById(R.id.id_btnLogin);
        BtnGmail=findViewById(R.id.id_btnGmail);
        Btn_new_reg=findViewById(R.id.id_BtnLog_register);
        EmailText=findViewById(R.id.id_email_log);
        PasswordText=findViewById(R.id.id_password_log);
        progressbar = findViewById(R.id.progressbar);
        BtnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        BtnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

    }
    //Lors de l'initialisation de votre activité, vérifiez si l'utilisateur est actuellement connecté.
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
        }
    }
    //Connectez-vous aux utilisateurs existants
    public  void Login(){
        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        Email = EmailText.getText().toString();
        Password = PasswordText.getText().toString();

        // validations for input email and password
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(getApplicationContext(),"Please enter email!!", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(Password)) {Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // signin existing user
        mAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Login successful!!",
                                            Toast.LENGTH_LONG)
                                    .show();

                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);

                            // if sign-in is successful
                            // intent to home activity
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish(); // Destroy activity A and not exist in Back stack

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);



                        }
                    }
                });
    }

}
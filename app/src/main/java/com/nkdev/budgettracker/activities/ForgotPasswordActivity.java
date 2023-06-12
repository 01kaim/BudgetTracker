package com.nkdev.budgettracker.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.nkdev.budgettracker.R;

import java.util.Timer;
import java.util.TimerTask;

public class ForgotPasswordActivity extends AppCompatActivity {
    private ImageButton BtnBack;
    private Button BtnNext;
    private TextInputEditText EmailRest;
    private ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        BtnBack = findViewById(R.id.id_btn_back_fg);
        progressBar=findViewById(R.id.id_progress_bar);
        BtnNext=findViewById(R.id.id_frgt_next);
        EmailRest=findViewById(R.id.id_etFrgtEmail);
        auth=FirebaseAuth.getInstance();
        //Button Forget
        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restPassword();
            }
        });
        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
                Toast.makeText(ForgotPasswordActivity.this, "Check your Email: "+EmailRest.getText().toString().trim(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    // reset password
    private  void restPassword(){
        //check if edit text empty
        String email=EmailRest.getText().toString().trim();
        if (email.isEmpty()){
            EmailRest.setError("Email cannot be empty");
            EmailRest.requestFocus();
        }if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            EmailRest.setError("Please provide valid email !");
            EmailRest.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(ForgotPasswordActivity.this,"Check your Email to reset your password!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ForgotPasswordActivity.this,"Try again! Something wrong happen!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
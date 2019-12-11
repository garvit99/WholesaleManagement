package com.example.wholesalemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login, register;
    private DatabaseReference databaseReference;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser mFirebaseUser;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        login=findViewById(R.id.button_login);
        register=findViewById(R.id.button_register);

        firebaseAuth=FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        }
        firebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = firebaseAuth.getCurrentUser();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                Toast.makeText(LoginActivity.this, Email+Password, Toast.LENGTH_SHORT).show();
                if(TextUtils.isEmpty(Email))
                {
                    Toast.makeText(LoginActivity.this,"Please Enter Email",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(Password))
                {
                    Toast.makeText(LoginActivity.this,"Please Enter Password",Toast.LENGTH_LONG).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this,HomeActivity.class));

                                }
                                else {
                                Toast.makeText(LoginActivity.this,"Wrong Password or UserEmail does not Exist",Toast.LENGTH_LONG).show();
                                return;
                                }


                            }
                        });


            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(in);
            }
        });


    }



    }


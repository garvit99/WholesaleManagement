package com.example.wholesalemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    EditText retailer, shop, certification, city, phone, alternate, email, address, aadhar, pan, password,repass;
    Button submit;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private String mUserId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        retailer = findViewById(R.id.et_retailer);
        shop = findViewById(R.id.et_shop);
        certification = findViewById(R.id.et_certification);
        city = findViewById(R.id.et_city);
        phone = findViewById(R.id.et_phone);
        alternate = findViewById(R.id.et_alternate);

        address = findViewById(R.id.et_address);
        aadhar = findViewById(R.id.et_aadhar);
        pan = findViewById(R.id.et_pan);

        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        repass=findViewById(R.id.et_repassword);


        submit = findViewById(R.id.submit);


        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("users");
        //mFirebaseInstance = FirebaseDatabase.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Retailer = retailer.getText().toString();
                final String Shop = shop.getText().toString();
                final String Certification = certification.getText().toString();
                final String City = city.getText().toString();
                final String Phone = phone.getText().toString();
                final String Alternate = (alternate.getText().toString());
                final String Email = email.getText().toString();
                final String Address = address.getText().toString();
                final String Aadhar = (aadhar.getText().toString());
                final String Pan = pan.getText().toString();
                String Password = password.getText().toString();
                String Repassword=repass.getText().toString();







                                    if(!Password.equals(Repassword))
                {
                    Toast.makeText(RegisterActivity.this,"PASSWORD DONT MATCH!",Toast.LENGTH_LONG).show();
                    return;
                }
                mUserId = mFirebaseDatabase.push().getKey();
                User user = new User(Retailer, Shop, Certification, City, Phone, Alternate, Email, Address, Aadhar, Pan, Password);



                mFirebaseDatabase.child(mUserId).setValue(user);

                Toast.makeText(getApplicationContext(),"Data Added",Toast.LENGTH_LONG).show();
                mFirebaseAuth.createUserWithEmailAndPassword(Email,Password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(RegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                                    finish();
                                }
                            }
                        });





            }
        });


    }




}
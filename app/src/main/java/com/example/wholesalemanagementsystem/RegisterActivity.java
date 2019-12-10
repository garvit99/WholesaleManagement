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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText retailer, shop, certification, city, phone, alternate, email, address, aadhar, pan, password, repassword;
    Button submit;
    private String mUserId;
    private DatabaseReference databaseReference;
   private FirebaseDatabase firebaseDatabase;
   private FirebaseAuth firebaseAuth;
    private  FirebaseUser firebaseUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        retailer=findViewById(R.id.et_retailer);
        shop=findViewById(R.id.et_shop);
        certification=findViewById(R.id.et_certification);
        city=findViewById(R.id.et_city);
        phone=findViewById(R.id.et_phone);
        alternate=findViewById(R.id.et_alternate);
        email=findViewById(R.id.et_email);
        address=findViewById(R.id.et_address);
        aadhar=findViewById(R.id.et_aadhar);
        pan=findViewById(R.id.et_pan);
        password=findViewById(R.id.et_password);
        repassword=findViewById(R.id.et_repassword);
        submit=findViewById(R.id.submit);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");


        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final String Retailer=retailer.getText().toString();
                final String Shop=shop.getText().toString();
                final String Certification= certification.getText().toString();
                final String City=city.getText().toString();
                final String Phone= phone.getText().toString();
                final String Alternate= (alternate.getText().toString());
                final String Email=email.getText().toString();
                final String Address=address.getText().toString();
                final String  Aadhar= (aadhar.getText().toString());
                final String Pan=pan.getText().toString();
                String Password=password.getText().toString();
                String Repassword=repassword.getText().toString();


                if(TextUtils.isEmpty(Retailer))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter Name",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(Shop))
                {
                    Toast.makeText(RegisterActivity.this,"Please Shop Name",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(Certification))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter Certification no.",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(City))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter City",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(Phone))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter Phone no.",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(Email))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter Email",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(Address))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter Address",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(Aadhar))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter Aadhar ID",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(Pan))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter PAN no.",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(Password))
                {
                    Toast.makeText(RegisterActivity.this,"Please Enter Password",Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(Repassword))
                {
                    Toast.makeText(RegisterActivity.this,"Please Re-Enter Password",Toast.LENGTH_LONG);
                    return;
                }

                if(Password!=Repassword)
                {
                    Toast.makeText(RegisterActivity.this,"Password are not Matching",Toast.LENGTH_LONG);
                    return;
                }

                if(Password.length()<6)
                {
                    Toast.makeText(RegisterActivity.this,"Password must be >6 digits!",Toast.LENGTH_LONG);
                    return;
                }


                firebaseAuth.createUserWithEmailAndPassword(Email, Password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    mUserId=firebaseUser.getUid();

                                    User user = new User(
                                            Retailer,
                                            Shop,
                                            Certification,
                                            City,
                                            Phone,
                                            Alternate,
                                            Email,
                                            Address,
                                            Aadhar,
                                            Pan
                                    );



                                    FirebaseDatabase.getInstance().getReference("users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task)
                                        {
                                            Toast.makeText(RegisterActivity.this,"Registered Successfully!",Toast.LENGTH_LONG);
                                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                                        }
                                    });


                                }
                                else {

                                }

                                // ...
                            }
                        });

            }
        });


    }
}

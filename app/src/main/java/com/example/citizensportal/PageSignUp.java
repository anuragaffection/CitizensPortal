package com.example.citizensportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PageSignUp extends AppCompatActivity {

    EditText name;
    EditText username;
    EditText email;
    EditText password;
    Button signUp;
    FirebaseAuth mAuth;
    
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_sign_up);

        
                // taking FirebaseAuth instance
                mAuth = FirebaseAuth.getInstance();
                
                name = findViewById(R.id.Name);
                username = findViewById(R.id.username);
                email = findViewById(R.id.Email);
                password = findViewById(R.id.Password);
                signUp = findViewById(R.id.signUp);


                // Set on Click Listener on Registration button
                signUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        registerNewUser();
                    }
                });


    }
            

    private void registerNewUser() {
        
                String nameGet, usernameGet, emailGet, passwordGet;
                
                nameGet = name.getText().toString();
                usernameGet = username.getText().toString();
                emailGet = email.getText().toString();
                passwordGet = password.getText().toString();
                

                // Validations for input email and password
                if (TextUtils.isEmpty(nameGet)){
                    Toast.makeText(getApplicationContext(), "Please enter Name ", Toast.LENGTH_LONG).show();
                    return;
                }
                
                if (TextUtils.isEmpty(usernameGet)){
                   Toast.makeText(getApplicationContext(), "Please enter username ", Toast.LENGTH_LONG).show();
                   return;
                }
                
                if (TextUtils.isEmpty(emailGet)) {
                    Toast.makeText(getApplicationContext(), "Please enter email!!", Toast.LENGTH_LONG).show();
                    return;
                }
                
                if (TextUtils.isEmpty(passwordGet)) {
                    Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG).show();
                    return;
                }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();


                            // if the user created intent to login activity
                            Intent intent = new Intent(PageSignUp.this, MainActivity.class);startActivity(intent);
                            startActivity(intent);
                        }
                        else {

                            Toast.makeText(getApplicationContext(), "Registration failed!!" + " Please try again later", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
        

    
}
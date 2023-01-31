package com.example.myapplicationcart;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplicationcart.databinding.ActivityLoginBinding;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityLoginBinding binding;

    String email ;
    String password ;

    // Step 1 Variable Initialise
    private FirebaseAuth mAuth;

//    SharedPreferences sp;
//    sp = getSharedPreferences("login",MODE_PRIVATE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Second Step
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();



        binding.loginBtn.setOnClickListener(view -> {
            email = binding.emailEdtText.getText().toString();
            password = binding.passEdtText.getText().toString();


            if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                Toast.makeText(this,"Please Enter All Fields",Toast.LENGTH_SHORT).show();
            }else {
                loginUser();
//                sp.edit().putBoolean("logged",true).apply();

            }


        });


    }
    private void loginUser(){

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            openMainActivity();

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    private void openMainActivity(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }


}
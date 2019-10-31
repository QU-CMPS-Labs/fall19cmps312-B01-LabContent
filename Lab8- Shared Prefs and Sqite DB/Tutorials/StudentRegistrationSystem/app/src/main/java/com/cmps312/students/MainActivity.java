package com.cmps312.students;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEdt;
    private EditText passwordEdt;

    public static final String USERNAME_KEY = "username";
    public static final String PASWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEdt = findViewById(R.id.username);
        passwordEdt = findViewById(R.id.password);

    }

    public void registerUser(View view) {


    }

    //Read from shared preferences
    public void loginUser(View view) {

    }
}

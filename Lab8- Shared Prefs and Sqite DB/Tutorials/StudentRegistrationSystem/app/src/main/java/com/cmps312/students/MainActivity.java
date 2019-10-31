package com.cmps312.students;

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
        SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);

        //we get the editor
        SharedPreferences.Editor editor = preferences.edit();
        //bundle
        editor.putString(USERNAME_KEY,usernameEdt.getText().toString().toLowerCase());
        editor.putString(PASWORD_KEY,passwordEdt.getText().toString());

        //we save it
        editor.commit();

    }

    //Read from shared preferences
    public void loginUser(View view) {

        SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);

        String savedUsername = preferences.getString(USERNAME_KEY,"");
        String savedPassword = preferences.getString(PASWORD_KEY,"");

        if(savedUsername.equals(usernameEdt.getText().toString().toLowerCase())
                && savedPassword.equals(passwordEdt.getText().toString())){
            Toast.makeText(this, "You are ok to access", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Error, unable to login", Toast.LENGTH_SHORT).show();
        }

    }
}

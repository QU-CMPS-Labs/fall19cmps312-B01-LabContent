package com.cmps312.implicitexplicitpermissions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String OPEN_SECOND_ACTIVITY
            = "com.cmps312.implicitexplicitpermissions.openSecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSecondActivity(View view) {
        Intent intent = new Intent("com.cmps312.implicitexplicitpermissions.openSecondActivity");
        intent.putExtra("score", 5);
        startActivity(intent);
    }
}

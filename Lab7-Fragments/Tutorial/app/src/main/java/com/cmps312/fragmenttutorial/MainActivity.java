package com.cmps312.fragmenttutorial;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String ARGS_KEY = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentB fragmentB = FragmentB.newInstance("Abdulahi");

        //use the fragment manager to add/replace/delete

        getSupportFragmentManager()
                .beginTransaction()

                .add(R.id.fragment_holder, fragmentB)
                .addToBackStack(null)

                .commit();
    }
}

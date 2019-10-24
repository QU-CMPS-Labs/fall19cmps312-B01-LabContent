package com.cmps312.fragmenttutorial;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentB.InteractionInterface {

    private static final String ARGS_KEY = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //use the fragment manager to add/replace/delete

        FragmentB fragmentB = FragmentB.newInstance("Abdulahi");
        getSupportFragmentManager()
                .beginTransaction()

                .add(R.id.fragment_holder, fragmentB)
                .addToBackStack(null)

                .commit();

    }

    @Override
    public void sayHello(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

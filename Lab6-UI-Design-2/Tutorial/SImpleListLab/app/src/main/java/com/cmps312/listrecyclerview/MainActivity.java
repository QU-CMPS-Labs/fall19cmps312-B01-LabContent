package com.cmps312.listrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Country> countries;
    private ListView listView;
    private MyArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DB or from server
        countries = Country.getCountries();

        listView = findViewById(R.id.list);

        //to create the adapter
        adapter = new MyArrayAdapter(this, countries);

        //add the adapter to the list view

        listView.setAdapter(adapter);



    }
}

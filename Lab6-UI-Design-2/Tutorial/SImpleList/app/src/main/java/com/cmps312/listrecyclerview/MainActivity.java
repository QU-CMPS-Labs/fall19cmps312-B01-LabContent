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
    private ArrayAdapter<Country> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DB or from server
        countries = Country.getCountries();

        listView = findViewById(R.id.list);

        //to create the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        //add the adapter to the list view

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = countries.get(position);
                Intent intent = new Intent(MainActivity.this, CountryDetails.class);

                intent.putExtra("country", country);
//                intent.putExtra("countries", countries);

                startActivity(intent);


            }
        });


    }
}

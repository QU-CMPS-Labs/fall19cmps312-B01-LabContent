package com.cmps312.listrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //1. declare the listview

//    private String[] countries = {"qatar", "oman", "usa", "uk"};

    private ArrayList<String> countries;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries = new ArrayList<>();
        countries.add("qatar");
        countries.add("oman");
        countries.add("uk");

        listView = findViewById(R.id.list);

        //to create the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        //add the adapter to the list view

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    countries.remove(position);
                    adapter.notifyDataSetChanged();
            }
        });


    }
}

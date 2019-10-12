package com.cmps312.listrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyRecyclerAdapter adapter;
    ArrayList<Country> countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView= findViewById(R.id.rv);

        countries = Country.getCountries();
        //
//        LinearLayoutManager manager = new LinearLayoutManager(this);
          GridLayoutManager manager = new GridLayoutManager(this, 3);

        adapter = new MyRecyclerAdapter(this, countries);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
}

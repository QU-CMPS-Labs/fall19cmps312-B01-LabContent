package com.cmps312.listrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryDetails extends AppCompatActivity {

    private ImageView countryFlag;
    private TextView nameTv;
    private TextView capitalTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        countryFlag = findViewById(R.id.flag_image);
        nameTv = findViewById(R.id.name_tv);
        capitalTv = findViewById(R.id.capital_tv);


        Country country = getIntent().getParcelableExtra("country");

        countryFlag.setImageResource(country.getFlag());
        nameTv.setText(country.getName());
        capitalTv.setText(country.getCapital());

    }
}

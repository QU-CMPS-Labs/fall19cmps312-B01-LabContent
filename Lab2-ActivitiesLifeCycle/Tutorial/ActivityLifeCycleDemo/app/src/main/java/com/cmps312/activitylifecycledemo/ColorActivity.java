package com.cmps312.activitylifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {

    RadioGroup colorGroup;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        colorGroup= findViewById(R.id.colorGroup);

        colorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.redBtn:
                        tv.setTextColor(Color.RED);
                        break;
                    case R.id.greenBtn:
                        tv.setTextColor(Color.RED);
                        break;
                }
            }
        });
    }
}

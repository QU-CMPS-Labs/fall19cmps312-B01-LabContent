package com.cmps312.threadingb01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ThreadLog";
    TextView progressTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressTv = findViewById(R.id.progress_tv);
    }

    public void startThread(View view) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    final int current = i;
                   //first way
//                    progressTv.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            progressTv.setText(String.valueOf(current));
//                        }
//                    });

                    //second way



                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}

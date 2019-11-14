package com.cmps312.threadingb01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ThreadLog";
    TextView progressTv;
    ProgressBar progressBar;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressTv = findViewById(R.id.progress_tv);
        progressBar = findViewById(R.id.progressBar);

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                progressTv.setText(String.valueOf(msg.arg1));
                progressBar.setProgress(msg.arg1*10);
                if(msg.arg1==10)
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        };
    }

    public void startThread(View view) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    final int current = i;

                    Message message = new Message();
                    message.arg1 = current;

                    handler.sendMessage(message);


                    //first way
//                    progressTv.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            progressTv.setText(String.valueOf(current));
//                        }
//                    });

                    //second way

//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            progressTv.setText(String.valueOf(current));
//                        }
//                    });


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

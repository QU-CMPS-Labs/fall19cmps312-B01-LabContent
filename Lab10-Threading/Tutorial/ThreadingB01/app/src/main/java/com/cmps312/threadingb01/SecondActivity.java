package com.cmps312.threadingb01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView progressTv;
    private ProgressBar progressBar;
    private volatile boolean stopThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        progressBar = findViewById(R.id.progressBar);
        progressTv = findViewById(R.id.progress_tv);
    }

    public void startAsyncThread(View view) {
        stopThread = false;
        DownoadProfilesAsync downoadProfilesAsync = new DownoadProfilesAsync();
        downoadProfilesAsync.execute(1000);
    }

    public void stopThread(View view) {
        stopThread = true;
    }


    class DownoadProfilesAsync extends AsyncTask<Integer, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressTv.setText("Ready to start the thread");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i <= 10; i++) {

                if(stopThread)
                    return "Interrupted before completion";

                try {
                    Thread.sleep(integers[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i * 10);
            }
            return "Finished Downloading";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            progressTv.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressTv.setText(s);
        }
    }
}

package com.cmps312.threadingb01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView progressTv ;
    ProgressBar progressBar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        progressBar = findViewById(R.id.progressBar);
        progressTv = findViewById(R.id.progress_tv);
    }

    public void startAsyncThread(View view) {

        DownoadProfilesAsync downoadProfilesAsync = new DownoadProfilesAsync();
        downoadProfilesAsync.execute(1000);
    }


    class DownoadProfilesAsync extends AsyncTask<Integer, Integer , String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressTv.setText("Ready to start the thread");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i <=10; i++) {
                try {
                    Thread.sleep(integers[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i*10);
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

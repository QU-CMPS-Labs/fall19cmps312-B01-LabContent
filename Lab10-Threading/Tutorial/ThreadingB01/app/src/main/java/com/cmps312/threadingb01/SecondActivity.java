package com.cmps312.threadingb01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

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
        DownloadProfilesAsync downoadProfilesAsync = new DownloadProfilesAsync(this);
        downoadProfilesAsync.execute(1000);
    }

    public void stopThread(View view) {
        stopThread = true;
    }


    //step 1.

    static class DownloadProfilesAsync extends AsyncTask<Integer, Integer, String> {

        //step 2. Create a weak reference
        private WeakReference<SecondActivity> weakReference;

        //step 3. create the constructor that initializes the weakreference
        public DownloadProfilesAsync(SecondActivity activity) {
            weakReference = new WeakReference<>(activity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            SecondActivity activity = weakReference.get();

            if (activity != null && !activity.isFinishing())
                activity.progressTv.setText("Ready to start the thread");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            SecondActivity activity = weakReference.get();


            for (int i = 0; i <= 10; i++) {
                if (activity == null || activity.isFinishing())
                    return null;

                if (activity.stopThread)
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

            SecondActivity activity = weakReference.get();
            if (activity != null && !activity.isFinishing()) {
                activity.progressBar.setProgress(values[0]);
                activity.progressTv.setText(String.valueOf(values[0]));
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            SecondActivity activity = weakReference.get();
            if (activity != null && !activity.isFinishing()) {
                activity.progressTv.setText(s);

            }
        }
    }
}

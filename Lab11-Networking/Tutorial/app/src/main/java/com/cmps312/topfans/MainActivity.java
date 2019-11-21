package com.cmps312.topfans;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cmps312.topfans.httpRequests.UsersClient;
import com.cmps312.topfans.models.Result;
import com.cmps312.topfans.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.cmps312.topfans.httpRequests.UsersClient.BASE_URL;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MYMainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void downloadUsers(View view) {

        //Step 1

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Step 2

        UsersClient client = retrofit.create(UsersClient.class);

        //Step 3
        Call<Result> call = client.getUsers("5", "json");

        //Step 4

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                ArrayList<User> users = result.getUsers();

                User user = users.get(0);

                Toast.makeText(MainActivity.this, user.getEmail(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage() + "\n" + t.getCause());
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

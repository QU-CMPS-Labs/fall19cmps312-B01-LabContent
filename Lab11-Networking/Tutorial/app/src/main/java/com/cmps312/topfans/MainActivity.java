package com.cmps312.topfans;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cmps312.topfans.adapter.MyUserAdapter;
import com.cmps312.topfans.httpRequests.UsersClient;
import com.cmps312.topfans.models.Result;
import com.cmps312.topfans.models.User;

import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static com.cmps312.topfans.httpRequests.UsersClient.BASE_URL;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MyUserAdapter adapter;
    private ArrayList<User> users;

    public static final String TAG = "MYMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void downloadUsers(View view) {

        //Step 1

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
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
                users = result.getUsers();
                adapter = new MyUserAdapter(MainActivity.this, users);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage() + "\n" + t.getCause());
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

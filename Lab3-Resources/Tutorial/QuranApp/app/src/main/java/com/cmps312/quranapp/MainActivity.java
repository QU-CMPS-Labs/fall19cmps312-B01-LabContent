package com.cmps312.quranapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] quranChapters;
    private TextView quranChaptersTv;

    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quranChapters = getResources().getStringArray(R.array.quran_chapters);
        quranChaptersTv = findViewById(R.id.chapters);

        imgView = findViewById(R.id.imageView);

        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (String chapter : quranChapters) {
            sb.append(i++ + "-")
                    .append(chapter)
                    .append("\n");
        }
        imgView.setImageResource(R.drawable.holy_quran_cover);

        quranChaptersTv.setText(sb.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

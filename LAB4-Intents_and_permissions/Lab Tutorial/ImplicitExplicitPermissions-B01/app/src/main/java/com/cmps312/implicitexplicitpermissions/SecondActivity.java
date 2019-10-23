package com.cmps312.implicitexplicitpermissions;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SecondActivity extends AppCompatActivity {

    private TextView scoreTv;
    private int score;
    public static final int REQUEST_CODE = 101;
    public String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        score = getIntent().getIntExtra("score", 0);
        scoreTv = findViewById(R.id.score_tv);
        scoreTv.setText(score + "");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        score = intent.getIntExtra("score", 0);
        scoreTv.setText(score + "");

        super.onNewIntent(intent);
    }

    public void incrementScore(View view) {
        Intent intent = new Intent(MainActivity.OPEN_SECOND_ACTIVITY);
        intent.putExtra("score", ++score);
        startActivity(intent);
    }

    public void onEmailSend(View view) {


        //1 . You have the permission so you do need to ask
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "You have the permission", Toast.LENGTH_SHORT).show();
            sendEmail();
        }

        //2. You do not have the permission so you need to ask
        else {
            requestUserPermission();
        }

    }

    private void requestUserPermission() {

        //2.1 I asked before and I was denied
        //===>Maybe the user did not understood why I needed this permission.

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
            //show the explanation
            //dialog box explaining why we need this permission
            showRationaleDialog();
        } else {
            ActivityCompat.requestPermissions(this,
                    permissions,
                    REQUEST_CODE);
        }

    }

    private void showRationaleDialog() {

        new AlertDialog.Builder(this)
                .setTitle("Permission Request")
                .setMessage("We need this permission because to attach the image, we should access your phones memory card")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(SecondActivity.this,
                                permissions,
                                REQUEST_CODE);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SecondActivity.this, "Sorry, we can send without the permission", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendEmail();
            } else {
                Toast.makeText(this, "You should give use the permission to attach the image", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void sendEmail() {
        Toast.makeText(this, " I can send", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"abdulahi@qu.edu.qa", "bk1509189@qu.edu.qa"});
//        intent.putExtra(Intent.EXTRA_SUBJECT, "My First EMail From Android Intent");
//        intent.putExtra(Intent.EXTRA_TEXT, "Hello Mr. X , I am sending you this email because ....");
//        //we want to make an attachment
//        intent.setData(Uri.parse("mailto:"));
//        startActivity(Intent.createChooser(intent, "Choose the mailing client"));
    }
}

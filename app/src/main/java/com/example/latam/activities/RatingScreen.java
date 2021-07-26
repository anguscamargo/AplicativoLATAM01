package com.example.latam.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.pets.R;

public class RatingScreen extends AppCompatActivity {
    RatingBar ratingBar01, ratingBar02, ratingBar03, ratingBar04, ratingBar05;
    Button btSubmit, openCamera;
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_screen_activity);

        ratingBar01 = findViewById(R.id.rating_bar01);
        ratingBar02 = findViewById(R.id.rating_bar02);
        ratingBar03 = findViewById(R.id.rating_bar03);
        ratingBar04 = findViewById(R.id.rating_bar04);
        ratingBar05 = findViewById(R.id.rating_bar05);
        btSubmit = findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = String.valueOf(ratingBar01.getRating());
                String s2 = String.valueOf(ratingBar02.getRating());
                String s3 = String.valueOf(ratingBar03.getRating());
                String s4 = String.valueOf(ratingBar04.getRating());
                String s5 = String.valueOf(ratingBar05.getRating());
                Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), s2, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), s3, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), s4, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), s5, Toast.LENGTH_SHORT).show();
            }
        });

        imageView = findViewById(R.id.capturedImage);
        openCamera = findViewById(R.id.openCamera);
        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(photo);
    }
}
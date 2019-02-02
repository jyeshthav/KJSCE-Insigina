package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.github.chrisbanes.photoview.PhotoView;

public class fullImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        int year = intent.getIntExtra("year",0);
        int event = intent.getIntExtra("event",0);

        ImageAdapter imageAdapter = new ImageAdapter(this, year, event);
        PhotoView photoView = (PhotoView) findViewById(R.id.imageView2);
        photoView.setImageResource(imageAdapter.setCard(year,event)[position]);

    }
}

package com.android.example.kjsceinsignia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class exploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new exploreAdapter(this));
    }
}

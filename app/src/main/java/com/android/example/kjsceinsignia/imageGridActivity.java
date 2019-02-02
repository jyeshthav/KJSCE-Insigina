package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class imageGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        Intent i = getIntent();
        final int year = i.getIntExtra("index", 0);
        final int event = i.getIntExtra("event", 0);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, year, event));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
//                Toast.makeText(imageGridActivity.this, "" + position,
//                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(imageGridActivity.this, fullImageActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("year", year);
                intent.putExtra("event", event);
                startActivity(intent);
            }
        });
    }
}

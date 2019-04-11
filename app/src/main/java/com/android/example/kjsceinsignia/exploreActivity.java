package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

public class exploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        final ImageDB db = new ImageDB(this);
        List<Image> imageList = db.getAllImages();

        if(imageList.size() == 0){
            TextView tv = findViewById(R.id.fav_text);
            tv.setVisibility(View.VISIBLE);
        }
        else{
            GridView gridview = (GridView) findViewById(R.id.exp_grid);
            gridview.setAdapter(new exploreAdapter(this, R.layout.exp_image, imageList));

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    Intent intent = new Intent(exploreActivity.this, fullImageActivity.class);
                    intent.putExtra("index", position);
                    startActivity(intent);
                }
            });
        }
    }
}

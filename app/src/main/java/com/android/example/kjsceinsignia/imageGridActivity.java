package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class imageGridActivity extends AppCompatActivity {

//    FirebaseStorage storage = FirebaseStorage.getInstance();
//    StorageReference storageRef = storage.getReference();
//    StorageReference imagesRef = storageRef.child("16-17");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
//        FirebaseApp.initializeApp(this);

        Intent i = getIntent();
        final int year = i.getIntExtra("index", 0);
        final int event = i.getIntExtra("event", 0);

        GridView gridview = (GridView) findViewById(R.id.gridview);

        final List<String> uriList;
        uriList = new ArrayList<String>();
        final String path,eventPath;
        String temp;

        switch(year){
            case 0:
                path = "16-17/";
                break;
            case 1:
                path = "17-18/";
                break;
            case 2:
                path = "18-19/";
                break;
            default:
                path = "Logo/";
                break;
        }

        switch(event){
            case 0:
                temp = (16+year) + "fre";
                eventPath = path.concat(temp);
                break;
            case 1:
                temp = (16+year) + "abhi";
                eventPath = path.concat(temp);
                break;
            case 2:
                temp = (17+year) + "skr";
                eventPath = path.concat(temp);
                break;
            case 3:
                temp = (17+year) + "sym";
                eventPath = path.concat(temp);
                break;
            case 4:
                temp = (17+year) + "ot";
                eventPath = path.concat(temp);
                break;
            default:
                eventPath = path.concat("logo1.jpg");
                break;
        }

        if(year == 0 || year == 1 || year == 2){
            String path1, path2;
            path1 = eventPath.concat("1.jpg");
            path2 = eventPath.concat("2.jpg");
            uriList.add(path1);
            uriList.add(path2);
        }
        else{
            uriList.add(path);
        }

        gridview.setAdapter(new fbAdapter(imageGridActivity.this, uriList));
//        gridview.setAdapter(new ImageAdapter(imageGridActivity.this, year, event));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
//                Toast.makeText(imageGridActivity.this, "" + position,
//                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(imageGridActivity.this, fullImageActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("year", year);
                intent.putExtra("event", event);
                intent.putExtra("check", 1);
                intent.putExtra("path", eventPath);
                startActivity(intent);
            }
        });
    }
}

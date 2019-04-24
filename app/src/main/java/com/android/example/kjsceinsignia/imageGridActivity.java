package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    List<String> uriList;
    String eventPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        mRecyclerView = (RecyclerView) findViewById(R.id.image_grid_rv);

        Intent i = getIntent();
        final int year = i.getIntExtra("index", 0);
        final int event = i.getIntExtra("event", 0);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        uriList = new ArrayList<String>();
        final String path;
        String temp;
        int n;

        switch(event){
            case 0:
                switch(year){
                    case 0:
                        path = "16-17/";
                        n = 6;              // number of images for freshers 16
                        break;
                    case 1:
                        path = "17-18/";
                        n = 7;              // number of images for freshers 17
                        break;
                    case 2:
                        path = "18-19/";
                        n = 3;              // number of images for freshers 18
                        break;
                    default:
                        path = "";
                        n = 1;
                        break;
                }
                temp = (16+year) + "fre";
                eventPath = path.concat(temp);
                break;
            case 1:
                switch(year){
                    case 0:
                        path = "16-17/";
                        n = 12;              // number of images for abhiyantriki 16
                        break;
                    case 1:
                        path = "17-18/";
                        n = 11;              // number of images for abhiyantriki 17
                        break;
                    case 2:
                        path = "18-19/";
                        n = 7;              // number of images for abhiyantriki 18
                        break;
                    default:
                        path = "";
                        n = 1;
                        break;
                }
                temp = (16+year) + "abhi";
                eventPath = path.concat(temp);
                break;
            case 2:
                switch(year){
                    case 0:
                        path = "16-17/";
                        n = 1;              // number of images for skream 17
                        break;
                    case 1:
                        path = "17-18/";
                        n = 1;              // number of images for skream 18
                        break;
                    case 2:
                        path = "18-19/";
                        n = 2;              // number of images for skream 19
                        break;
                    default:
                        path = "";
                        n = 1;
                        break;
                }
                temp = (17+year) + "skr";
                eventPath = path.concat(temp);
                break;
            case 3:
                switch(year){
                    case 0:
                        path = "16-17/";
                        n = 8;              // number of images for symphony 17
                        break;
                    case 1:
                        path = "17-18/";
                        n = 26;              // number of images for symphony 18
                        break;
                    case 2:
                        path = "18-19/";
                        n = 9;              // number of images for symphony 19
                        break;
                    default:
                        path = "";
                        n = 1;
                        break;
                }
                temp = (17+year) + "sym";
                eventPath = path.concat(temp);
                break;
            case 4:
                switch(year){
                case 0:
                    path = "16-17/";
                    n = 9;              // number of images for other events 17
                    break;
                case 1:
                    path = "17-18/";
                    n = 16;              // number of images for other events 18
                    break;
                case 2:
                    path = "18-19/";
                    n = 3;              // number of images for other events 19
                    break;
                default:
                    path = "";
                    n = 1;
                    break;
            }
                temp = (17+year) + "ot";
                eventPath = path.concat(temp);
                break;
            default:
                path = "Logo/";
                n = 1;
                eventPath = path.concat("logo");
                break;
        }

        if(year == 0 || year == 1 || year == 2){
            String path1, path2;
            for(int k = 0; k < n; k++){
                int s = k + 1;
                String st = Integer.toString(s);
                path1 = eventPath.concat(st);
                path2 = path1.concat(".jpg");
                uriList.add(path2);
            }
        }
        else{
            uriList.add(path);
        }

        mAdapter = new ImageAdapter(this, uriList);
        mRecyclerView.setAdapter(mAdapter);
    }
    public void openImage(View v){
        Intent intent = new Intent(imageGridActivity.this, fullImageActivity.class);
        TextView tv = v.findViewById(R.id.index);
        int index = Integer.parseInt(tv.getText().toString());
        intent.putExtra("position", index);
        intent.putExtra("check", 1);
        intent.putExtra("path", eventPath);
        startActivity(intent);
    }
}

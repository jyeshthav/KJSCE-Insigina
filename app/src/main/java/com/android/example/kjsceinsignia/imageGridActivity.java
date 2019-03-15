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

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();
    StorageReference imagesRef = storageRef.child("16-17");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        FirebaseApp.initializeApp(this);

//        Intent i = getIntent();
//        final int year = i.getIntExtra("index", 0);
//        final int event = i.getIntExtra("event", 0);

        GridView gridview = (GridView) findViewById(R.id.gridview);

        final List<String> uriList;
        uriList = new ArrayList<String>();

        imagesRef.child("s1.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                uriList.add(uri.toString());
                Toast.makeText(getBaseContext(), uriList.get(0), Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Toast.makeText(getBaseContext(), exception.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        imagesRef.child("s2.png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                uriList.add(uri.toString());
                Toast.makeText(getBaseContext(), "2", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Toast.makeText(getBaseContext(), exception.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        gridview.setAdapter(new fbAdapter(imageGridActivity.this, uriList));
//        gridview.setAdapter(new ImageAdapter(imageGridActivity.this, year, event));
//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
////                Toast.makeText(imageGridActivity.this, "" + position,
////                        Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(imageGridActivity.this, fullImageActivity.class);
//                intent.putExtra("position", position);
//                intent.putExtra("year", year);
//                intent.putExtra("event", event);
//                intent.putExtra("check", 1);
//                startActivity(intent);
//            }
//        });
    }
}

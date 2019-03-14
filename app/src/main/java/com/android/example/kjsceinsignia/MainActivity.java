package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        mStorageRef = FirebaseStorage.getInstance().getReference("Logo");

        String url = "https://firebasestorage.googleapis.com/v0/b/kjsceinsignia.appspot.com/o/Logo%2Flogo1.jpg?alt=media&token=f87f4c51-28e2-4fff-8dba-6402041e2c73";
        //url ke saath chal raha hai
        Glide.with(this /* context */)
                .load(mStorageRef)
                .into(imageView);
    }
    // onClick button function
    public void openHome(View v){
        Intent intent = new Intent(this, tabbedActivity.class);
        startActivity(intent);
    }
}

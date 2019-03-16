package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class fullImageActivity extends AppCompatActivity {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();
    private Uri imgUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        FirebaseApp.initializeApp(this);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        int year = intent.getIntExtra("year",0);
        int event = intent.getIntExtra("event",0);
        int check = intent.getIntExtra("check",0);
        String eventPath = intent.getStringExtra("path");
        int index = intent.getIntExtra("index",0);

        if (check == 1) {
            String pos = Integer.toString(position+1);
            String imgPath = eventPath.concat(pos + ".jpg");

            final PhotoView photoView = (PhotoView) findViewById(R.id.imageView2);

            storageRef.child(imgPath).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    imgUri = uri;
                    Glide.with(getBaseContext()).load(imgUri).into(photoView);
//                    Toast.makeText(mContext, "url fetch", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                    Toast.makeText(getBaseContext(), exception.toString(), Toast.LENGTH_SHORT).show();
                }
            });

//            ImageAdapter imageAdapter = new ImageAdapter(this, year, event);
//            photoView.setImageResource(imageAdapter.setCard(year, event)[position]);

            RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    Toast.makeText(fullImageActivity.this, "" + ratingBar.getRating(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            exploreAdapter expAdapter = new exploreAdapter(this);
            PhotoView photoView = (PhotoView) findViewById(R.id.imageView2);
//            photoView.setImageResource(expAdapter.explore_images[index]);
            Glide.with(getBaseContext()).load(expAdapter.explore_images[index]).into(photoView) ;

            RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    Toast.makeText(fullImageActivity.this, "" + ratingBar.getRating(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

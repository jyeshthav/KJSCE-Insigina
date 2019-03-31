package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        int check = intent.getIntExtra("check",0);
        String eventPath = intent.getStringExtra("path");
        final int index = intent.getIntExtra("index",0);

        Button share = (Button) findViewById(R.id.share);
        Button favorite = (Button) findViewById(R.id.favorite);

        if (check == 1) {
            String pos = Integer.toString(position+1);
            String imgPath = eventPath.concat(pos + ".jpg");

            final PhotoView photoView = (PhotoView) findViewById(R.id.imageView2);

            //placeholder
            Glide.with(getBaseContext()).load(R.drawable.placeholder).into(photoView);

            storageRef.child(imgPath).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    imgUri = uri;
                    Glide.with(getBaseContext()).load(imgUri).into(photoView);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                    Toast.makeText(getBaseContext(), exception.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent share_intent = new Intent(Intent.ACTION_SEND);
                    Toast.makeText(getBaseContext(), "Add to favorites for sharing!", Toast.LENGTH_SHORT).show();
                }
            });

            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), "Added to favorites", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            final exploreAdapter expAdapter = new exploreAdapter(this);
            PhotoView photoView = (PhotoView) findViewById(R.id.imageView2);
            Glide.with(getBaseContext()).load(expAdapter.explore_images[index]).into(photoView) ;

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int resource = expAdapter.explore_images[index];
                    Bitmap bitmap= BitmapFactory.decodeResource(getResources(), resource);
                    String path = getExternalCacheDir()+"/logo.png";
                    java.io.OutputStream out = null;
                    java.io.File file=new java.io.File(path);
                    try {
                        out = new java.io.FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                        out.flush();
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    path = file.getPath();
                    Uri bmpUri = Uri.parse(path);

                    Intent shareIntent = new Intent();
                    shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                    shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
                    shareIntent.setType("image/jpg");
                    startActivity(Intent.createChooser(shareIntent,"Share with"));
//                    Toast.makeText(getBaseContext(), bmpUri.toString(), Toast.LENGTH_SHORT).show();
                }
            });


            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), "Already in favorites!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

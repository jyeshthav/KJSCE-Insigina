package com.android.example.kjsceinsignia;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImagesViewHolder>{

    private Context mContext;
    private List<String> uriList;
    private Uri imgUri;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();

    public ImageAdapter(Context c, List<String> uriList) {
        this.mContext = c;
        this.uriList = uriList;
    }

    public static class ImagesViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;
        public ImagesViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.grid_image);
            text = v.findViewById(R.id.index);
        }
    }

    @NonNull
    @Override
    public ImageAdapter.ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_images, parent, false);

        ImageAdapter.ImagesViewHolder vh = new ImageAdapter.ImagesViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageAdapter.ImagesViewHolder holder, int position) {
        Glide.with(mContext)
                .load(R.drawable.placeholder)
                .into(holder.image);

        holder.text.setText(String.valueOf(position));

        storageRef.child(uriList.get(position)).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                imgUri = uri;
                Glide.with(mContext)
                        .load(imgUri)
                        .into(holder.image);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Toast.makeText(mContext, exception.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return uriList.size();
    }

}
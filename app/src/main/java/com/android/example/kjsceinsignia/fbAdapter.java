package com.android.example.kjsceinsignia;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class fbAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> uriList;
    private Uri imgUri;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();

    public fbAdapter(Context c, List<String> uriList) {
        this.mContext = c;
        this.uriList = uriList;
    }
    @Override
    public int getCount() {
        return uriList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView imageView;
        if (convertView == null) {

            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, 370));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

            //placeholder
            Glide.with(mContext)
                    .load(R.drawable.placeholder)
                    .into(imageView);

            storageRef.child(uriList.get(position)).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    imgUri = uri;
                    Glide.with(mContext)
                            .load(imgUri)
                            .into(imageView);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                    Toast.makeText(mContext, exception.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            imageView = (ImageView) convertView;
        }
        return imageView;
    }
}

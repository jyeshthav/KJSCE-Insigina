package com.android.example.kjsceinsignia;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class fbAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> uriList;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, 820));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
//            imageView.setImageResource(R.drawable.s1);
        } else {
            imageView = (ImageView) convertView;
        }
//        Glide.with(mContext).load(R.drawable.s1).into(imageView);
        Glide.with(mContext).load(Uri.parse(uriList.get(position))).into(imageView);
        return imageView;
    }
}

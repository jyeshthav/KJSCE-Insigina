package com.android.example.kjsceinsignia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

public class exploreAdapter extends ArrayAdapter<Image> {
    Context mContext;
    int resource;
    List<Image> imageList;

    public exploreAdapter(Context context, int resource, List<Image> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.resource = resource;
        this.imageList = objects;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.exp_image);
        TextView name = (TextView) convertView.findViewById(R.id.exp_text);
        Image imgItem = imageList.get(position);

        Glide.with(mContext).load(imgItem.getBytes()).into(imageView);
        return imageView;
    }

}

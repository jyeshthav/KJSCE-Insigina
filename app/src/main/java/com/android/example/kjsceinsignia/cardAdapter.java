package com.android.example.kjsceinsignia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.MyViewHolder> {

    private Context mCon;
    private List<cardEvents> eventsList;
    private Integer[] images = { R.drawable.s1, R.drawable.s2, R.drawable.s3,
            R.drawable.s4, R.drawable.s5, R.drawable.s6, R.drawable.s7,
            R.drawable.s8, R.drawable.s9, R.drawable.s10, R.drawable.s11,
            R.drawable.s12, R.drawable.s13, R.drawable.s14, R.drawable.s15
    };

    public cardAdapter(Context mCon, List<cardEvents> eventsList) {
        this.mCon = mCon;
        this.eventsList = eventsList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;
        public TextView year;
        public TextView event;

        public MyViewHolder(View v) {
            super(v);
            text = v.findViewById(R.id.info_text);
            image = v.findViewById(R.id.image_view);
            year = v.findViewById(R.id.info_text2);
            event = v.findViewById(R.id.info_text3);
        }
    }

    @NonNull
    @Override
    public cardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_items, parent, false);

        cardAdapter.MyViewHolder vh = new cardAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull cardAdapter.MyViewHolder holder, int position) {
        cardEvents card = eventsList.get(position);
        holder.text.setText(card.getName());
        holder.year.setText(Integer.toString(card.getYear()));
        holder.event.setText(Integer.toString(card.getEvent()));
//        holder.image.setImageResource(event.getImage_id());
        Glide.with(mCon).load(images[card.getImage_id()]).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }
}

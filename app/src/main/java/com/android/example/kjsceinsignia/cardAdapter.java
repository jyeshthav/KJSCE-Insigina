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
    private Integer[] images = { R.drawable.fre1, R.drawable.abhi1, R.drawable.skr1,
            R.drawable.sym1, R.drawable.ot1, R.drawable.fre2, R.drawable.abhi2,
            R.drawable.skr2, R.drawable.sym2, R.drawable.ot2, R.drawable.fre3,
            R.drawable.abhi3, R.drawable.skr3, R.drawable.sym3, R.drawable.ot3
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
        Glide.with(mCon).load(images[card.getImage_id()]).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }
}

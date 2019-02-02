package com.android.example.kjsceinsignia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class galleryTab extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab_gallery,container, false);
        GridView gridView = (GridView) view.findViewById(R.id.yeargridview);
        gridView.setAdapter(new yearAdapter(view.getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent i  = new Intent(view.getContext(), rvCardsActivity.class);
                i.putExtra("year", position);
                startActivity(i);
            }
        });
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}


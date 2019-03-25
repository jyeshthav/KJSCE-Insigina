package com.android.example.kjsceinsignia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class timelineTab extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<timelineItems> tlist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_timeline,container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.timeline_rv);
        timelineAdapter rvAdapter = new timelineAdapter(getContext(),tlist);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(rvAdapter);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tlist = new ArrayList<>();
        for (int i = 1; i<=20; i++){
            timelineItems listItem = new timelineItems("item " + i);
            tlist.add(listItem);
        }
    }
}


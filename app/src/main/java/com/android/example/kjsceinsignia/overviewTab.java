package com.android.example.kjsceinsignia;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatViewInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class overviewTab extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_overview,container, false);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}


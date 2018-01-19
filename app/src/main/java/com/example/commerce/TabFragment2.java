package com.example.commerce;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class TabFragment2 extends Fragment{
    View view;
    GridView gridView;
    GridViewAdapter adapterViewAndroid2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.tab_fragment_2, container, false);


        return view;}

}

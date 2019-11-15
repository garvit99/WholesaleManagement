package com.example.wholesalemanagementsystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;


public class FragmentOrder extends Fragment {
    private GridView gridView;
    private ImageView imageView;
    public static String[] osNameList = {
            "Android",
            "iOS",
            "Linux",
            "MacOS",
            "MS DOS",
            "Symbian",
            "Windows 10",
            "Windows XP",
    };
    public static int[] osImages = {
            R.drawable.splash,
            R.drawable.splash,
            R.drawable.splash,
            R.drawable.splash,
            R.drawable.splash,
            R.drawable.splash,
            R.drawable.splash,
            R.drawable.splash
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container,
                false);
        //GridView gridView = (GridView) view.findViewById(R.id.gridhome);
        //gridView.setAdapter(new CustomAdapter(view.getContext(),osNameList,osImages));

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("ORDER");
    }
}
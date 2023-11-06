package com.animsh.runningtracker.bottomnav;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.animsh.runningtracker.R;


public class HomeFragment extends Fragment {

    ImageView iconHeart1, iconHeart2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        iconHeart1 = view.findViewById(R.id.icon_heart);
        iconHeart2 = view.findViewById(R.id.icon_heart2);
        return view;
    }

}
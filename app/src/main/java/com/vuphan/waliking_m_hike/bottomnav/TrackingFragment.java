package com.vuphan.waliking_m_hike.bottomnav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.vuphan.waliking_m_hike.R;

public class TrackingFragment extends Fragment {
    ImageView btn_back;
    FrameLayout btn_map;
    MapFragment mapFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tracking, container, false);
        btn_back = view.findViewById(R.id.btn_back);
        btn_map = view.findViewById(R.id.btn_map);
        btn_map.setOnClickListener(view12 -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_up, 0, 0, R.anim.slide_down);
            mapFragment = new MapFragment();
            fragmentTransaction.add(R.id.layout_fragment_main, mapFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
        btn_back.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });
        return view;
    }

}
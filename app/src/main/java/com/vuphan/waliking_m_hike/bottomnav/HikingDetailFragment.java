package com.vuphan.waliking_m_hike.bottomnav;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vuphan.waliking_m_hike.R;

public class HikingDetailFragment extends Fragment {

    LinearLayout btn_start_tracking;
    ImageView btn_back;
    TrackingFragment trackingFragment;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hiking_detail, container, false);
        btn_start_tracking = view.findViewById(R.id.btn_start_tracking);
        btn_back = view.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(view1 -> {
            requireActivity().onBackPressed();
        });
        btn_start_tracking.setOnClickListener(view12 -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_up, 0, 0, R.anim.slide_down);
            trackingFragment = new TrackingFragment();
            fragmentTransaction.add(R.id.layout_fragment_main, trackingFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
        return view;
    }
}
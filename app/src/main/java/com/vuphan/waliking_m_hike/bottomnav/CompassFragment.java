package com.vuphan.waliking_m_hike.bottomnav;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.vuphan.waliking_m_hike.R;

import java.util.Objects;

public class CompassFragment extends Fragment  {

    TextView btn_view_1, btn_view_2, btn_view_3;
    HikingDetailFragment hikingDetailFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compass, container, false);
        btn_view_1 = view.findViewById(R.id.btn_view_1);
        btn_view_2 = view.findViewById(R.id.btn_view_2);
        btn_view_3 = view.findViewById(R.id.btn_view_3);
        btn_view_1.setOnClickListener(view1 -> {
           createFragmentDetail();
        });
        btn_view_2.setOnClickListener(view1 -> {
            createFragmentDetail();
        });
        btn_view_3.setOnClickListener(view1 -> {
            createFragmentDetail();
        });
        return view;
    }

    private void createFragmentDetail(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_up, 0, 0, R.anim.slide_down);
        hikingDetailFragment = new HikingDetailFragment();
        fragmentTransaction.add(R.id.layout_fragment_main, hikingDetailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
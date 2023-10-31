package com.vuphan.waliking_m_hike.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vuphan.waliking_m_hike.R;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;
    private ViewPagerMainAdapter viewPagerAdapter;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        viewPagerAdapter = new ViewPagerMainAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                viewPager.setUserInputEnabled(false);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();
            if (itemId == R.id.menu_home) {
                viewPager.setCurrentItem(0);
                return true;
            } else if (itemId == R.id.menu_find) {
                viewPager.setCurrentItem(1);
                return true;
            } else if (itemId == R.id.menu_compass) {
                viewPager.setCurrentItem(2);
                return true;
            } else if (itemId == R.id.menu_calender) {
                viewPager.setCurrentItem(3);
                return true;
            } else if (itemId == R.id.menu_person) {
                viewPager.setCurrentItem(4);
                return true;
            }
            return false;
        });


    }
}
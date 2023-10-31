package com.vuphan.waliking_m_hike.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.vuphan.waliking_m_hike.bottomnav.CalenderFragment;
import com.vuphan.waliking_m_hike.bottomnav.CompassFragment;
import com.vuphan.waliking_m_hike.bottomnav.FindFragment;
import com.vuphan.waliking_m_hike.bottomnav.HomeFragment;
import com.vuphan.waliking_m_hike.bottomnav.PersonFragment;

public class ViewPagerMainAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 5;
    public ViewPagerMainAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new FindFragment();
            case 2:
                return new CompassFragment();
            case 3:
                return new CalenderFragment();
            case 4:
                return new PersonFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}

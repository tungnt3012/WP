package com.example.weatherprojecttt.ViewPagerAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.weatherprojecttt.Fragments.Fragment_Daily;
import com.example.weatherprojecttt.Fragments.Fragment_Hour;
import com.example.weatherprojecttt.Fragments.Fragment_Search;
import com.example.weatherprojecttt.Fragments.Fragment_Today;

public class ViewPagerAdaper extends FragmentStatePagerAdapter {
    public ViewPagerAdaper(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new Fragment_Today();
            case 1: return new Fragment_Hour();
            case 2: return new Fragment_Daily();
            case 3: return new Fragment_Search();
            default: return new Fragment_Today();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}

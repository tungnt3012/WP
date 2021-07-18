package com.example.weatherprojecttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.weatherprojecttt.Fragments.Fragment_Hour;
import com.example.weatherprojecttt.Fragments.Fragment_Search;
import com.example.weatherprojecttt.Fragments.Fragment_Today;
import com.example.weatherprojecttt.Model.Today;
import com.example.weatherprojecttt.ViewPagerAdapter.ViewPagerAdaper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Fragment_Search.ISendDataTodayListener {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        ViewPagerAdaper adapter = new ViewPagerAdaper(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        //handle scroll to fragment
        handleScollFragment(viewPager);
        //handle select bottom nav
        handleSelectBottomNav(bottomNavigationView);

    }

    private void handleScollFragment(ViewPager viewPager) {
        viewPager.setOnTouchListener(null);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.tab_today).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.tab_hour).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.tab_daily).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.tab_search).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void handleSelectBottomNav (BottomNavigationView bottomNavigationView) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab_today:
                        viewPager.setCurrentItem(0, true);
                        break;
                    case R.id.tab_hour:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case R.id.tab_daily:
                        viewPager.setCurrentItem(2, true);
                        break;
                    case R.id.tab_search:
                        viewPager.setCurrentItem(3, true);
                        break;
                }

                return true;
            }
        });
    }


    @Override
    public void sendData(Today today) {
//        Fragment_Today fragment_today = (Fragment_Today) getSupportFragmentManager().findFragmentById(R.id.view);
        Fragment_Today fragment_today = (Fragment_Today) viewPager.getAdapter().instantiateItem(viewPager, 0);
//        Fragment_Hour fragment_hour = (Fragment_Hour) viewPager.getAdapter().instantiateItem(viewPager, 1);
        fragment_today.setData(today);
//        fragment_hour.setTitle(txt);

    }
}
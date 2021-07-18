package com.example.weatherprojecttt;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class HourlyActivity extends AppCompatActivity {

    private ArrayList<Hourly> hourlies;
    private RecyclerView recyclerView;
    private HourlyAdapter hourlyAdapter;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hourly_fragment);
        hourlies = new ArrayList<>();
        recyclerView = findViewById(R.id.hourlyRV);
        View bottomsheet = findViewById(R.id.bottomSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        createHourlyList();
        hourlyAdapter = new HourlyAdapter(this,hourlies);
        recyclerView.setAdapter(hourlyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void createHourlyList() {
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));
        hourlies.add(new Hourly("11:00",32,"RealFeel39*",20));

    }

}

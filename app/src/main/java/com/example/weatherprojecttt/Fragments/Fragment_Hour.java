package com.example.weatherprojecttt.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherprojecttt.Hourly;
import com.example.weatherprojecttt.HourlyAdapter;
import com.example.weatherprojecttt.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Hour#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Hour extends Fragment {

    private ArrayList<Hourly> hourlies;
    private RecyclerView recyclerView;
    private HourlyAdapter hourlyAdapter;
    private BottomSheetBehavior bottomSheetBehavior;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Hour() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Hour.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Hour newInstance(String param1, String param2) {
        Fragment_Hour fragment = new Fragment_Hour();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;
        v = inflater.inflate(R.layout.fragment__hour, container, false);
        hourlies = new ArrayList<>();
        recyclerView = v.findViewById(R.id.hourlyRV);
        View bottomsheet = v.findViewById(R.id.bottomSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        hourlyAdapter = new HourlyAdapter(this,hourlies);
        recyclerView.setAdapter(hourlyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

}
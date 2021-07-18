package com.example.weatherprojecttt.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.weatherprojecttt.Model.Today;
import com.example.weatherprojecttt.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Today#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Today extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View mView;
    private TextView txtStatusToday;
    private TextView txtTemperatureToday;
    private TextView txtRealFeel_Today;
    private TextView txtHumidityToday;
    private TextView txtIndoorHumidityToday;
    private TextView txtWinSpeedToday;
    private TextView txtVisibilityToday;
    private TextView txtTodayCity;

    public Fragment_Today() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Today.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Today newInstance(String param1, String param2) {
        Fragment_Today fragment = new Fragment_Today();
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
        mView =  inflater.inflate(R.layout.fragment__today, container, false);
        txtStatusToday = mView.findViewById(R.id.txtStatusToday);
        txtTemperatureToday = mView.findViewById(R.id.txtTemperatureToday);
        txtRealFeel_Today = mView.findViewById(R.id.txtRealFeel_Today);
        txtHumidityToday = mView.findViewById(R.id.txtHumidityToday);
        txtIndoorHumidityToday = mView.findViewById(R.id.txtIndoorHumidityToday);
        txtWinSpeedToday = mView.findViewById(R.id.txtWinSpeedToday);
        txtVisibilityToday = mView.findViewById(R.id.txtVisibilityToday);
        txtTodayCity = mView.findViewById(R.id.txtTodayCity);
        return mView;
    }

    public void setData(Today today) {
        if(today == null) return;
        txtStatusToday.setText(today.getWeatherText());
        txtTemperatureToday.setText(today.getTemperature());
        txtRealFeel_Today.setText(today.getRealFeel());
        txtHumidityToday.setText(today.getRelativeHumidity());
        txtIndoorHumidityToday.setText(today.getIndoorRelativeHumidity());
        txtWinSpeedToday.setText(today.getWindSpeed());
        txtVisibilityToday.setText(today.getVisibility());
        txtTodayCity.setText(today.getCityName());
    }
}
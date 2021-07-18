package com.example.weatherprojecttt.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.weatherprojecttt.Common.ApiConfig;
import com.example.weatherprojecttt.MainActivity;
import com.example.weatherprojecttt.Model.ItemSearch;
import com.example.weatherprojecttt.Model.Today;
import com.example.weatherprojecttt.R;
import com.example.weatherprojecttt.Service.CallBackService;
import com.example.weatherprojecttt.Service.Service;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Fragment_Search extends Fragment {
    private TextInputEditText textInputSearch;
    private AutoCompleteTextView autoCompleteTextView;
    private MaterialButton btnSearch;
    private View mView;
    private Service service;
    private ListView listView;
    private ArrayList<ItemSearch> itemsSearch;
    private ArrayAdapter<ItemSearch> adapter;

    private ISendDataTodayListener mISendDataTodayListener;

    public interface ISendDataTodayListener {
        void sendData(Today today
        );
    }

    public Fragment_Search() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mISendDataTodayListener = (ISendDataTodayListener) getActivity();
        service = new Service(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment__search, container, false);

        textInputSearch = mView.findViewById(R.id.txtInputSearch);
        btnSearch = mView.findViewById(R.id.btnSearch);

        listView = mView.findViewById(R.id.listSearch);
        itemsSearch = new ArrayList<>();
        adapter = new ArrayAdapter<ItemSearch>(service.getCtx(), android.R.layout.simple_list_item_activated_1, itemsSearch);
        listView.setAdapter(adapter);

        handleSearchBtn();
        handleItemSearch();

        return mView;
    }

    private void handleItemSearch () {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ItemSearch item = itemsSearch.get(i);
                Toast.makeText(service.getCtx(), item.getKey(), Toast.LENGTH_SHORT).show();
                updateTextToday(item);
                itemsSearch.clear();
                listView.setAdapter(adapter);
            }
        });
    }

    private void handleSearchBtn () {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.v("context", ApiConfig.getToday("aa"));

                String txt = textInputSearch.getText().toString().trim();
                textInputSearch.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if(txt == null || txt.length() == 0) {
                    Toast.makeText(service.getCtx(), "Enter a location", Toast.LENGTH_SHORT).show();
                    return;
                }

                itemsSearch.clear();
                getResultSearch(txt);
                textInputSearch.setText("");
            }
        });
    }

    private void getResultSearch (String search) {
        service.getSearchResult(search, new CallBackService() {
            @Override
            public void onSuccess(JSONArray response) {
                Log.v("listSearch", response.length() +"");
                if(response.length() == 0) {
                    Toast.makeText(service.getCtx(), "No result available", Toast.LENGTH_LONG).show();
                    return;
                }

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject objectResponse = response.getJSONObject(i);
                        String key = objectResponse.getString("Key");

                        String cityName = objectResponse.getString("LocalizedName");
                        String country = objectResponse.getJSONObject("Country").getString("LocalizedName");
                        itemsSearch.add(new ItemSearch(key, cityName, country));
                    } catch (JSONException e) {
                        Toast.makeText(service.getCtx(), e.toString(), Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
                listView.setAdapter(adapter);
            }
            @Override
            public void onError(String msg) {
            }
        });

    }

    public void updateTextToday(ItemSearch itemSearch) {
        service.getDataToday(itemSearch.getKey(), new CallBackService() {
            @Override
            public void onSuccess(JSONArray response) {
                try {
                    JSONObject objectResponse = response.getJSONObject(0);
                    String weatherText = objectResponse.getString("WeatherText");
                    String temperature = objectResponse.getJSONObject("Temperature").getJSONObject("Metric").getString("Value");
                    String realFeel = objectResponse.getJSONObject("RealFeelTemperature").getJSONObject("Metric").getString("Value") + "°C";
                    String RelativeHumidity = objectResponse.getString("RelativeHumidity")+"%";
                    String IndoorRelativeHumidity = objectResponse.getString("IndoorRelativeHumidity")+"%";
                    String windSpeed = objectResponse.getJSONObject("Wind").getJSONObject("Speed").getJSONObject("Metric").getString("Value") + "km/h";
                    String visibility = objectResponse.getJSONObject("Visibility").getJSONObject("Metric").getString("Value") + "km";

                    Log.v("res", weatherText + " "+temperature  + " " + realFeel +" " + RelativeHumidity + " " + IndoorRelativeHumidity + " " + windSpeed + " " + visibility);
                    Today today = new Today(itemSearch.getCityName(),weatherText, temperature, realFeel, RelativeHumidity, IndoorRelativeHumidity, windSpeed, visibility);
                    mISendDataTodayListener.sendData(today);
                } catch (JSONException e) {
                    Toast.makeText(service.getCtx(), e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String msg) {
                Toast.makeText(service.getCtx(),msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
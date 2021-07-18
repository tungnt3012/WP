package com.example.weatherprojecttt.Service;

import com.example.weatherprojecttt.Model.Today;

import org.json.JSONArray;

public interface CallBackService {
    void onSuccess(JSONArray array);
    void onError(String msg);
}

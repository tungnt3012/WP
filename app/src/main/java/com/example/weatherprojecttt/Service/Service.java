package com.example.weatherprojecttt.Service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.weatherprojecttt.Common.ApiConfig;

import org.json.JSONArray;

public class Service {
    private Context ctx;
    public Service(Context ctx) {
        this.ctx = ctx;
    }

    public Context getCtx () {
        return this.ctx;
    }

    public void getDataToday(String locationKey, CallBackService callback) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, ApiConfig.getToday(locationKey), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error.toString());
            }
        });

        MySingleton.getInstance(ctx).addToRequestQueue(request);
    }

    public void getSearchResult(String locationSearch, CallBackService callback ) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, ApiConfig.getAutoComplete(locationSearch), null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(error.toString());
            }
        });

        MySingleton.getInstance(ctx).addToRequestQueue(request);
    }

}

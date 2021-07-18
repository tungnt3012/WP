package com.example.weatherprojecttt.Common;

public class ApiConfig {
    public static final String URL = "http://dataservice.accuweather.com/";
    public static final String API_KEY = "bIqOhsBh9D6w30knRoYxKO29ZGaCQ8bB";
    public static final String Fixed_Key_Location = "353412"; //hanoi key

    public static String getToday (String keyLocation) {
        return URL+"currentconditions/v1/" + keyLocation +"?apikey="+API_KEY+"&details=true";
    }

    public static String getAutoComplete(String keySearch) {
        return URL+"locations/v1/cities/autocomplete?apikey="+API_KEY+"&q="+keySearch.trim();
    }
}

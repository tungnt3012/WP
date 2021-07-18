package com.example.weatherprojecttt.Model;

public class ItemSearch {
    private String key;
    private String cityName;
    private String countryName;

    public ItemSearch (String key, String city, String countryName) {
        this.key = key;
        this.cityName = city;
        this.countryName = countryName;
    }

    public String getKey() {
        return key;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String toString() {
        return getCityName() + " - " + getCountryName();
    }
}

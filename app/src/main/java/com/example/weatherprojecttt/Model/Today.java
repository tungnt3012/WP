package com.example.weatherprojecttt.Model;

public class Today {
    private String cityName;
    private String weatherText;
    private String temperature;
    private String realFeel;
    private String relativeHumidity;
    private String indoorRelativeHumidity;
    private String windSpeed;
    private String visibility;


    public Today(String cityName, String weatherText, String temperature, String realFeel, String relativeHumidity, String indoorRelativeHumidity, String windSpeed, String visibility) {
        this.cityName = cityName;
        this.weatherText = weatherText;
        this.temperature = temperature;
        this.realFeel = realFeel;
        this.relativeHumidity = relativeHumidity;
        this.indoorRelativeHumidity = indoorRelativeHumidity;
        this.windSpeed = windSpeed;
        this.visibility = visibility;
    }

    public String getCityName() {
        return cityName;
    }
    public String getWeatherText() {
        return weatherText;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getRealFeel() {
        return realFeel;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public String getIndoorRelativeHumidity() {
        return indoorRelativeHumidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getVisibility() {
        return visibility;
    }
}

package com.example.weatherprojecttt;

public class Hourly {
   private String hour;
   private int temperature;
   private String feeling;
   private int humidity;

   public Hourly(String hour, int temperature, String feeling, int humidity) {
      this.hour = hour;
      this.temperature = temperature;
      this.feeling = feeling;
      this.humidity = humidity;
   }

   public String getHour() {
      return hour;
   }

   public void setHour(String hour) {
      this.hour = hour;
   }

   public int getTemperature() {
      return temperature;
   }

   public void setTemperature(int temperature) {
      this.temperature = temperature;
   }

   public String getFeeling() {
      return feeling;
   }

   public void setFeeling(String feeling) {
      this.feeling = feeling;
   }

   public int getHumidity() {
      return humidity;
   }

   public void setHumidity(int humidity) {
      this.humidity = humidity;
   }
}

package com.example.weatherprojecttt;

public class Hourly {
   private String hour;
   private String temperature;
   private String feeling;
   private String humidity;

   public Hourly(String hour, String temperature, String feeling, String humidity) {
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

   public String getTemperature() {
      return temperature;
   }

   public void setTemperature(String temperature) {
      this.temperature = temperature;
   }

   public String getHumidity() {
      return humidity;
   }

   public void setHumidity(String humidity) {
      this.humidity = humidity;
   }

   public String getFeeling() {
      return feeling;
   }

   public void setFeeling(String feeling) {
      this.feeling = feeling;
   }


}

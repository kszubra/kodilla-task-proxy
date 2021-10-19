package com.kodilla.task.weatherproxy;

public class WeatherComForecastClient implements WeatherForecastProvider{

    public WeatherComForecastClient() throws InterruptedException {
        refreshData();
    }

    @Override
    public String getWeather() {
        return "Not bad, sunny and no wind";
    }

    @Override
    public String refreshData() throws InterruptedException {
        Thread.sleep(5000);
        return "Aaaaaand thunderstorm now";
    }
}


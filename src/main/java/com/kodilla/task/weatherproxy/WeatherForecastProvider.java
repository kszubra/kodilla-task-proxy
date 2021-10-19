package com.kodilla.task.weatherproxy;

public interface WeatherForecastProvider {

    String getWeather() throws InterruptedException;

    String refreshData() throws InterruptedException;
}

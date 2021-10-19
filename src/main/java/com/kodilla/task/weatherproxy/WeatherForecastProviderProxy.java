package com.kodilla.task.weatherproxy;

import java.util.Objects;

public class WeatherForecastProviderProxy implements WeatherForecastProvider {
    private WeatherComForecastClient provider;

    @Override
    public String getWeather() throws InterruptedException {
        if (Objects.isNull(provider))
            provider = new WeatherComForecastClient();
        return provider.getWeather();
    }

    @Override
    public String refreshData() throws InterruptedException {
        if (Objects.isNull(provider))
            provider = new WeatherComForecastClient();
        return provider.refreshData();
    }
}

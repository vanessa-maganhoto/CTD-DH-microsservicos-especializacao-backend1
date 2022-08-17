package com.dh.weather.service;

public interface WeatherService {

    /**
     *
     * @return
     */
    Integer getWeather();

    String getCountry();

    String getWeatherWithUser(Long id);
}

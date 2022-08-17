package com.dh.weather.resources;

import com.dh.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherResource {

    @Autowired
    private WeatherService service;


    @GetMapping
    private ResponseEntity<Integer> getWeather(){
        return ResponseEntity.ok(service.getWeather());
    }

    @GetMapping("/{id}")
    private ResponseEntity<String> getWeather(@PathVariable Long id){
        return ResponseEntity.ok(service.getWeatherWithUser(id));
    }

    @GetMapping("/country")
    private ResponseEntity<String> getCountry(){
        return ResponseEntity.ok(service.getCountry());
    }
}

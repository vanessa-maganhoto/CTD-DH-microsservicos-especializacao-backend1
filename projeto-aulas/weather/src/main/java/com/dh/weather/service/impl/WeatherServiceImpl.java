package com.dh.weather.service.impl;

import com.dh.weather.service.UsuarioFeign;
import com.dh.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private UsuarioFeign usuarioFeign;

    @Value("${country}")
    private String country;

    @Value("${message}")
    private String message;

    @Value("${server.port}")
    private String porta;

    @Override
    public Integer getWeather() {
        return 25;
    }

    @Override
    public String getCountry() {
        return this.message + " " + this.country;
    }

    @Override
    public String getWeatherWithUser(Long id) {
        String s = "Porta Servidor:" + porta + " Nome do usuario: " + usuarioFeign.pesquisarPorId(id).getBody().getNome() + " " + 25;
        System.out.println(s);
        return s;
    }
}

package com.example.images.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${message}")
    private String message;

    @Value("${image}")
    private String image;

    @Override
    public String getImage() {
        return message + " " + image;
    }
}

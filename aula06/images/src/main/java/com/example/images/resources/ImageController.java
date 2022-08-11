package com.example.images.resources;

import com.example.images.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService service;

    @GetMapping
    private ResponseEntity<String> getImage() {
        return ResponseEntity.ok(service.getImage());
    }
}

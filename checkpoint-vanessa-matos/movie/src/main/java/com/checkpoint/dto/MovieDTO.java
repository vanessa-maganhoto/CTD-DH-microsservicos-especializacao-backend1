package com.checkpoint.dto;

import com.checkpoint.entity.Movie;
import lombok.Builder;
import lombok.Data;


import java.io.Serializable;

@Data
@Builder
public class MovieDTO implements Serializable {


    private Long id;
    private String name;
    private String genre;
    private String urlStream;



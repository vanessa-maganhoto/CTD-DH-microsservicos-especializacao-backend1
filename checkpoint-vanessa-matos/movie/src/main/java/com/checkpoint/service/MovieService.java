package com.checkpoint.service;

import com.checkpoint.dto.MovieDTO;


import java.util.List;

public interface MovieService {

    MovieDTO save(MovieDTO dto);

    List<MovieDTO> findByGenre(String genre);
}

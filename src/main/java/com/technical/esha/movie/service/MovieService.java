package com.technical.esha.movie.service;

import com.technical.esha.movie.model.dto.MovieDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovie();
    ResponseEntity<?> saveMovie(List<MovieDto> request);
    ResponseEntity<?> updateMovie(MovieDto request);
    ResponseEntity<?> deleteMovie(Long id);
}

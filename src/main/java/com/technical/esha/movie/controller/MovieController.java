package com.technical.esha.movie.controller;

import com.technical.esha.movie.model.dto.MovieDto;
import com.technical.esha.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/get-all-movie")
    public ResponseEntity<Object> getAllMovie() {
        try {
            return ResponseEntity.ok(movieService.getAllMovie());
        } catch (Exception ex) {
            log.info(ex.toString());
            throw ex;
        }
    }

    @PostMapping("/save-movie")
    public ResponseEntity<?> saveMovie(@RequestBody List<MovieDto> request) {
        try {
            return ResponseEntity.ok(movieService.saveMovie(request));
        } catch (Exception ex) {
            log.info(ex.toString());
            throw ex;
        }
    }

    @PostMapping("/update-movie")
    public ResponseEntity<?> updateMovie(@RequestBody MovieDto request) {
        try {
            return ResponseEntity.ok().body(movieService.updateMovie(request));
        } catch (Exception ex) {
            log.info(ex.toString());
            throw ex;
        }
    }

    @DeleteMapping("/delete-movie")
    public ResponseEntity<?> deleteMovie(@RequestBody Long request) {
        try {
            return ResponseEntity.ok().body(movieService.deleteMovie(request));
        } catch (Exception ex) {
            log.info(ex.toString());
            throw ex;
        }
    }

}

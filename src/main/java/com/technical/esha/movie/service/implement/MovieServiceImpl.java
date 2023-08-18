package com.technical.esha.movie.service.implement;

import com.technical.esha.movie.model.dao.MovieDao;
import com.technical.esha.movie.model.dto.MovieDto;
import com.technical.esha.movie.repository.MovieRepository;
import com.technical.esha.movie.service.MovieService;
import com.technical.esha.movie.util.CommonUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<MovieDto> getAllMovie() {
        List<MovieDao> movieDaos = movieRepository.findAll();
        if (!movieDaos.isEmpty())
            return movieDaos.stream().map(value -> {
                        MovieDto movieDto = new MovieDto();
                        CommonUtil.constructData(value, movieDto);
                        movieDto.setDirector(value.getDirector());
                        return movieDto;
                    })
                    .toList();
        else
            return new ArrayList<>();
    }

    @Override
    public ResponseEntity<?> saveMovie(List<MovieDto> request) {
        try {
            var data = request.stream().map(value -> {
                MovieDao movieDao = new MovieDao();
                CommonUtil.constructData(value, movieDao);
                return movieDao;
            }).toList();
            movieRepository.saveAllAndFlush(data);
            return ResponseEntity.ok("movie uploaded successfully!!");
        } catch (Exception e) {
            log.info(e.toString());
            return ResponseEntity.badRequest().body("movie uploaded failed!!");
        }
    }

    @SneakyThrows
    @Override
    public ResponseEntity<?> updateMovie(MovieDto request) {
        try {
            MovieDao movieDao = movieRepository.findByTitle(request.getTitle());
            if (Objects.isNull(movieDao))
                throw new ChangeSetPersister.NotFoundException();
            CommonUtil.constructData(request, movieDao);
            movieRepository.saveAndFlush(movieDao);
            return ResponseEntity.ok("movie update successfully!!");
        } catch (Exception e) {
            log.info(e.toString());
            return ResponseEntity.badRequest().body("movie update failed!!");
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteMovie(Long id) {
        try {
            movieRepository.deleteById(id);
            return ResponseEntity.ok("movie delete successfully!!");
        } catch (Exception e) {
            log.info(e.toString());
            return ResponseEntity.badRequest().body("movie delete failed!!");
        }
    }
}

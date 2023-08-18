package com.technical.esha.movie.repository;

import com.technical.esha.movie.model.dao.MovieDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieDao, Long> {

    MovieDao findByTitle(String title);
    void deleteById(Long id);
}
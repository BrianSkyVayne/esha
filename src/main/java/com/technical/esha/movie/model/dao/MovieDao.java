package com.technical.esha.movie.model.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "movie")
@NoArgsConstructor
@AllArgsConstructor
public class MovieDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "summary")
    private String summary;

    @Column(name = "genres")
    private String genres;


}
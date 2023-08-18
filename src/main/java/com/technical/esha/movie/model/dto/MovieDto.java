package com.technical.esha.movie.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto implements Serializable {

    private long id;

    private String title;
    private String director;
    private String summary;
    private String genres;
}

package com.technical.esha.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.technical.esha.movie.model.dao")
public class MovieCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCollectionApplication.class, args);
	}

}

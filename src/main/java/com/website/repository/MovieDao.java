package com.website.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.model.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Long>{
	Optional<Movie> findByMovieName(String movieName);
	Optional<Movie> findByGenre(String genre);
}

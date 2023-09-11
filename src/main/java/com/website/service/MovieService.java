package com.website.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.website.exception.MovieAlreadyPresent;
import com.website.model.Movie;
import com.website.repository.MovieDao;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;

	public String saveMovie(String movieName, String genre, boolean released, MultipartFile movieImage) {
		if(movieDao.findByMovieName(movieName).isPresent()) {
			throw new MovieAlreadyPresent("This movie already exists.");
		}
		else {
			Movie mov = new Movie();
			mov.setMovieName(movieName);
			mov.setGenre(genre);
			mov.setReleased(released);
			try {
				mov.setMovieImage(Base64.getEncoder().encodeToString(movieImage.getBytes()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			movieDao.save(mov);
			return mov.getMovieName() + " with " + mov.getId() +" is saved.";
		}
	}
}

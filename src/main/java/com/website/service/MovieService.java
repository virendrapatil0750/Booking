package com.website.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.website.exception.MovieAlreadyPresent;
import com.website.exception.NoSuchMovieExist;
import com.website.model.Movie;
import com.website.repository.MovieDao;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;

	public String saveMovie(String name, 
			                String genre, 
			                boolean isReleased,
			                String description,
			                LocalDate releaseDate, 
			                int seatsAvailable,
			int price,MultipartFile movieImage) {
		if(movieDao.findByName(name).isPresent()) {
			throw new MovieAlreadyPresent("This movie already exists.");
		}
		else {
			Movie mov = new Movie();
			mov.setName(name);
			mov.setGenre(genre);
			mov.setReleased(isReleased);
			mov.setDescription(description);
			mov.setReleaseDate(releaseDate);
			mov.setSeatsAvailable(seatsAvailable);
			mov.setPrice(price);
			try {
				mov.setImage(Base64.getEncoder().encodeToString(movieImage.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			movieDao.save(mov);
			return mov.getName() + " with " + mov.getId() +" is saved.";
		}
	}
	
//	public Movie searchMovie(String movieName) {
//		List<Movie> movies = movieDao.findAll();
//		if (movies.contains(movieName)) {
//			for (Movie movie : movies) {
//				if (movie.isReleased()) {
//					return movie;
//				} 
//			}
//				
//			return null;
//		}else {
//			throw new NoSuchMovieExist();
//		}
	//}
}

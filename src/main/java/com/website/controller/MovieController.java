package com.website.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.website.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@PostMapping("/movieSave")
	public ResponseEntity<String> saveMovie( @RequestParam("movieName") String name, 
							 @RequestParam("genre")String genre, 
	                         @RequestParam("isReleased")boolean isReleased,
							 @RequestParam("description")String description,
							 @RequestParam("releaseDate")LocalDate releaseDate,
						     @RequestParam("seatsAvailable") int seatsAvailable,
							 @RequestParam("price")int price,
							 @RequestParam("movieImage") MultipartFile image) {
		String str = movieService.saveMovie(name, genre, isReleased,description,releaseDate,seatsAvailable,price, image);
		return ResponseEntity.ok(str);

	}
//	
//     @GetMapping("/search-movie")
//	public void searchMovie(String movieName) {
//		movieService.searchMovie(movieName);
//	}
}

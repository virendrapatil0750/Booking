package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> saveMovie( @RequestParam("movieName") String movieName, 
							 @RequestParam("genre")String genre, 
							 @RequestParam("released")boolean released,
							 @RequestParam("movieImage") MultipartFile movieImage) {
		String str = movieService.saveMovie(movieName, genre, released, movieImage);
		return ResponseEntity.ok(str);

	}
}

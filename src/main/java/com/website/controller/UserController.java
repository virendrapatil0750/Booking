package com.website.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.website.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser( @RequestParam("name") String name,
							@RequestParam("password")String password,
							@RequestParam("email")String email,
							@RequestParam("dob")Date dob,
							@RequestParam("image")MultipartFile image,
							@RequestParam("city")String city){
		String reponse = userService.saveUser(name, password,email,dob,image,city);
		return ResponseEntity.ok(reponse);
	}
}

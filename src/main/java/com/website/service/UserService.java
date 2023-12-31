package com.website.service;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.website.exception.UserAlreadyExists;
import com.website.exception.UserNotFound;
import com.website.exception.UserPasswordisWrong;
import com.website.model.User;
import com.website.repository.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public String saveUser(	String name, 
							String password, 
							String email, 
							Date dob, 
							MultipartFile image, 
							String city) {
		if(userDao.findByEmail(email).isPresent()) {
			throw new UserAlreadyExists("This email is already in use");
		}
		else {
				User u = new User();
				u.setName(name);
				u.setPassword(password);
				u.setEmail(email);
				u.setDob(dob);
				u.setCity(city);
				try {
					u.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				userDao.save(u);
				return u.getName() + " has been stored in data";
		}
	}

	public String getUser(String email, String password) {
		if(userDao.findByEmail(email).isPresent()) {
			User u = userDao.findByEmail(email).get();
			if(password.equals(u.getPassword())) {
				return u.getName()+" Welcome";
			}
			else {
				throw new UserPasswordisWrong("Please enter correct password");
			}
		}
		else {
			throw new UserNotFound("Email entered is not present");
		}
	}
	
	
	public String randomPassword() {
		int i = 12;
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();
		String allCharacter = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
		for (int j = 1; j <= i; j++) {
			int randomInt = random.nextInt(allCharacter.length());
			password.append(allCharacter.charAt(randomInt));
		}
		return password.toString();
	}
}

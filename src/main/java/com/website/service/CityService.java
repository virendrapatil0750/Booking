package com.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.exception.CityNotFoundException;
import com.website.model.City;
import com.website.model.Movie;
import com.website.model.Theater;
import com.website.repository.CityDao;

@Service
public class CityService {
	@Autowired
	CityDao cityDao;

	public City saveCity(City city) {
		return cityDao.save(city);
	}

	public City findByCity(String cityName) {
		
		City city = cityDao.findByCityName(cityName).orElseThrow(()-> 
						new CityNotFoundException("City not found"));
		return city;
	}

	
//	public void searchTheater(String theaterName) {
//		List<City> theater = cityDao.findAll();		
//	}

}
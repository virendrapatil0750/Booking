package com.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.website.model.City;
import com.website.model.Theater;
import com.website.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;

	@PostMapping("/saveCity")
	public City saveCity(@RequestBody City city) {
		return cityService.saveCity(city);
	}

	@GetMapping("/findCity")
	public City findByCity(@RequestParam("city") String cityName) {
		return cityService.findByCity(cityName);
	}
	
	
//	@GetMapping("/search-theater")
//	public void searchTheater(String TheaterName) {
//		cityService.searchTheater(TheaterName);
//	}

}

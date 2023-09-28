package com.website.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.model.City;
@Repository
public interface CityDao extends JpaRepository<City,Long> {

	public Optional<City> findByCityName(String cityName);
}

package com.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.model.Theater;

@Repository
public interface TheaterDao extends JpaRepository< Theater, Long>{

}

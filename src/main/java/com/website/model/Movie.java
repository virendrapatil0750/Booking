package com.website.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String genre;
	private boolean isReleased;
	private String description;
	private LocalDate releaseDate;
	private int seatsAvailable;
	private int price;
	
	@ManyToOne
	private Theater theater;
	
	@Lob
	private String image;
}

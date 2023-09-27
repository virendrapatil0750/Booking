package com.website.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cityId;
	private String cityName;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	List<Theater> theater = new ArrayList<Theater>();

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", Theater=" + theater + "]";
	}
	
	
}

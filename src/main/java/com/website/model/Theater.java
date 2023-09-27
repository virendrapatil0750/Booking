package com.website.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long theaterId;
	private String name;
	private String location;
	@ManyToOne
	private City city;

	@Override
	public String toString() {
		return "Theater [theaterId=" + theaterId + ", name=" + name + ", location=" + location + ", city=" + city + "]";
	}
	
	
	
}

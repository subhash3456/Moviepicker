package com.project.moviepicker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	
	@Id
	
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String name;
	private String rating;
	private String avalaibleOn;
	private String suggestedBy;
	private String genre;
	private String trailerlink;

}

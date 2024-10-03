package com.project.moviepicker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.project.moviepicker.entity.Movie;
import com.project.moviepicker.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepo;
	
	public List<Movie> getFilteredMovies(String name,String rating,String avalaibleOn,String suggestedBy,String genre){
		Specification<Movie> spec = MovieSpecification.filterByCriteria(name,rating,avalaibleOn,suggestedBy,genre);
		
		return movieRepo.findAll(spec);
	}

}

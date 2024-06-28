package com.project.moviepicker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.moviepicker.entity.Movie;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Long>{
	

//	@Query()
//	public List<Movie> getMoviesByFiltered();

}

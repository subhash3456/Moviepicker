package com.project.moviepicker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.moviepicker.entity.Movie;
import com.project.moviepicker.repository.MovieRepository;

@RestController
@CrossOrigin("http://localhost:3000")
//@RequestMapping("/movie")
public class movieController {
	
	
	@Autowired
	MovieRepository movieRepo;
	
	
	@GetMapping("/allMovies")
	public List<Movie> getAllMovies(){
		List<Movie> movielist = movieRepo.findAll();
		return movielist;
	}
	
	
	@PostMapping("/addMovie")
	public String addMovie(@RequestBody Movie movie) {
		movieRepo.save(movie);
		return "Movie is added successfully";
	}
	
	@GetMapping("/randomMovie")
	public List<Movie> getRandomMovie() {
		List<Movie> movielist = new ArrayList<Movie>();
		Random random = new Random();
		long low = 1;
		long high = movieRepo.count();
		long randomNum = random.nextInt((int) (high-low)) +low;
		Optional<Movie> randomMovie = movieRepo.findById(randomNum);
		if(randomMovie.isPresent()) {
			movielist.add(randomMovie.get());
			return movielist;
		}
		else {
			return movielist;
		}
		
	}
	
	
	//Yet to be implemented thinking of the optimal logic
	@PostMapping("/filterMovie")
	public List<Movie> getFilteredMovie(){
		
		
		
		return null;
	}
	
	

}

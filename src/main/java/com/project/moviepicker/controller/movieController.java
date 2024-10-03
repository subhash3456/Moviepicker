package com.project.moviepicker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.moviepicker.entity.Movie;
import com.project.moviepicker.repository.MovieRepository;
import com.project.moviepicker.service.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/movie")
public class movieController {
	
	
	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	MovieService movieService;
	
	
	
	
	
	@GetMapping("/allMovies")
	public List<Movie> getAllMovies() throws RuntimeException{
		List<Movie> movielist = movieRepo.findAll();
		return movielist;
	}
	
	
	@PostMapping("/addMovie")
	public String addMovie(@RequestBody Movie movie) throws Exception {
		movieRepo.save(movie);
//		try{
//			int i = 2/0 ;
		
//		}catch(Exception e) {
//			return "Exception is occured you mf";
//		}
		return "Movie is added successfully";
	}
	
	@GetMapping("/randomMovie")
	public List<Movie> getRandomMovie() {
//		List<Movie> movielist = new ArrayList<Movie>();
//		Random random = new Random();
//		long low = 1;
//		long high = movieRepo.count() +1;
//		long randomNum = random.nextInt((int) (high-low)) +low;
////		long randomNum = random.nextInt((int) (high));
//		Optional<Movie> randomMovie = movieRepo.findById(randomNum);
//		if(randomMovie.isPresent()) {
//			movielist.add(randomMovie.get());
//			return movielist;
//		}
//		else {
//			return movielist;
//		}
		
		List<Movie> randomRecord = movieRepo.findRandomRecord();
		
		
		return randomRecord;
		
	}
	
	
	//Yet to be implemented thinking of the optimal logic
	@PostMapping("/filterMovie")
	public List<Movie> getFilteredMovie(@RequestBody Movie movie){
		
//		String filterQuery = new String();
//		
//		String filterName = movie.getName() == null ? null : movie.getName();
//		String filterRating = movie.getRating() == null ? null : movie.getRating();
//		
//		filterQuery = filterName + filterRating;
//		
//		movieRepo.getMoviesByFiltered(filterQuery);
		
		List<Movie> filteredMovies = movieService.getFilteredMovies(movie.getName(),movie.getRating(),movie.getAvalaibleOn(),movie.getSuggestedBy(),movie.getGenre());
		
		
		return filteredMovies ;
	}
	
	@DeleteMapping("/deleteMovie")
	public String deleteMovie(@RequestBody Movie movie) {
		
		movieRepo.deleteByName(movie.getName());
		return "Movie Deleted successfully" ;
	}
	
	
	@PostMapping("/viewedMovie")
	public String viewedMovie(@RequestBody Movie movie) {
		
		if(movie.getViewed().equals( "Not Viewed")) {
			movie.setViewed("Viewed");
			movieRepo.save(movie);
		}else if (movie.getViewed().equals("Viewed") ) {
			movie.setViewed("Not Viewed");
			
			movieRepo.save(movie);
		}
		
		
		return "Updated successfully" ;
	}
	
	

}

package com.project.moviepicker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.moviepicker.entity.Movie;

import jakarta.transaction.Transactional;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie>{
	

	

	

//	@Query(value = "" , nativeQuery = true )
//	List<Movie> getMoviesByFiltered(String filterQuery);;
	
	@Query("SELECT e FROM Movie e ORDER BY function('RAND')")
    List<Movie> findRandomRecord();
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Movie e WHERE e.name = ?1")
	void deleteByName( String name);


}

package com.project.moviepicker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.project.moviepicker.entity.Movie;

import jakarta.persistence.criteria.Predicate;

public class MovieSpecification {
	
	public static Specification<Movie> filterByCriteria(String name,String rating,String avalaibleOn,String suggestedBy,String genre){
		return(root,query,criteriaBuilder)-> {
			List<Predicate> predicates = new ArrayList<>();
			
			if(name != null && !name.isEmpty()) {
				predicates.add(criteriaBuilder.equal(root.get("name"),name));
			}
			if(rating != null && !rating.isEmpty()) {
				predicates.add(criteriaBuilder.equal(root.get("rating"),rating));
			}
			if(avalaibleOn != null && !avalaibleOn.isEmpty()) {
				predicates.add(criteriaBuilder.equal(root.get("avalaibleOn"),avalaibleOn));
			}
			if(suggestedBy != null && !suggestedBy.isEmpty()) {
				predicates.add(criteriaBuilder.equal(root.get("suggestedBy"),suggestedBy));
			}
			if(genre != null && !genre.isEmpty()) {
				predicates.add(criteriaBuilder.equal(root.get("genre"),genre));
			}
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}

}

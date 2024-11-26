package com.example.amitlal.mvcProj.dataService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

import com.example.amitlal.mvcProj.entity.Movies;
import com.example.amitlal.mvcProj.repository.crudRepository;

@Service
public class databaseService {
	
	@Autowired
	crudRepository crudRepo;
	
	@Autowired
	RatingService ratingService;

	// save data into database
	public void create(Movies movie) {
		
		String rating=ratingService.getMovieRating(movie.getTitle());
		if(rating!=null) {
			movie.setRating(Float.parseFloat(rating));
		}
		
		crudRepo.save(movie);
	}
	
	// get all data from database
	public List<Movies> getAllMovie() {
		
		return crudRepo.findAll();
	}
	
	
	// get data by id from database
	public Movies getMovieById(Integer id) {
		return crudRepo.findById(id).get();
		 
	}

	
	// update data 
	public void update(Movies movie,Integer id) {
		
		Movies toBeUpdated= getMovieById(id);
		toBeUpdated.setTitle(movie.getTitle());
		toBeUpdated.setRating(movie.getRating());
		toBeUpdated.setPriority(movie.getPriority());
		toBeUpdated.setComment(movie.getComment());
		
		crudRepo.save(toBeUpdated);
		
		
	}

}

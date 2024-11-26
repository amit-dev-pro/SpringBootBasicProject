package com.example.amitlal.mvcProj.controller;

 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.amitlal.mvcProj.dataService.databaseService;
import com.example.amitlal.mvcProj.entity.Movies;

import jakarta.validation.Valid;

@RestController
public class MovieController {
	
	@Autowired
	databaseService dataSer;

	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required=false) Integer id) {
		
		String viewName="watchlistItemForm";
		
		Map<String , Object> model=new HashMap<>();
		
		if(id==null) {
			model.put("watchlistItem", new Movies());
		}else {
			model.put("watchlistItem",dataSer.getMovieById(id));
		}
		//Movies dummyMovie=new Movies();
//		dummyMovie.setTitle( "dummy");
//		dummyMovie.setRating(0);
//		dummyMovie.setRating(0);
//		dummyMovie.setPriority("Low");
//		dummyMovie.setComment( "john doa");
//		
//		model.put("watchlistItem", dummyMovie);
		
//		model.put("watchlistItem", new Movies());
		
		return new ModelAndView(viewName,model);
	}
	
	@PostMapping(path="/watchlistItemForm")
	public ModelAndView submitWatchlistForm(@Valid @ModelAttribute("watchlistItem") Movies movie , BindingResult result) {
		
		 if(result.hasErrors()) {
			 return new ModelAndView("watchlistItemForm");
		 }
		
		
		Integer id=movie.getId();
		if(id==null) {
			dataSer.create(movie);
		} else {
			dataSer.update(movie,id);
		}
		
		 
		
		RedirectView rd=new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
		
		
	}
	
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		
		String viewName="watchlist";
		
		Map<String,Object> model=new HashMap<>();
		List<Movies> movieList=dataSer.getAllMovie();
		model.put("watchlistrows",movieList);
		
		model.put("noOfMovie", movieList.size());
		
		return new ModelAndView(viewName,model);
	}
	
}

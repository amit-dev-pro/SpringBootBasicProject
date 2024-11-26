package com.example.amitlal.mvcProj.dataService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {
	
	String apiUrl="https://www.omdbapi.com/?apikey=a8431cee&t=";
	
	public String getMovieRating(String title) {
	
		try {
			// try to fetch the rating by omdbapi
			
			RestTemplate template=new RestTemplate();
			
			// fetch the apiUrl + title
			
			ResponseEntity<ObjectNode> response=template.getForEntity(apiUrl + title,ObjectNode.class);
			
			ObjectNode jsonObject=response.getBody();  //json format data
			
			return jsonObject.path("imdbRating").asText(); //return as text
			
		 
		}
		catch(Exception e) {
			// To user enter rating will be taken
			
			System.out.println("Either movie name is not available or api is down "+e.getMessage());
			return null;
		}
	}

}

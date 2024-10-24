package com.example.MovieTicket.MovieBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/ticket")
public class Controller {

	@Autowired 
private MovieService movieservice;
	
	@RequestMapping("/home")
	public String Welcome() {
		return "Welcome to CodingNinjas Movies";
	}
	
@GetMapping("/movie")
public  List<Movie> getAllMovise(){
	return movieservice.getAllMovies();
	
}
@PostMapping("/movie")
   public void addMovie(@Validated @RequestBody Movie movie,BindingResult bindingresult){
	
	if(bindingresult.hasErrors()) {
		throw new RuntimeException("Error");
	}
	movieservice.addMovie(movie);
	
   }
   
  @GetMapping("/movie/{id}")
   public Movie getMovieById(@PathVariable String id) {
	   return movieservice.getMovieById(id);
	   
   }
    
   @DeleteMapping("/movie/{id}")
   public void deleteMovie(@PathVariable String id) {
	    movieservice.deleteMovie(id);
	    
   }
   
   @PutMapping("/update/{id}")
   public void updateMovie(@Valid @RequestBody Movie movie,@PathVariable String id){
	   
	   movieservice.updateMovie(movie, id);
	 
	   
   }
}

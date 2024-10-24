package com.example.MovieTicket.MovieBooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
@Service
public class MovieService implements MovieServiceInterface {
	
	private final List<Movie> movieList= new ArrayList<>();
	Map<String,Movie> MovieMap= new HashMap<>();
	
	
	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieList ;
	}

	@Override
	public void addMovie(Movie movie) {
		if(MovieMap.containsKey(movie.getId())){
		throw new IdAlreadyExist("Movie with id " + movie.getId()+" already exist");
		}
		movieList.add(movie);
		MovieMap.put(movie.getId(), movie);
	}

	@Override
	public Movie  getMovieById(String id) {
		
		if(ObjectUtils.isEmpty(MovieMap.get(id)))
		{
			throw new IdNotFound("Hotel not found for id: "+id);
		}
		Movie movie = MovieMap.get(id);
		return movie;
	}

	@Override
	public void deleteMovie(String id) {
		// TODO Auto-generated method stub
		Movie movie = getMovieById(id);
		movieList.remove(movie);
	  MovieMap.remove(movie);
	}


	@Override
	public void updateMovie(Movie movie, String id) {
        Movie existingMovie= getMovieById(id);
		
		movieList.remove(existingMovie);
		movieList.add(movie);		
		MovieMap.put(id, movie);
	}

}

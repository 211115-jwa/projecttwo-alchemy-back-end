package com.revature.ProTwo.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.data.MovieRepository;
import com.revature.ProTwo.exceptions.MovieAlreadyExistsException;
import com.revature.ProTwo.exceptions.MovieNotFoundException;


public class MovieServiceImpl implements MovieService{
	
	private MovieRepository movieRepo;

	// constructor injection
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepo) {
		
		this.movieRepo = movieRepo;
	}

	@Override
	public Movie create(Movie movie) throws MovieAlreadyExistsException{
		
		int newId = movieRepo.save(movie).getId();

		if (newId > 0) {
			movie.setId(newId);
			return movie;
		} 
		return null;
	}

	@Override
	public Movie delete(Movie movie) throws MovieNotFoundException {
		
		movieRepo.delete(movie);
		return movie;
	}

	@Override
	public Movie getMovieById(int id) throws MovieNotFoundException {
		
		 return movieRepo.findById(id).get();
	}

	@Override
	public Movie updateMovie(Movie movie) {
		
		 if (movieRepo.existsById(movie.getId())) {
			movieRepo.save(movie);
			movie = movieRepo.findById(movie.getId()).get();
			return movie;
		}
		return null;
	}

	@Override
	public Set<Movie> getMovieByGenre(String genre) {
		return movieRepo.findByGenre(genre);
	}

	@Override
	public Set<Movie> getByYear(String year) {
		
		return movieRepo.findByYear(year);
	}

	@Override
	public Movie getMovieByName(String name) {
		return movieRepo.findByMovieNameContainingIgnoreCase(name);
	}

}

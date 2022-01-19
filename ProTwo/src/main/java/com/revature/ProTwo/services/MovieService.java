package com.revature.ProTwo.services;

import java.util.Set;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.exceptions.MovieAlreadyExistsException;
import com.revature.ProTwo.exceptions.MovieNotFoundException;
public interface MovieService {
	
	public Movie create(Movie movie) throws MovieAlreadyExistsException;
	public Movie delete(Movie movie) throws MovieNotFoundException;
	public Movie getMovieById(int id) throws MovieNotFoundException;
	public Movie updateMovie(Movie movie);
	public Set<Movie> getMovieByGenre(String genre);
	public Set<Movie> getByYear(String year);
	public Movie getMovieByName(String name);
}

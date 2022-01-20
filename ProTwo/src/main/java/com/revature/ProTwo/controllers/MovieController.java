package com.revature.ProTwo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ProTwo.beans.Movie;

import com.revature.ProTwo.exceptions.MovieAlreadyExistsException;
import com.revature.ProTwo.exceptions.MovieNotFoundException;

import com.revature.ProTwo.services.MovieService;



@RestController
@RequestMapping(path="/movie")
@CrossOrigin(origins="http://localhost:4200")
public class MovieController {
	private static MovieService movieServ;

	@Autowired
	public MovieController(MovieService movieServ) {
		MovieController.movieServ=movieServ;
	}
	@PostMapping(path="/{movie}")
	public ResponseEntity<Void> addMovie(@RequestBody Movie movie){
		if (movie !=null) {
			try {
			movieServ.create(movie);
			}catch (Exception e) {
				
			}
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// POST to /movie, 
	@PostMapping
	public ResponseEntity<Map<String, Integer>> create(@RequestBody Movie newMovie) {

		try {
			newMovie = movieServ.create(newMovie);
			Map<String, Integer> newIdMap = new HashMap<>();
			newIdMap.put("generatedId", newMovie.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(newIdMap);
		} catch (MovieAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}// End of POST


	// GET to /users/{movieId}
	@GetMapping(path="/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable int movieId) throws MovieNotFoundException {
		Movie movie = movieServ.getMovieById(movieId);
		if (movie != null)
			return ResponseEntity.ok(movie);
		else
			return ResponseEntity.notFound().build();
	}


	// PUT to /movie/{movieId}
	@PutMapping(path="/{movieId}")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movieToEdit,
			@PathVariable int movieId) {
		if (movieToEdit != null && movieToEdit.getId() == movieId) {
			movieToEdit = movieServ.updateMovie(movieToEdit);
			if (movieToEdit != null)
				return ResponseEntity.ok(movieToEdit);
			else
				return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// GET to /movies/{movieName}
	@GetMapping(path="/{movieName}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable String name) throws MovieNotFoundException {
		Movie movie = movieServ.getMovieByName(name);
		if (movie != null)
			return ResponseEntity.ok(movie);
		else
			return ResponseEntity.notFound().build();
	}


	// GET to /movies/{movieGenre}
	@GetMapping(path="/{movieGenre}")
	public ResponseEntity<Set<Movie>> getMovieByGenre(@PathVariable String genre) throws MovieNotFoundException {
		Set<Movie> movie = movieServ.getMovieByGenre(genre);
		if (movie != null)
			return ResponseEntity.ok(movie);
		else
			return ResponseEntity.notFound().build();
	}


	// GET to /movies/{movieYear}
	@GetMapping(path="/{movieYear}")
	public ResponseEntity<Set<Movie>> getMovieByYear(@PathVariable String year) throws MovieNotFoundException {
		Set<Movie> movie = movieServ.getByYear(year);
		if (movie != null)
			return ResponseEntity.ok(movie);
		else
			return ResponseEntity.notFound().build();
	}
	 
}




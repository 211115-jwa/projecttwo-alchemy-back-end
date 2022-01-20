package com.revature.ProTwo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ProTwo.beans.Movie;
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

}

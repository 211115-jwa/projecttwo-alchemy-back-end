package com.revature.ProTwo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ProTwo.services.MovieService;


@RestController
@RequestMapping(path="/movie")
@CrossOrigin(origins="http://localhost:4200")
public class MovieController {
	private static MovieService movieServ;

	@Autowired
	public MovieController(MovieService movieServ) {
		this.movieServ=movieServ;
	}


}

package com.revature.ProTwo.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.ReviewLikes;
import com.revature.ProTwo.services.ReviewService;

@RestController
@RequestMapping(path = "/movie")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
	private static ReviewService revServ;

	@Autowired
	public ReviewController(ReviewService revServ) {
		ReviewController.revServ=revServ;
	}
	//Get all the reviews for specified movie
	//GET to /movie/{movie_id}
	@GetMapping(path="/{movie_id}")
	public ResponseEntity<Set<Review>> getReviewsForMovie(@RequestBody Movie movie) {
		Set<Review> allReviewsForMovie = revServ.getAllReviewsForMovie(movie);
		return ResponseEntity.ok(allReviewsForMovie);
	}

	//Post a new review
	//POST to /movie/{movie_id}
	@PostMapping(path="/{movie_id}")
	public ResponseEntity<Void> postReview(@RequestBody Review newReview){
		if (newReview !=null) {
			revServ.postNewReview(newReview);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//Rate a movie
	//PUT to /movie/{movie_id}
	@PutMapping(path="/{movie_id}")
	public ResponseEntity<Void> rateMovie(@RequestBody MovieRating newRating) {
		if (newRating !=null) {
			revServ.rateMovie(newRating);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	//Like a review
	//PUT to /movie/review/{review_id}
	@PutMapping(path="/review/{review_id}")
	public ResponseEntity<Void> likeReview(@RequestBody ReviewLikes newLike) {
		if (newLike !=null) {
			revServ.likeReview(newLike);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}

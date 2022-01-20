package com.revature.ProTwo.controllers;

import java.time.LocalDateTime;
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
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.ReviewLikes;
import com.revature.ProTwo.services.ReviewService;

@RestController
@RequestMapping(path = "/movie/{movie_id}")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
	private static ReviewService revServ;

	@Autowired
	public ReviewController(ReviewService revServ) {
		ReviewController.revServ=revServ;
	}
	//Get all the reviews for specified movie
	
	@GetMapping(path="/get_reviews")
	public ResponseEntity<Set<Review>> getReviewsForMovie(@PathVariable int movieId) {
		Set<Review> allReviewsForMovie = revServ.getAllReviewsForMovie(movieId);
		return ResponseEntity.ok(allReviewsForMovie);
	}

	//Post a new review
	//Post to /movie/{movie_id}/review
	@PostMapping(path ="/review")
	public ResponseEntity<Void> postReview(@RequestBody Review newReview){
		if (newReview !=null) {
			newReview.setSentAt(LocalDateTime.now());
			revServ.postNewReview(newReview);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//Rate a movie
	//Post to /movie/{movie_id}/rate
	@PutMapping(path="/rate")
	public ResponseEntity<Void> rateMovie(@RequestBody MovieRating newRating) {
		if (newRating !=null) {
			revServ.rateMovie(newRating);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	//Like a review
	//PUT to /movie/{movie_id}/review/{review_id}
	@PutMapping(path="/review/{review_id}")
	public ResponseEntity<Void> likeReview(@RequestBody ReviewLikes newLike) {
		if (newLike !=null) {
			revServ.likeReview(newLike);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}

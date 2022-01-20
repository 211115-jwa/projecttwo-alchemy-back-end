package com.revature.ProTwo.services;

import java.util.Set;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.ReviewLikes;

public interface ReviewService {
	//Get all the reviews
	//GET to /movie/{movie_id}
	public Set<Review> getAllReviewsForMovie(int movieId);
	//Post a new review
	//POST to /movie/{movie_id}
	public Review postNewReview(Review newReview);
	//Rate a movie
	//PUT to /movie/{movie_id}
	public void rateMovie(MovieRating newRating);
	//Like a review
	//PUT to /movie/review/{review_id}
	public void likeReview(ReviewLikes newLike);
}

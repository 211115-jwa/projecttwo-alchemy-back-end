package com.revature.ProTwo.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.ReviewLikes;
import com.revature.ProTwo.data.MovieRatingRepository;
import com.revature.ProTwo.data.ReviewLikesRepository;
import com.revature.ProTwo.data.ReviewRepository;
import com.revature.ProTwo.data.UserRepository;
import com.revature.ProTwo.exceptions.UsernameAlreadyExistsException;

@Service
public class ReviewServiceImpl implements ReviewService {
	private ReviewRepository revRepo;
	private MovieRatingRepository ratingRepo;
	private ReviewLikesRepository likesRepo;

	
	// constructor injection
	@Autowired
	public ReviewServiceImpl(ReviewRepository revRepo, MovieRatingRepository ratingRepo,
							 ReviewLikesRepository likesRepo) {
		this.revRepo = revRepo;
		this.ratingRepo = ratingRepo;
		this.likesRepo = likesRepo;
	}
	
	
	@Override
	public Set<Review> getAllReviewsForMovie(int movieId) {
		return revRepo.findByMovieOrderBySentAtDesc(movieId);
	}

	@Override
	public Review postNewReview(Review newReview) {
		int newId = revRepo.save(newReview).getId();
		newReview.setId(newId);
		return newReview;
	}

	@Override
	public void rateMovie(MovieRating newRating) {
		ratingRepo.save(newRating);	
	}

	@Override
	public void likeReview(ReviewLikes newLike) {
		likesRepo.save(newLike);
		
	}

}

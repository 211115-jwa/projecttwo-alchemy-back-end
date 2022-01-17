package com.revature.Repos;

import org.springframework.data.repository.CrudRepository;

import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.RatingId;

public interface MovieRatingRepository extends CrudRepository<MovieRating, RatingId>{

}

package com.revature.ProTwo.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


//@IdClass(RatingId.class)
@Entity
public class MovieRating implements Serializable {
	
	/**
	 * two different ways
	 *  may need to use @IdClass instead of @Embeddable
	 *  needs testing, link in slack
	 *  
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private RatingId ratingId;

	@Column(name="rating")
	private int userRating;


	
	public MovieRating(RatingId ratingId, int userRating) {
        this.ratingId = ratingId;
        this.userRating = userRating;
    }



	public RatingId getRatingId() {
		return ratingId;
	}



	public void setRatingId(RatingId ratingId) {
		this.ratingId = ratingId;
	}



	public int getUserRating() {
		return userRating;
	}



	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}



	@Override
	public int hashCode() {
		return Objects.hash(ratingId, userRating);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieRating other = (MovieRating) obj;
		return Objects.equals(ratingId, other.ratingId) && userRating == other.userRating;
	}



	@Override
	public String toString() {
		return "MovieRating [ratingId=" + ratingId + ", userRating=" + userRating + "]";
	}

	

}

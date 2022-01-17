package com.revature.ProTwo.beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReviewLikes {

	@Id
	private ReviewId reviewId;
	
	private boolean liked;
	
	public ReviewLikes(ReviewId reviewId, boolean liked) {
		
		this.liked = liked;
		this.reviewId = reviewId;
	}

	public ReviewId getReviewId() {
		return reviewId;
	}

	public void setReviewId(ReviewId reviewId) {
		this.reviewId = reviewId;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	@Override
	public int hashCode() {
		return Objects.hash(liked, reviewId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewLikes other = (ReviewLikes) obj;
		return liked == other.liked && Objects.equals(reviewId, other.reviewId);
	}


}

package com.revature.ProTwo.beans;

import java.util.Objects;

public class ReviewLikes {

	private long rLikes;
	private boolean liked;
	private User user;
	private Review review;
	
	public ReviewLikes() {

		rLikes = 1L;
		liked = false;
		user = new User();
		review = new Review();
		
	}

	public long getrLikes() {
		return rLikes;
	}

	public void setrLikes(long rLikes) {
		this.rLikes = rLikes;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	@Override
	public int hashCode() {
		return Objects.hash(liked, rLikes, review, user);
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
		return liked == other.liked && rLikes == other.rLikes && Objects.equals(review, other.review)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "ReviewLikes [rLikes=" + rLikes + ", liked=" + liked + ", user=" + user + ", review=" + review + "]";
	}
	
	
}

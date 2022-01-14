package com.revature.ProTwo.beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReviewLikes {

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private User user;
	private Review review;
	
	private boolean liked;
	
	public ReviewLikes() {

		liked = false;
		user = new User();
		review = new Review();
		
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

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	@Override
	public String toString() {
		return "ReviewLikes [user=" + user + ", review=" + review + ", liked=" + liked + ", getUser()=" + getUser()
				+ ", getReview()=" + getReview() + ", isLiked()=" + isLiked() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(liked, review, user);
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
		return liked == other.liked && Objects.equals(review, other.review) && Objects.equals(user, other.user);
	}

	
}

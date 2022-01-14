package com.revature.ProTwo.beans;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long reviewId;
	private String reviewTitle;
	private String reviewText;
	private int ratingReview;
	private LocalDateTime sentAt;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	public Review() {

		reviewId = 1L;
		user = new User();
		movie = new Movie();
		reviewTitle = "";
		reviewText = "";
		ratingReview = 0;
		sentAt = null;
		
		
		
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public int getRatingReview() {
		return ratingReview;
	}

	public void setRatingReview(int ratingReview) {
		this.ratingReview = ratingReview;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movie, ratingReview, reviewId, reviewText, reviewTitle, sentAt, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return Objects.equals(movie, other.movie) && ratingReview == other.ratingReview && reviewId == other.reviewId
				&& Objects.equals(reviewText, other.reviewText) && Objects.equals(reviewTitle, other.reviewTitle)
				&& Objects.equals(sentAt, other.sentAt) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", user=" + user + ", movie=" + movie + ", reviewTitle=" + reviewTitle
				+ ", reviewText=" + reviewText + ", ratingReview=" + ratingReview + ", sentAt=" + sentAt + "]";
	}
	
	
}

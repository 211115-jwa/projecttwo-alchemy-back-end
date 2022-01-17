package com.revature.ProTwo.beans;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class ReviewId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "review_id")
	private Long movieId;

	public ReviewId() {

	}

	public ReviewId(Long movieId, Long userId) {
		this.movieId = movieId;
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewId other = (ReviewId) obj;
		return Objects.equals(movieId, other.movieId) && Objects.equals(userId, other.userId);
	}
}

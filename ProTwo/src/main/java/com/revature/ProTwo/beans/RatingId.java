package com.revature.ProTwo.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class RatingId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// I included the schema but not sure if it is needed
	@Column(name = "Project2.p_user.user_id")
    private Long userId;

    @Column(name = "Project2.movie.movie_id")
    private Long movieId;

    public RatingId() {
    }

    public RatingId(Long userId, Long movieId) {
        this.userId = userId;
        this.movieId = movieId;
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
		RatingId other = (RatingId) obj;
		return Objects.equals(movieId, other.movieId) && Objects.equals(userId, other.userId);
	}

	

}
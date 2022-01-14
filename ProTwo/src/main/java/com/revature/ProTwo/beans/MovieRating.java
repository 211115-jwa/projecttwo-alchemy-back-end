package com.revature.ProTwo.beans;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieRating {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private User user;
	private Movie movie;

	@Column(name="rating")
	private int userRating;


	public MovieRating() {

		userRating = 1;
		user = new User();
		movie = new Movie();

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


	public int getUserRating() {
		return userRating;
	}


	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}


	@Override
	public int hashCode() {
		return Objects.hash(movie, user, userRating);
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
		return Objects.equals(movie, other.movie) && Objects.equals(user, other.user) && userRating == other.userRating;
	}


	@Override
	public String toString() {
		return "MovieRating [user=" + user + ", movie=" + movie + ", userRating=" + userRating + ", getUser()="
				+ getUser() + ", getMovie()=" + getMovie() + ", getUserRating()=" + getUserRating() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}



}

package com.revature.ProTwo.beans;

import java.util.Objects;

public class Movie {

	private long movieId;
	private String movieName;
	private int year;
	private String description;
	private String movieRating;
	private String genre;
	
	public Movie() {

		movieId = 1L;
		movieName = "";
		year = 0;
		description = "";
		movieRating = "";
		genre = "";
		
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, genre, movieId, movieName, movieRating, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(description, other.description) && Objects.equals(genre, other.genre)
				&& movieId == other.movieId && Objects.equals(movieName, other.movieName)
				&& Objects.equals(movieRating, other.movieRating) && year == other.year;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", year=" + year + ", description="
				+ description + ", movieRating=" + movieRating + ", genre=" + genre + "]";
	}
	
}

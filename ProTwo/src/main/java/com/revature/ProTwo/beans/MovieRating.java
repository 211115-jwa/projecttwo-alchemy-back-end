package com.revature.ProTwo.beans;

import java.util.Objects;

public class MovieRating {

		private int userRating;
		private User user;
		private Movie movie;
		private  long movieRatingId;
		
		
		public MovieRating() {

			userRating = 1;
			user = new User();
			movie = new Movie();
			movieRatingId = 1L;
			
	}


		public int getUserRating() {
			return userRating;
		}


		public void setUserRating(int userRating) {
			this.userRating = userRating;
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


		public long getMovieRatingId() {
			return movieRatingId;
		}


		public void setMovieRatingId(long movieRatingId) {
			this.movieRatingId = movieRatingId;
		}


		@Override
		public int hashCode() {
			return Objects.hash(movie, movieRatingId, user, userRating);
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
			return Objects.equals(movie, other.movie) && movieRatingId == other.movieRatingId
					&& Objects.equals(user, other.user) && userRating == other.userRating;
		}


		@Override
		public String toString() {
			return "MovieRating [userRating=" + userRating + ", user=" + user + ", movie=" + movie + ", movieRatingId="
					+ movieRatingId + "]";
		}
		
		
		
}

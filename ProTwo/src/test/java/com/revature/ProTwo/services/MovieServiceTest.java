package com.revature.ProTwo.services;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.ProTwo.ProTwoApplication;
import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.MovieRatingId;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.data.MovieRepository;
import com.revature.ProTwo.data.ReviewRepository;
import com.revature.ProTwo.exceptions.MovieAlreadyExistsException;
import com.revature.ProTwo.exceptions.MovieNotFoundException;
@SpringBootTest(classes=ProTwoApplication.class)
public class MovieServiceTest {

	@MockBean
	private MovieRepository movieRepo;

	@Autowired
	private MovieService movieServ;

	private static Set<Movie> mockMovies;

	static String name;

	// Mock
	@BeforeAll
	public static void mockMovieSetup() {
		mockMovies = new HashSet<>();

		for (int i=1; i<=5; i++) {
			Movie movie = new Movie();
			movie.setId(i);
			name = String.valueOf(i);
			if (i<3)
				movie.setMovieName("alchemy" + name);
			mockMovies .add(movie);
		}
	}

	//Create
	@Test
	public void addNewMovieSuccessfully() throws MovieAlreadyExistsException {
		Movie newMovie = new Movie();
		Movie mockMovie = new Movie();
		mockMovie.setId(9);

		when(movieRepo.save(newMovie)).thenReturn(mockMovie);

		Movie newId = movieServ.create(newMovie);

		assertNotEquals(null, newId);
	}

	@Test
	public void addNewMovieSomethingWrong() throws MovieAlreadyExistsException{
		Movie movie = new Movie();

		when(movieRepo.save(movie)).thenReturn(movie);

		Movie newId = movieServ.create(movie);

		assertEquals(null,newId);
	}

	//Delete
	@Test
	public void delete() throws MovieNotFoundException{
		Movie movie = new Movie ();
		when(movieRepo.save(movie)).thenReturn(movie);

		Movie newId = movieServ.delete(movie);
		assertEquals(null,newId);
	}


	//update, movie
	@Test
	public void updateSuccessfully() {
		Movie mockMovie = new Movie();
		mockMovie.setId(1);

		when(movieRepo.existsById(1)).thenReturn(true);
		when(movieRepo.save(Mockito.any(Movie.class))).thenReturn(mockMovie);
		when(movieRepo.findById(1)).thenReturn(Optional.of(mockMovie));

		Movie updatedMovie = movieServ.updateMovie(mockMovie);
		assertNotNull(updatedMovie);
	}

	@Test
	public void updateSomethingWrong() {
		Movie mockMovie = new Movie();
		mockMovie.setId(1);

		when(movieRepo.existsById(1)).thenReturn(false);

		Movie updatedMovie = movieServ.updateMovie(mockMovie);
		assertNull(updatedMovie);
	}


	//getbyID
	@Test
	public void getByIdMovieExists() throws MovieNotFoundException{
		Movie movie = new Movie();
		movie.setId(2);

		when(movieRepo.findById(2)).thenReturn(Optional.of(movie));

		Movie actualMovie = movieServ.getMovieById(2);
		assertEquals(movie, actualMovie);
	}

	@Test
	public void getByIdMovieDoesNotExist() throws MovieNotFoundException {
		when(movieRepo.findById(2)).thenReturn(Optional.empty());

		Movie actualMovie = movieServ.getMovieById(2);
		assertNull(actualMovie);
	}


	//getMovieByGenre
	@Test
	public void searchByGenreExists() throws MovieNotFoundException{
		String genre = "Action";

		when(movieRepo.findByGenre(genre)).thenReturn(mockMovies);

		Set<Movie> actualMovie = movieServ.getMovieByGenre(genre);
		boolean onlyGenre = true;
		for (Movie movie : actualMovie) {
			if (!movie.getGenre().equals(genre))
				onlyGenre = false;
		}

		assertTrue(onlyGenre);
	}

	@Test
	public void searchByGenreDoesNotExist() throws MovieNotFoundException{
		String genre = "boring";

		when(movieRepo.findByGenre(genre)).thenReturn(mockMovies);

		Set<Movie> actualGenre = movieServ.getMovieByGenre(genre);
		assertTrue(actualGenre.isEmpty());
	}

	//getByYear
	@Test
	public void searchByYearExists() {
		String year = "1990";

		when(movieRepo.findByYear(year)).thenReturn(mockMovies);

		Set<Movie> actualMovie = movieServ.getByYear(year);
		boolean onlyYear = true;
		for (Movie movie : actualMovie) {
			if (!movie.getGenre().equals(year))
				onlyYear = false;
		}

		assertTrue(onlyYear);
	}

	@Test
	public void searchByYearDoesNotExist() throws MovieNotFoundException{
		String year = "9000";

		when(movieRepo.findByYear(year)).thenReturn(mockMovies);

		Set<Movie> actualMovie = movieServ.getByYear(year);
		assertTrue(actualMovie.isEmpty());
	}

	//getMovieByName
	@Test
	public void searchByNameExists() throws MovieNotFoundException{
		String name = "Event Horizon";

		when(movieRepo.findByMovieNameContainingIgnoreCase(name)).thenReturn(mockMovies);

		Set<Movie> actualMovie = movieServ.getMovieByName(name);
		boolean onlyName = true;
		for (Movie movie : actualMovie) {
			if (!movie.getGenre().equals(name))
				onlyName = false;
		}

		assertTrue(onlyName);
	}

	@Test
	public void searchByNameDoesNotExist() {
		String name = "lololo";

		when(movieRepo.findByMovieNameContainingIgnoreCase(name)).thenReturn(mockMovies);

		Set<Movie> actualMovie = movieServ.getMovieByName(name);
		assertTrue(actualMovie.isEmpty());
	}

	// rateMovie   Composite Table 		Boolean
	
	
	// getAllReviewsForMovie
	@MockBean
	private ReviewRepository reviewRepo;
	
	private static Set<Review> mockReviews;
	

	// Mock
	@BeforeAll
	public static void mockReviewsSetup() {
		mockReviews = new HashSet<>();

		for (int i=1; i<=5; i++) {
			Review review = new Review();
			review.setId(i);
			name = String.valueOf(i);
			if (i<3)
				review.setReviewText("alchemy" + name);
			mockReviews.add(review);
		}
	}
	
	@Test //???
	public void getAllReviewsForMovie() {

		when(reviewRepo.findById(1)).thenReturn(null);//mockReviews, inside
		Set<Review> actualReviews = movieServ.getAllReviewsForMovie(1);
		assertEquals(mockReviews, actualReviews); 
	}

}

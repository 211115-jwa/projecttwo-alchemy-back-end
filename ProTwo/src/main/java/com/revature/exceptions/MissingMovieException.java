package com.revature.exceptions;

public class MissingMovieException extends Exception{
	
	private static final long serialVersionUID = -6511566985029314986L;

	public MissingMovieException() {
		super("The movie you are searching does not exist");
	}
}

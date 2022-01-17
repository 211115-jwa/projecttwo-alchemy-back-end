package com.revature.ProTwo.services;

import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.exceptions.CommentNotFoundException;

// POST to /movie/{movie_id}/{review_id}
public interface CommentService {
	
	public UserComment create(UserComment userCmm) throws CommentNotFoundException;
	
	public UserComment delete(UserComment userCmm);
}

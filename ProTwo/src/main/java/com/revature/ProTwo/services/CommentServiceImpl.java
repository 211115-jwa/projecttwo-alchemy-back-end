package com.revature.ProTwo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.data.UserCommentRepository;
import com.revature.ProTwo.data.UserRepository;
import com.revature.ProTwo.exceptions.CommentNotFoundException;
import com.revature.ProTwo.exceptions.ReviewNotFoundException;
import com.revature.ProTwo.exceptions.UsernameAlreadyExistsException;

@Service
public class CommentServiceImpl implements CommentService{

	
	private UserCommentRepository cmmtRepo;
	// constructor injection
	@Autowired
	public CommentServiceImpl(UserCommentRepository userRepo) {
		this.cmmtRepo = userRepo;
	}

	@Override
	public UserComment create(UserComment userCmm) throws CommentNotFoundException {
		
		int newCmm = cmmtRepo.save(userCmm).getId();
		if (newCmm > 0) {
			userCmm.setId(newCmm);
			return userCmm;
		} else if (newCmm == -1) {
			throw new CommentNotFoundException();
		}
		return null;
	}

	@Override
	public UserComment delete(UserComment userCmm) {
		cmmtRepo.delete(userCmm);
		return userCmm;
	}

}

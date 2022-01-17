package com.revature.ProTwo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.exceptions.CommentNotFoundException;
import com.revature.ProTwo.services.CommentService;

@RestController
@RequestMapping(path = "/userComment")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCommentController {

	private static CommentService cmmServ;

	@Autowired
	public UserCommentController(CommentService cmmServ) {
		UserCommentController.cmmServ=cmmServ;
	}

	// POST to /userComment, 
	public ResponseEntity<Map<String, Integer>> create(@RequestBody UserComment newUserCmm) {
		
		try {
			newUserCmm = cmmServ.create(newUserCmm);
			Map<String, Integer> newIdMap = new HashMap<>();
			newIdMap.put("generatedId", newUserCmm.getCommentId());
			return ResponseEntity.status(HttpStatus.CREATED).body(newIdMap);
		} catch (CommentNotFoundException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}// End of POST


	// POST to /userComment, 
	public ResponseEntity<Map<String, Integer>> delete(@RequestBody UserComment newUserCmm) 
			throws CommentNotFoundException {
		
		newUserCmm = cmmServ.delete(newUserCmm);
		Map<String, Integer> newIdMap = new HashMap<>();
		newIdMap.remove("generatedId", newUserCmm.getCommentId());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newIdMap);
	}

}
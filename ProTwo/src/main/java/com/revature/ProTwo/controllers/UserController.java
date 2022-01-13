package com.revature.ProTwo.controllers;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ProTwo.beans.User;

@RestController
@RequestMapping(path="/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	
	public ResponseEntity<Set<User>> viewUserByUsername(@PathVariable long userId) {
		return null;
		
	}
	
}

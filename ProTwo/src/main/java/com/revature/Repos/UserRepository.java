package com.revature.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}



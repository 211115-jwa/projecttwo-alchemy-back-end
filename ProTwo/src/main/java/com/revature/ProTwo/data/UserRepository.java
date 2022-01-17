package com.revature.ProTwo.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.beans.UserRank;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
	public Set<User> findByUserRank(UserRank rank);
}



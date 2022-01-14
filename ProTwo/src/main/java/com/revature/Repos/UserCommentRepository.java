package com.revature.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.UserComment;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Integer>{

}



package com.revature.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

}


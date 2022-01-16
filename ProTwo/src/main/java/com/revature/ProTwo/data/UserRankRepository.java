package com.revature.ProTwo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.UserRank;

@Repository
public interface UserRankRepository extends JpaRepository<UserRank, Integer>{

}


package com.revature.ProTwo.beans;

import java.util.Objects;

public class User {
private long userId;
private String firstName;
private String lastName;
private String username;
private String password;
private int rankId;

public User() {
	userId = 1L;
	firstName = null;
	lastName = null;
	username=null;
	password=null;
	rankId=0;
}

public long getUserId() {
	return userId;
}

public void setUserId(long userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getRankId() {
	return rankId;
}

public void setRankId(int rankId) {
	this.rankId = rankId;
}

@Override
public int hashCode() {
	return Objects.hash(firstName, lastName, password, rankId, userId, username);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
			&& Objects.equals(password, other.password) && rankId == other.rankId && userId == other.userId
			&& Objects.equals(username, other.username);
}

@Override
public String toString() {
	return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
			+ ", password=" + password + ", rankId=" + rankId + "]";
}


}

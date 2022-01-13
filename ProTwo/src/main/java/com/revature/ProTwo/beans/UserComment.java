package com.revature.ProTwo.beans;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserComment {

	private long commentId;
	private Review review;
	private User user;
	private String CommentText;
	private LocalDateTime sentAt;
	
	
	public UserComment() {

		commentId = 1L;
		review = new Review();
		user = new User();
		CommentText = "";
		sentAt = null;
		
		
	}


	public long getCommentId() {
		return commentId;
	}


	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}


	public Review getReview() {
		return review;
	}


	public void setReview(Review review) {
		this.review = review;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getCommentText() {
		return CommentText;
	}


	public void setCommentText(String commentText) {
		CommentText = commentText;
	}


	public LocalDateTime getSentAt() {
		return sentAt;
	}


	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}


	@Override
	public int hashCode() {
		return Objects.hash(CommentText, commentId, review, sentAt, user);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserComment other = (UserComment) obj;
		return Objects.equals(CommentText, other.CommentText) && commentId == other.commentId
				&& Objects.equals(review, other.review) && Objects.equals(sentAt, other.sentAt)
				&& Objects.equals(user, other.user);
	}


	@Override
	public String toString() {
		return "UserComment [commentId=" + commentId + ", review=" + review + ", user=" + user + ", CommentText="
				+ CommentText + ", sentAt=" + sentAt + "]";
	}
	
	
	
}

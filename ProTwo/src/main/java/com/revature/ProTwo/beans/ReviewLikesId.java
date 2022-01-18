package com.revature.ProTwo.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReviewLikesId implements Serializable {

	//default serialVersionUID
	private static final long serialVersionUID = 1L;

	//I included the schema but not sure if it is needed
	@Column(name = "p_user.id")
    private Long userId;

    @Column(name = "review.id")
    private Long reviewId;

	public ReviewLikesId(Long userId, Long reviewId) {
		super();
		this.userId = userId;
		this.reviewId = reviewId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reviewId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewLikesId other = (ReviewLikesId) obj;
		return Objects.equals(reviewId, other.reviewId) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "ReviewLikesId [userId=" + userId + ", reviewId=" + reviewId + "]";
	}
    
    
}

package com.revature.ProTwo.beans;

import java.util.Objects;

public class UserRank {
private long rankId;
private String rankTitle;

	public UserRank() {
		rankId = 1L;
		rankTitle = "User";
	}

	public long getRankId() {
		return rankId;
	}

	public void setRankId(long rankId) {
		this.rankId = rankId;
	}

	public String getRankTitle() {
		return rankTitle;
	}

	public void setRankTitle(String rankTitle) {
		this.rankTitle = rankTitle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rankId, rankTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRank other = (UserRank) obj;
		return rankId == other.rankId && Objects.equals(rankTitle, other.rankTitle);
	}

	@Override
	public String toString() {
		return "UserRank [rankId=" + rankId + ", rankTitle=" + rankTitle + "]";
	}
	
	
}

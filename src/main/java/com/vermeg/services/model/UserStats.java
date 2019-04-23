/**
 * 
 */
package com.vermeg.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
 

@Entity
@Table(name = "user_stats_t")
public class UserStats  extends AbstractEntity {
	 public UserStats() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserStats(@NotNull User user, @NotNull Integer plannification, @NotNull Integer issues,
			@NotNull Integer votes, @NotNull Integer firstVotesBelowEstimate, @NotNull Integer firstVotesAboveEstimate,
			@NotNull Integer firstVotesEqualEstimate, @NotNull Double averageFirstVoteLevelDifference) {
		super();
		this.user = user;
		this.plannification = plannification;
		this.issues = issues;
		this.votes = votes;
		this.firstVotesBelowEstimate = firstVotesBelowEstimate;
		this.firstVotesAboveEstimate = firstVotesAboveEstimate;
		this.firstVotesEqualEstimate = firstVotesEqualEstimate;
		this.averageFirstVoteLevelDifference = averageFirstVoteLevelDifference;
	}

	public static UserStats createEmpty(User user) {
		    UserStats userStats = new UserStats();
		    userStats.user = user;
		    userStats.plannification = 0;
		    userStats.issues = 0;
		    userStats.votes = 0;
		    userStats.firstVotesBelowEstimate = 0;
		    userStats.firstVotesAboveEstimate = 0;
		    userStats.firstVotesEqualEstimate = 0;
		    userStats.averageFirstVoteLevelDifference = 0D;
		    return userStats;
		  }

	 
	 //region Data
	  @OneToOne
	  @JoinColumn(nullable = false, unique = true)
	  @NotNull
	  private User user;

	  @Column(nullable = false)
	  @NotNull
	  private Integer plannification;

	  @Column(nullable = false)
	  @NotNull
	  private Integer issues;

	  @Column(nullable = false)
	  @NotNull
	  private Integer votes;

	  @Column(nullable = false)
	  @NotNull
	  private Integer firstVotesBelowEstimate;

	  @Column(nullable = false)
	  @NotNull
	  private Integer firstVotesAboveEstimate;

	  @Column(nullable = false)
	  @NotNull
	  private Integer firstVotesEqualEstimate;

	  @Column(nullable = false)
	  @NotNull
	  private Double averageFirstVoteLevelDifference;
	  //endregion

	  //region Methods
	  public void incrementPlannings() {
	    plannification++;
	  }

	  public void incrementIssues() {
	    issues++;
	  }

	  public void incrementVotes() {
	    votes++;
	  }

	  public void updateFirstVoteStatistics(Integer firstVoteLevel, Integer estimateLevel) {
	    int levelDifference = firstVoteLevel - estimateLevel;
	    updateAverageFirstVoteLevelDifference(levelDifference);
	    incrementFirstVotesCount(levelDifference);
	  }

	  private void updateAverageFirstVoteLevelDifference(int levelDifference) {
	    double totalLevelDifference = getFirstVotes() * averageFirstVoteLevelDifference;
	    totalLevelDifference += levelDifference;
	    averageFirstVoteLevelDifference = totalLevelDifference / (getFirstVotes() + 1);
	  }

	  private Integer getFirstVotes() {
	    return firstVotesBelowEstimate + firstVotesAboveEstimate + firstVotesEqualEstimate;
	  }

	  private void incrementFirstVotesCount(int levelDifference) {
	    if (levelDifference < 0) {
	      firstVotesBelowEstimate++;
	    } else if (levelDifference > 0) {
	      firstVotesAboveEstimate++;
	    } else {
	      firstVotesEqualEstimate++;
	    }
	  }
	  //end region

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getPlannification() {
		return plannification;
	}

	public void setPlannification(Integer plannification) {
		this.plannification = plannification;
	}

	public Integer getIssues() {
		return issues;
	}

	public void setIssues(Integer issues) {
		this.issues = issues;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Integer getFirstVotesBelowEstimate() {
		return firstVotesBelowEstimate;
	}

	public void setFirstVotesBelowEstimate(Integer firstVotesBelowEstimate) {
		this.firstVotesBelowEstimate = firstVotesBelowEstimate;
	}

	public Integer getFirstVotesAboveEstimate() {
		return firstVotesAboveEstimate;
	}

	public void setFirstVotesAboveEstimate(Integer firstVotesAboveEstimate) {
		this.firstVotesAboveEstimate = firstVotesAboveEstimate;
	}

	public Integer getFirstVotesEqualEstimate() {
		return firstVotesEqualEstimate;
	}

	public void setFirstVotesEqualEstimate(Integer firstVotesEqualEstimate) {
		this.firstVotesEqualEstimate = firstVotesEqualEstimate;
	}

	public Double getAverageFirstVoteLevelDifference() {
		return averageFirstVoteLevelDifference;
	}

	public void setAverageFirstVoteLevelDifference(Double averageFirstVoteLevelDifference) {
		this.averageFirstVoteLevelDifference = averageFirstVoteLevelDifference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((averageFirstVoteLevelDifference == null) ? 0 : averageFirstVoteLevelDifference.hashCode());
		result = prime * result + ((firstVotesAboveEstimate == null) ? 0 : firstVotesAboveEstimate.hashCode());
		result = prime * result + ((firstVotesBelowEstimate == null) ? 0 : firstVotesBelowEstimate.hashCode());
		result = prime * result + ((firstVotesEqualEstimate == null) ? 0 : firstVotesEqualEstimate.hashCode());
		result = prime * result + ((issues == null) ? 0 : issues.hashCode());
		result = prime * result + ((plannification == null) ? 0 : plannification.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((votes == null) ? 0 : votes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserStats other = (UserStats) obj;
		if (averageFirstVoteLevelDifference == null) {
			if (other.averageFirstVoteLevelDifference != null)
				return false;
		} else if (!averageFirstVoteLevelDifference.equals(other.averageFirstVoteLevelDifference))
			return false;
		if (firstVotesAboveEstimate == null) {
			if (other.firstVotesAboveEstimate != null)
				return false;
		} else if (!firstVotesAboveEstimate.equals(other.firstVotesAboveEstimate))
			return false;
		if (firstVotesBelowEstimate == null) {
			if (other.firstVotesBelowEstimate != null)
				return false;
		} else if (!firstVotesBelowEstimate.equals(other.firstVotesBelowEstimate))
			return false;
		if (firstVotesEqualEstimate == null) {
			if (other.firstVotesEqualEstimate != null)
				return false;
		} else if (!firstVotesEqualEstimate.equals(other.firstVotesEqualEstimate))
			return false;
		if (issues == null) {
			if (other.issues != null)
				return false;
		} else if (!issues.equals(other.issues))
			return false;
		if (plannification == null) {
			if (other.plannification != null)
				return false;
		} else if (!plannification.equals(other.plannification))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (votes == null) {
			if (other.votes != null)
				return false;
		} else if (!votes.equals(other.votes))
			return false;
		return true;
	}
}

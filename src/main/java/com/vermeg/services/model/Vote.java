package com.vermeg.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(
    name = "vote_t",
    uniqueConstraints = @UniqueConstraint(columnNames = {"issue_id", "user_id", "iteration"}))

public class Vote extends AbstractEntity {

  public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}

public Vote(@NotNull Issue issue, @NotNull User user, @NotNull Integer iteration,
			@NotNull @Size(max = 32) String value) {
		super();
		this.issue = issue;
		this.user = user;
		this.iteration = iteration;
		this.value = value;
	}

//region Data
  @ManyToOne
  @JoinColumn(nullable = false)
  @NotNull
  private Issue issue;

  @ManyToOne
  @JoinColumn(nullable = false)
  @NotNull
  private User user;

  @Column(nullable = false)
  @NotNull
  private Integer iteration;

  @Column(nullable = false, length = 32)
  @NotNull
  @Size(max = 32)
  private String value;
  //end region

public Issue getIssue() {
	return issue;
}

public void setIssue(Issue issue) {
	this.issue = issue;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Integer getIteration() {
	return iteration;
}

public void setIteration(Integer iteration) {
	this.iteration = iteration;
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((issue == null) ? 0 : issue.hashCode());
	result = prime * result + ((iteration == null) ? 0 : iteration.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
	result = prime * result + ((value == null) ? 0 : value.hashCode());
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
	Vote other = (Vote) obj;
	if (issue == null) {
		if (other.issue != null)
			return false;
	} else if (!issue.equals(other.issue))
		return false;
	if (iteration == null) {
		if (other.iteration != null)
			return false;
	} else if (!iteration.equals(other.iteration))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	if (value == null) {
		if (other.value != null)
			return false;
	} else if (!value.equals(other.value))
		return false;
	return true;
}
}

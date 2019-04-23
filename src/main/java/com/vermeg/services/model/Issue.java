package com.vermeg.services.model;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "issue_t")

public class Issue extends AbstractEntity {

  public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}

public Issue(@NotNull Plannification plannification, @NotNull @Size(max = 32) String code,
			@NotNull @Size(min = 3, max = 32) String name, @Size(max = 255) String description,
			@NotNull Integer finishedIterations, @Size(max = 32) String estimate, boolean active, Set<Vote> votes) {
		super();
		this.plannification = plannification;
		this.code = code;
		this.name = name;
		this.description = description;
		this.finishedIterations = finishedIterations;
		this.estimate = estimate;
		this.active = active;
		this.votes = votes;
	}

//region Data
  @ManyToOne
  @JoinColumn(nullable = false)
  @NotNull
  private Plannification plannification;

  @Column(nullable = false, length = 32)
  @NotNull
  @Size(max = 32)
  private String code;

  @Column(nullable = false, length = 32)
  @NotNull
  @Size(min = 3, max = 32)
  private String name;

  @Column
  @Size(max = 255)
  private String description;

  @Column(nullable = false)
  @NotNull
  private Integer finishedIterations;

  @Column
  @Size(max = 32)
  private String estimate;

  @Column(nullable = false)
  private boolean active;
  //endregion

  //region Mappings
  @OneToMany(mappedBy = "issue", cascade = CascadeType.REMOVE)
  @OrderBy("iteration asc")
  private Set<Vote> votes = new LinkedHashSet<>();
  //endregion

  //region Optional getters
  public Optional<String> getDescription() {
    return Optional.ofNullable(description);
  }

  public Optional<String> getEstimate() {
    return Optional.ofNullable(estimate);
  }
  //endregion

public Plannification getPlannification() {
	return plannification;
}

public void setPlannification(Plannification plannification) {
	this.plannification = plannification;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getFinishedIterations() {
	return finishedIterations;
}

public void setFinishedIterations(Integer finishedIterations) {
	this.finishedIterations = finishedIterations;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public Set<Vote> getVotes() {
	return votes;
}

public void setVotes(Set<Vote> votes) {
	this.votes = votes;
}

public void setDescription(String description) {
	this.description = description;
}

public void setEstimate(String estimate) {
	this.estimate = estimate;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (active ? 1231 : 1237);
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((estimate == null) ? 0 : estimate.hashCode());
	result = prime * result + ((finishedIterations == null) ? 0 : finishedIterations.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((plannification == null) ? 0 : plannification.hashCode());
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
	Issue other = (Issue) obj;
	if (active != other.active)
		return false;
	if (code == null) {
		if (other.code != null)
			return false;
	} else if (!code.equals(other.code))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (estimate == null) {
		if (other.estimate != null)
			return false;
	} else if (!estimate.equals(other.estimate))
		return false;
	if (finishedIterations == null) {
		if (other.finishedIterations != null)
			return false;
	} else if (!finishedIterations.equals(other.finishedIterations))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (plannification == null) {
		if (other.plannification != null)
			return false;
	} else if (!plannification.equals(other.plannification))
		return false;
	if (votes == null) {
		if (other.votes != null)
			return false;
	} else if (!votes.equals(other.votes))
		return false;
	return true;
}
}

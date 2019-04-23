package com.vermeg.services.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "planning_t")
@ApiModel(description = "All details about the Plannification model.")

public class Plannification extends AbstractEntity {


	public Plannification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plannification(Long id, @NotNull Priority priority, @NotNull Date startDate, @NotNull Date endDate,
			@NotNull Estimation originalEstimation, Estimation remainingEstimation, @NotNull Deck deck,
			@NotNull @Size(max = 32) String code, @Size(max = 255) String description, boolean finished,
			@NotNull User moderator, Set<User> users, Set<Issue> issues) {
		super();
		this.id = id;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.originalEstimation = originalEstimation;
		this.remainingEstimation = remainingEstimation;
		this.deck = deck;
		this.code = code;
		this.description = description;
		this.finished = finished;
		this.moderator = moderator;
		this.users = users;
		this.issues = issues;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@ApiModelProperty(position=0)
	private Long id;


	@NotNull
	@Enumerated(EnumType.STRING)
	private Priority priority;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@NotNull
	@OneToOne
	@JoinColumn(name = "originalEstimation_id", referencedColumnName = "id")
	private Estimation originalEstimation;

	@Transient
	private Estimation remainingEstimation;
	
	 @ManyToOne
	  @JoinColumn(nullable = false)
	  @NotNull
	  private Deck deck;
	 
	 @Column(nullable = false, unique = true, length = 32)
	  @NotNull
	  @Size(max = 32)
	  private String code;
	 
	 
	  @Column
	  @Size(max = 255)
	  private String description;

	  @Column(nullable = false)
	  private boolean finished;

	  @ManyToOne
	  @JoinColumn(nullable = false)
	  @NotNull
	  private User moderator;
	  //end region

	  //region Mappings
	  @ManyToMany
	  @JoinTable(
	      name = "planning_users_t",
	      joinColumns = @JoinColumn(name = "planning_id"),
	      inverseJoinColumns = @JoinColumn(name = "user_id"),
	      uniqueConstraints = @UniqueConstraint(columnNames = {"planning_id", "user_id"}))
	  @OrderBy("username asc")
	  private Set<User> users = new LinkedHashSet<>();

	  @OneToMany(mappedBy = "planning", cascade = CascadeType.REMOVE)
	  @OrderBy("id desc")
	  private Set<Issue> issues = new LinkedHashSet<>();
	  //end region

	  //region Optional getters
	  public Optional<String> getDescription() {
		  return Optional.ofNullable(description);
	  }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Estimation getOriginalEstimation() {
		return originalEstimation;
	}

	public void setOriginalEstimation(Estimation originalEstimation) {
		this.originalEstimation = originalEstimation;
	}

	public Estimation getRemainingEstimation() {
		return remainingEstimation;
	}

	public void setRemainingEstimation(Estimation remainingEstimation) {
		this.remainingEstimation = remainingEstimation;
	}


	  //region Methods
	  public boolean hasModerator(User user) {
	    return this.getModerator().equals(user);
	  }

	  public boolean containsUser(User user) {
	    return this.getUsers().contains(user);
	  }

	  public void removeAllUsers() {
	    users.clear();
	  }
	  //end region
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public User getModerator() {
		return moderator;
	}
	public void setModerator(User moderator) {
		this.moderator = moderator;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Issue> getIssues() {
		return issues;
	}
	public void setIssues(Set<Issue> issues) {
		this.issues = issues;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((deck == null) ? 0 : deck.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (finished ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((issues == null) ? 0 : issues.hashCode());
		result = prime * result + ((moderator == null) ? 0 : moderator.hashCode());
		result = prime * result + ((originalEstimation == null) ? 0 : originalEstimation.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((remainingEstimation == null) ? 0 : remainingEstimation.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Plannification other = (Plannification) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (deck == null) {
			if (other.deck != null)
				return false;
		} else if (!deck.equals(other.deck))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (finished != other.finished)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issues == null) {
			if (other.issues != null)
				return false;
		} else if (!issues.equals(other.issues))
			return false;
		if (moderator == null) {
			if (other.moderator != null)
				return false;
		} else if (!moderator.equals(other.moderator))
			return false;
		if (originalEstimation == null) {
			if (other.originalEstimation != null)
				return false;
		} else if (!originalEstimation.equals(other.originalEstimation))
			return false;
		if (priority != other.priority)
			return false;
		if (remainingEstimation == null) {
			if (other.remainingEstimation != null)
				return false;
		} else if (!remainingEstimation.equals(other.remainingEstimation))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
}

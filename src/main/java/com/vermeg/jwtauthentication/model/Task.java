package com.vermeg.jwtauthentication.model;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	@NotNull
	private String label;

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

	public Estimation getOriginalEstimation() {
		return originalEstimation;
	}

	public void setOriginalEstimation(Estimation originalEstimation) {
		this.originalEstimation = originalEstimation;
	}

	public Estimation getRemainingEstimation() {
		int timeDif = Calendar.getInstance().getTime().compareTo(startDate);
		Calendar c = Calendar.getInstance(); 
		
		return remainingEstimation;
	}

	public Estimation getEstimation() {
		return originalEstimation;
	}

	public void setEstimation(Estimation estimation) {
		this.originalEstimation = estimation;
	}

	@NotNull
	@ManyToMany
	@JoinTable(name = "task_assignee", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "assignee_id"))
	private Set<User> assignee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public Set<User> getAssignee() {
		return assignee;
	}

	public void setAssignee(Set<User> assignee) {
		this.assignee = assignee;
	}
}
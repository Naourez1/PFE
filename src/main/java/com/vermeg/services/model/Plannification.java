package com.vermeg.services.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "plannification")
@ApiModel(description = "All details about the Plannification model.")

public class Plannification {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@ApiModelProperty(position=0)
	private Long id;

	@Column(unique = true)
	@NotNull
	private String label;
	
	
	@NotNull
	private String desription;

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

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
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

	
	
}

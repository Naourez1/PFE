package com.vermeg.services.dto;

import java.util.Date;
import com.vermeg.services.model.Estimation;
import io.swagger.annotations.ApiModelProperty;

public class SprintDTO {

	@ApiModelProperty(position = 0)
	private Long id;

	@ApiModelProperty(position = 1)
	private String label;
	
	@ApiModelProperty(position = 2)
	private String priority;
	@ApiModelProperty(position = 3)
	private Date startDate;
	@ApiModelProperty(position = 4)
	private Date endtDate;
	@ApiModelProperty(position = 5)
	private Estimation originalEstimation;
	@ApiModelProperty(position = 6)
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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndtDate() {
		return endtDate;
	}

	public void setEndtDate(Date endtDate) {
		this.endtDate = endtDate;
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

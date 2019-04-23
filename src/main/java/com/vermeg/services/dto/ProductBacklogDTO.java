package com.vermeg.services.dto;

import com.vermeg.services.model.Estimation;

import io.swagger.annotations.ApiModelProperty;

public class ProductBacklogDTO {
	@ApiModelProperty(position = 0)
	private Long id;
	@ApiModelProperty(position = 1)
	private String label;
	@ApiModelProperty(position = 2)
	private Estimation originalEstimation;
	@ApiModelProperty(position = 3)
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

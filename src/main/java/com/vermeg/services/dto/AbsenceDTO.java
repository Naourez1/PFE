package com.vermeg.services.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class AbsenceDTO {

	
	@ApiModelProperty(position = 0)
	private Long id;
	@ApiModelProperty(position = 1)
	private String description;
	
	@ApiModelProperty(position = 2)
	private Date startDate;
	@ApiModelProperty(position = 3)
	private Date endtDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
}

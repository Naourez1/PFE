package com.vermeg.services.dto;

import java.util.Date;
import com.vermeg.services.model.Status;
import io.swagger.annotations.ApiModelProperty;
public class ProjectDTO {

	
	@ApiModelProperty(position = 0)
	private Long id;
	@ApiModelProperty(position = 1)
	private String label;
	@ApiModelProperty(position = 2)
	private String description;
	@ApiModelProperty(position = 3)
	private Date startDate;
	@ApiModelProperty(position = 4)
	private Date endDate;
	@ApiModelProperty(position = 5)
	private Status status;
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

}

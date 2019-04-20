package com.vermeg.services.dto;

import io.swagger.annotations.ApiModelProperty;

public class SprintDTO {

	@ApiModelProperty(position = 0)
	private Long id;

	@ApiModelProperty(position = 1)
	private String label;

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

}

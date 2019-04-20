package com.vermeg.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "sprint")
@ApiModel(description = "All details about the Sprint model.")
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@ApiModelProperty(position = 0)
	private Long id;

	@Column(unique = true)
	@NotNull
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

	public Sprint(Long id, @NotNull String label) {
		super();
		this.id = id;
		this.label = label;
	}

	public Sprint() {
		super();
	}

}

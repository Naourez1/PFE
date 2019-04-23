package com.vermeg.services.dto;


import com.vermeg.services.model.Task;

import io.swagger.annotations.ApiModelProperty;

public class EstimationDTO {

	
	@ApiModelProperty(position = 0)
	private Long id;
	@ApiModelProperty(position = 1)
	private Task task;
	@ApiModelProperty(position = 2)
	private int week;
	@ApiModelProperty(position = 3)
	private int day;
	@ApiModelProperty(position = 4)
	private int hour;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	
}

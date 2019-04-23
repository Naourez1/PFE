package com.vermeg.services.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "original_estimation")
public class Estimation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToOne(mappedBy = "originalEstimation")
	private Task task;

	private int week;
	private int day;
	private int hour;

	@OneToOne(mappedBy = "originalEstimation")
	private Sprint sprint;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Estimation(int week, int day, int hour) {
		super();
		this.week = week;
		this.day = day;
		this.hour = hour;
	}

	@Override
	public String toString() {
		return String.valueOf(week) + "w" + String.valueOf(day) + "d" + String.valueOf(hour) + "h";
	}

}

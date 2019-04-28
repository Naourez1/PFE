package com.vermeg.services.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;


@Entity
@Table(name = "absence")
public class Absence {
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureDate;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	private String description;

}

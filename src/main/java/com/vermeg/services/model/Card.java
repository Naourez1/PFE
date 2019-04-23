package com.vermeg.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "card_t")
public class Card extends AbstractEntity {
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(@NotNull Integer level, @NotNull @Size(max = 32) String value) {
		super();
		this.level = level;
		this.value = value;
	}

	//region Data
	  @Column(nullable = false)
	  @NotNull
	  private Integer level;

	  @Column(nullable = false, length = 32)
	  @NotNull
	  @Size(max = 32)
	  private String value;
	  //end region

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}

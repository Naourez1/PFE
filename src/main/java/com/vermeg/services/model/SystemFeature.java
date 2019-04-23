package com.vermeg.services.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "system_feature_t")
public class SystemFeature extends AbstractEntity {

	  public SystemFeature() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemFeature(@NotNull @Size(max = 32) String code, @NotNull boolean enabled) {
		super();
		this.code = code;
		this.enabled = enabled;
	}

	//region Data
	  @Column(nullable = false, unique = true, length = 32)
	  @NotNull
	  @Size(max = 32)
	  private String code;

	  @Column(nullable = false)
	  @NotNull
	  private boolean enabled;
	  //end region

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
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
		SystemFeature other = (SystemFeature) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (enabled != other.enabled)
			return false;
		return true;
	}
}

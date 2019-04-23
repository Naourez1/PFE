package com.vermeg.services.model;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

public abstract class AbstractEntity {

	  @Id
	  @Column(nullable = false, updatable = false)
	  @GeneratedValue(generator = "abstract-generator")
	  protected Long id;

	  @Version
	  @Column(nullable = false)
	  private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	}
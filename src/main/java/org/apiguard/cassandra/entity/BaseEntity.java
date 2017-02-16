package org.apiguard.cassandra.entity;

import java.util.Date;
import java.util.UUID;

import org.apiguard.entity.Base;

public class BaseEntity implements Base {

	private UUID id;
	
	private Date creationDate;

	private Date lastUpdateDate;
	
	public BaseEntity() {
	}
	
	public BaseEntity(UUID id, Date creationDate, Date lastUpdateDate) {
		this.id = id;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
}

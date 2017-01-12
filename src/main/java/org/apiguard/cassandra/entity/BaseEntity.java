package org.apiguard.cassandra.entity;

import java.util.Date;
import java.util.UUID;

import org.apiguard.entity.Base;

public class BaseEntity implements Base {

	private UUID id;
	
	private Date creationDate;

	private Date lastUpdateDate;
	
	public BaseEntity(UUID id, Date creationDate) {
		this.id = id;
		this.creationDate = creationDate;
	}

	public UUID getId() {
		return id;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
}

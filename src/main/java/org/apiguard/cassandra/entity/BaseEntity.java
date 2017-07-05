package org.apiguard.cassandra.entity;

import org.apiguard.entity.Base;

import java.util.Date;

public class BaseEntity implements Base {

	private String id;
	
	private Date creationDate;

	private Date lastUpdateDate;
	
	public BaseEntity() {
	}
	
	public BaseEntity(String id, Date creationDate, Date lastUpdateDate) {
		this.id = id;
		this.creationDate = creationDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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

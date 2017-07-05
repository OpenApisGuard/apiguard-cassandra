package org.apiguard.cassandra.entity;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

@Table("apiName")
public class ApiNameEntity extends BaseEntity {

	@PrimaryKey
	private String name;

	private String reqUri;

	public ApiNameEntity(String id, Date creationDate, Date lastUpdateDate, String name, String reqUri) {
		super(id, creationDate, lastUpdateDate);
		this.reqUri = reqUri;
		this.name = name;
	}

	public String getReqUri() {
		return reqUri;
	}

	public String getName() {
		return name;
	}
}

package org.apiguard.cassandra.entity;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("apiName")
public class ApiNameEntity extends BaseEntity {

	@PrimaryKey
	private String name;

	private String reqUri;

	public ApiNameEntity(UUID id, Date creationDate, String name, String reqUri) {
		super(id, creationDate);
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

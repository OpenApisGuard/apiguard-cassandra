package org.apiguard.cassandra.entity;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table("apiReqUriIndx")
public class ApiReqUriIndexEntity extends BaseEntity {

	@PrimaryKey
	private String prefix;

	private List<String> matches;

	public ApiReqUriIndexEntity(UUID id, Date creationDate, Date lastUpdateDate, String prefix, List<String> matches) {
		super(id, creationDate, lastUpdateDate);
		this.prefix = prefix;
		this.matches = matches;
	}

	public String getPrefix() {
		return prefix;
	}

	public List<String> getMatches() {
		return matches;
	}
}

package org.apiguard.cassandra.entity;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("authKey")
public class ClientEntity extends BaseEntity {

	@PrimaryKey
	private String clientId;

	public ClientEntity(UUID id, Date creationDate, String clientId) {
		super(id, creationDate);
		this.clientId = clientId;
	}

	public String getClientId() {
		return clientId;
	}
}

package org.apiguard.cassandra.entity;

import org.apiguard.entity.Client;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

@Table("client")
public class ClientEntity extends BaseEntity implements Client {

	@PrimaryKey
	private String clientId;
	
	public ClientEntity(String id, Date creationDate, Date lastUpdateDate, String clientId) {
		super(id, creationDate, lastUpdateDate);
		this.clientId = clientId;
	}

	public String getClientId() {
		return clientId;
	}
}

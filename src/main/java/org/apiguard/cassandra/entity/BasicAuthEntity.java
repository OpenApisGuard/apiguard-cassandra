package org.apiguard.cassandra.entity;

import org.apiguard.entity.BasicAuth;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;

@Table("basicAuth")
public class BasicAuthEntity extends BaseEntity implements BasicAuth {

	@PrimaryKey
	private BasicAuthId pk;

	private String password;

	public BasicAuthEntity() {
	}
	
	public BasicAuthEntity(String id, Date creationDate, Date lastUpdateDate, String reqUri, String clientId,
			String password) {
		super(id, creationDate, lastUpdateDate);
		pk = new BasicAuthId(reqUri, clientId);
		this.password = password;
	}

	public BasicAuthId getPk() {
		return pk;
	}

	public void setPk(BasicAuthId pk) {
		this.pk = pk;
	}

	public String getClientId() {
		return pk.getClientId();
	}

	public String getReqUri() {
		return pk.getReqUri();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

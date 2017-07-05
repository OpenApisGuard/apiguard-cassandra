package org.apiguard.cassandra.entity;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@PrimaryKeyClass
public class LdapAuthId implements Serializable {
	private static final long serialVersionUID = 1L;

	@PrimaryKeyColumn(name = "reqUri", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String reqUri;

	@PrimaryKeyColumn(name = "clientId", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private String clientId;

	public LdapAuthId(String reqUri, String clientId) {
		this.clientId = clientId;
		this.reqUri = reqUri;
	}

	public String getClientId() {
		return clientId;
	}

	public String getReqUri() {
		return reqUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clientId.hashCode();
		result = prime * result + reqUri.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LdapAuthId other = (LdapAuthId) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (reqUri == null) {
			if (other.reqUri != null)
				return false;
		} else if (!reqUri.equals(other.reqUri))
			return false;
		return true;
	}
}

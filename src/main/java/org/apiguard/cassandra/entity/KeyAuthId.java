package org.apiguard.cassandra.entity;

import java.io.Serializable;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class KeyAuthId implements Serializable {
	private static final long serialVersionUID = 1L;

	@PrimaryKeyColumn(name = "reqUri", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String reqUri;

	@PrimaryKeyColumn(name = "key", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private String key;

	public KeyAuthId(String reqUri, String key) {
		this.key = key;
		this.reqUri = reqUri;
	}

	public String getKey() {
		return key;
	}

	public String getReqUri() {
		return reqUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key.hashCode();
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
		KeyAuthId other = (KeyAuthId) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (reqUri == null) {
			if (other.reqUri != null)
				return false;
		} else if (!reqUri.equals(other.reqUri))
			return false;
		return true;
	}
}

package org.apiguard.cassandra.entity;

import java.util.Date;
import java.util.UUID;

import org.apiguard.entity.Api;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/*
 * CREATE TABLE apiguard.apis (
 *	    id uuid,
 *	    name text,
 *	    reqUri text,
 *	    fwdUri text,
 *	    creationDate timestamp,
 *	    PRIMARY KEY (reqUri)
 *	)
 */

@Table("api")
public class ApiEntity extends BaseEntity implements Api {

	@PrimaryKey
	private String reqUri;

	private String name;

	private String fwdUri;

	private boolean isAuthRequired;

	private boolean isBasicAuth;

	private boolean isKeyAuth;
	
	private boolean isHmacAuth;
	
	private boolean isOAuth2Auth;
	
	private boolean isJwtAuth;
	
	private boolean isLdapAuth;

	public ApiEntity(UUID id, Date creationDate, String name, String reqUri, String fwdUri) {
		super(id, creationDate);
		this.reqUri = reqUri;
		this.name = name;
		this.fwdUri = fwdUri;
	}

	public String getReqUri() {
		return reqUri;
	}

	public String getName() {
		return name;
	}

	public String getFwdUri() {
		return fwdUri;
	}
	
	public void setAuthRequired(boolean isAuthRequired) {
		this.isAuthRequired = isAuthRequired;
	}

	public boolean isAuthRequired() {
		return isAuthRequired;
	}
	
	public boolean isBasicAuth() {
		return isBasicAuth;
	}

	public void setBasicAuth(boolean isBasicAuth) {
		this.isBasicAuth = isBasicAuth;
	}

	public boolean isKeyAuth() {
		return isKeyAuth;
	}

	public void setKeyAuth(boolean isKeyAuth) {
		this.isKeyAuth = isKeyAuth;
	}

	public boolean isHmacAuth() {
		return isHmacAuth;
	}

	public void setHmacAuth(boolean isHmacAuth) {
		this.isHmacAuth = isHmacAuth;
	}

	public boolean isOAuth2Auth() {
		return isOAuth2Auth;
	}

	public void setOAuth2Auth(boolean isOAuth2Auth) {
		this.isOAuth2Auth = isOAuth2Auth;
	}

	public boolean isJwtAuth() {
		return isJwtAuth;
	}

	public void setJwtAuth(boolean isJwtAuth) {
		this.isJwtAuth = isJwtAuth;
	}

	public boolean isLdapAuth() {
		return isLdapAuth;
	}

	public void setLdapAuth(boolean isLdapAuth) {
		this.isLdapAuth = isLdapAuth;
	}

	@Override
	public String toString() {
		return "Api [id=" + getId() + ", name=" + name + ", reqUri=" + reqUri + ", fwdUri=" + fwdUri + ", creationDate="
				+ getCreationDate() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reqUri == null) ? 0 : reqUri.hashCode())
				+ ((fwdUri == null) ? 0 : fwdUri.hashCode());
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
		ApiEntity other = (ApiEntity) obj;
		if (reqUri == null) {
			if (other.reqUri != null)
				return false;
		} else if (!reqUri.equals(other.reqUri))
			return false;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
}

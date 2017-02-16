package org.apiguard.cassandra.entity;

import java.util.Date;
import java.util.UUID;

import org.apiguard.entity.KeyAuth;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 * That's not going to work. Your current PRIMARY KEY is:
 * 
 * PRIMARY KEY ((dc_name, time_bucket, partition), perf_name, vm_name,
 * measurement_time) Try to think of using a compound PRIMARY KEY in Cassandra
 * as a hierarchical path, starting from left to right. dc_name, time_bucket,
 * and partition are a part of your partitioning key, so you'll need to include
 * each of those in your WHERE to ensure that Cassandra can find where your data
 * is stored.
 * 
 * All of the columns after that are clustering columns (perf_name, vm_name, and
 * measurement_time), which determine the sort order of your data on disk.
 * Again, you can't pick and choose which of these to include. You need to
 * search on them in the order that they are defined in your schema. So if you
 * want to query by vm_name, then you also need to make sure that the preceding
 * column keys (perf_name in this case) are also present in your WHERE clause.
 * 
 * Basically to query this schema, add ANDs to your WHERE clause for:
 * 
 * partition perf_name
 * 
 */

@Table("keyAuth")
public class KeyAuthEntity extends BaseEntity implements KeyAuth {

	@PrimaryKey
	private KeyAuthId pk;

	private String clientId;

	public KeyAuthEntity() {
	}
	
	public KeyAuthEntity(UUID id, Date creationDate, Date lastUpdateDate, String reqUri, String key, String clientId) {
		super(id, creationDate, lastUpdateDate);
		pk = new KeyAuthId(reqUri, key);
		this.clientId = clientId;
	}

	public String getKey() {
		return pk.getKey();
	}

	public String getReqUri() {
		return pk.getReqUri();
	}

	public String getClientId() {
		return clientId;
	}

	public KeyAuthId getPk() {
		return pk;
	}

	public void setPk(KeyAuthId pk) {
		this.pk = pk;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}

package org.apiguard.cassandra.entity;

import java.util.Date;
import java.util.UUID;

import org.apiguard.entity.Auth;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * hat's not going to work. Your current PRIMARY KEY is:
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

@Table("client")
public class AuthKeyEntity extends BaseEntity implements Auth {

	@PrimaryKeyColumn(name = "reqUri", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String reqUri;

	@PrimaryKeyColumn(name = "key", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private String key;

	@PrimaryKeyColumn(name = "clientId", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private String clientId;

	public AuthKeyEntity(UUID id, Date creationDate, String key, String reqUri, String clientId) {
		super(id, creationDate);
		this.key = key;
		this.reqUri = reqUri;
		this.clientId = clientId;
	}

	public String getKey() {
		return key;
	}

	public String getReqUri() {
		return reqUri;
	}

	public String getClientId() {
		return clientId;
	}
}

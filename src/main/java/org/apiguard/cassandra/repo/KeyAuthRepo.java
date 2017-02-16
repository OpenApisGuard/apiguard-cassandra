package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.KeyAuthEntity;
import org.apiguard.cassandra.entity.KeyAuthId;
import org.springframework.data.repository.CrudRepository;

public interface KeyAuthRepo extends CrudRepository<KeyAuthEntity, KeyAuthId> {
	
}

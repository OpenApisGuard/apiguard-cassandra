package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.KeyAuthEntity;
import org.apiguard.cassandra.entity.KeyAuthId;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KeyAuthRepo extends CrudRepository<KeyAuthEntity, KeyAuthId> {

    //TODO: replace me, ok for now
    @Query("select * from keyAuth where requri = ?0 allow filtering")
    List<KeyAuthEntity> findByReqUri(String reqUri);
	
}

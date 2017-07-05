package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.BasicAuthEntity;
import org.apiguard.cassandra.entity.BasicAuthId;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BasicAuthRepo extends CrudRepository<BasicAuthEntity, BasicAuthId> {

    //TODO: replace me, ok for now
    @Query("select * from basicAuth where requri = ?0 allow filtering")
    List<BasicAuthEntity> findByReqUri(String reqUri);
}

package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.JwtAuthEntity;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JwtAuthRepo extends CrudRepository<JwtAuthEntity, String> {

    //TODO: replace me, ok for now
    @Query("select * from jwtAuth where requri = ?0 allow filtering")
    List<JwtAuthEntity> findByReqUri(String reqUri);
}

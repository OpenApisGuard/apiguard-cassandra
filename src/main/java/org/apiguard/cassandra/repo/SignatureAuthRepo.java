package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.SignatureAuthEntity;
import org.apiguard.cassandra.entity.SignatureAuthId;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SignatureAuthRepo extends CrudRepository<SignatureAuthEntity, SignatureAuthId> {

    @Query("select * from signatureAuth where requri = ?0 allow filtering")
    List<SignatureAuthEntity> findByReqUri(String reqUri);

}

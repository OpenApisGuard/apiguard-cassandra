package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.BasicAuthEntity;
import org.apiguard.cassandra.entity.BasicAuthId;
import org.apiguard.cassandra.entity.SignatureAuthEntity;
import org.apiguard.cassandra.entity.SignatureAuthId;
import org.springframework.data.repository.CrudRepository;

public interface SignatureAuthRepo extends CrudRepository<SignatureAuthEntity, SignatureAuthId> {

}

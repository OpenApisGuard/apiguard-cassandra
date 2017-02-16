package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.BasicAuthEntity;
import org.apiguard.cassandra.entity.BasicAuthId;
import org.springframework.data.repository.CrudRepository;

public interface BasicAuthRepo extends CrudRepository<BasicAuthEntity, BasicAuthId> {

}

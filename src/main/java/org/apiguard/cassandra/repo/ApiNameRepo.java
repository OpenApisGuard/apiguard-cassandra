package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.ApiNameEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApiNameRepo extends CrudRepository<ApiNameEntity, String> {

}

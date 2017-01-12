package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.ApiEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApiRepo extends CrudRepository<ApiEntity, String> {
//
//	@Query("select * from api where name = ?0")
//	Iterable<ApiEntity> findByName(String name);

}

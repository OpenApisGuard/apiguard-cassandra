package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.ApiReqUriIndexEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApiReqUriIndexRepo extends CrudRepository<ApiReqUriIndexEntity, String> {

}

package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<ClientEntity, String> {

}

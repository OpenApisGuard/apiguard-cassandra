package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.LdapAuthEntity;
import org.apiguard.cassandra.entity.LdapAuthId;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LdapAuthRepo extends CrudRepository<LdapAuthEntity, LdapAuthId> {

    //TODO: replace me, ok for now
    @Query("select * from ldapAuth where requri = ?0 allow filtering")
    List<LdapAuthEntity> findByReqUri(String reqUri);
}

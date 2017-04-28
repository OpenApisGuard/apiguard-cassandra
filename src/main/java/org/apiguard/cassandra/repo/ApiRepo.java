package org.apiguard.cassandra.repo;

import org.apiguard.cassandra.entity.ApiEntity;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApiRepo extends CrudRepository<ApiEntity, String> {

    //    @Query("SELECT * FROM associations WHERE lucene = '{query : {type : \"match\",field : \"physicianid\",value :?0}}'")
    //
    //	@Query("select * from api where name = ?0")
    //	Iterable<ApiEntity> findByName(String name);


    @Query("select * from api where requri > ?0 ALLOW FILTERING")
    List<ApiEntity> findByReqUriRegex(String reqUri);
}

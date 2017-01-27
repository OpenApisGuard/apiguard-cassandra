package org.apiguard.cassandra.repo;

import java.io.Serializable;

import org.apiguard.cassandra.entity.AuthKeyEntity;
import org.apiguard.cassandra.repo.ApiAuthRepo.AuthId;
import org.springframework.data.repository.CrudRepository;

public interface ApiAuthRepo extends CrudRepository<AuthKeyEntity, AuthId> {
	
	public static class AuthId implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private String key;
		private String requestUri;
		
		public AuthId(String key, String requestUri) {
			this.key = key;
			this.requestUri = requestUri;
		}

		public String getKey() {
			return key;
		}

		public String getRequestUri() {
			return requestUri;
		}
	}

}

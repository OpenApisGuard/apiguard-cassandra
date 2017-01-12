package org.apiguard.test;

import java.util.Date;

import org.apiguard.cassandra.entity.ApiEntity;
import org.apiguard.cassandra.repo.ApiRepo;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;

public class Application {

	private static final String KEY_SPACE = "apiguard";

	public static void createKeySpace() {
		Cluster cluster = Cluster.builder().addContactPoint("localhost").withPort(9042)
				.withCredentials("cassandra", "cassandra").build();
		Session session = cluster.newSession();
		session.execute(String.format(
				"CREATE KEYSPACE IF NOT EXISTS %s WITH replication = {'class':'SimpleStrategy', 'replication_factor':3};",
				KEY_SPACE));
		session.close();
	}

	public static void main(String[] args) {
		Application.createKeySpace();

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("/config/SpringBeans/spring-data-cassandra-config.xml").getPath());

		ApiRepo apiRepo = context.getBean(ApiRepo.class);

		ApiEntity api1 = new ApiEntity(UUIDs.timeBased(), new Date(), "partner work schedule", "/partner/work/schedule",
				"http:lx40333:8080/partner/work/schedule");
		apiRepo.save(api1);

		ApiEntity res = apiRepo.findOne("/partner/work/schedule");
		if (res == null) {
			ApiEntity api2 = new ApiEntity(UUIDs.timeBased(), new Date(), "partner work schedule",
					"/partner/work/schedule", "http:lx40335:8080/partner/work/schedule");
			apiRepo.save(api2);
		}

		Iterable<ApiEntity> apiList = apiRepo.findAll();
		System.out.println("Api List : ");
		for (ApiEntity curApi : apiList) {
			System.out.println(curApi);
		}

		context.close();
	}
}

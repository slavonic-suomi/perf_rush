package pl.jbazil.javabase.classis.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class TestClassicOrmApplication {

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16.1-alpine3.18"));
	}

	public static void main(String[] args) {
		SpringApplication.from(ClassicOrmApplication::main).with(TestClassicOrmApplication.class).run(args);
	}

}

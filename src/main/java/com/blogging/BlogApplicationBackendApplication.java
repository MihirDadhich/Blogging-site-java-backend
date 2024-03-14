package com.blogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.blogging")
public class BlogApplicationBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplicationBackendApplication.class, args);
	}
}

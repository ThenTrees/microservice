package com.thentrees.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
* @author: Thentrees
* @since:
* @description:
* @update:
* */

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "Thentrees Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Then trees",
						email = "tutor@gmail.com",
						url = "https://github.com/ThenTrees"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/ThenTrees"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Thentrees Account microservice REST API Documentation",
				url = "https://github.com/ThenTrees"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}

package com.epicode.workSpaceReservationApplication.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.workSpaceReservationApplication.enums.UserRole;
import com.epicode.workSpaceReservationApplication.model.User;
import com.github.javafaker.Faker;

@Configuration
public class UserConfiguration {

	@Value("${admin.username}")
	private String username;
	@Value("${admin.name}")
	private String name;
	@Value("${admin.email}")
	private String email;
	@Value("${admin.password}")
	private String password;

	@Bean("UserAdminBean")
	@Scope("singleton")
	User userAdmin() {
		return new User(
				this.username, this.name, this.email,
				this.password, UserRole.ADMIN);
	}

	@Bean("UserNoParamsBean")
	@Scope("prototype")
	User userNoParams() {
		return new User();
	}

	@Bean("UserWithParamsBean")
	@Scope("prototype")
	User userWithParams(
			String username, String name, String email, String password) {
		return new User(username, name, email, password, UserRole.USER);
	}

	@Bean("UserFakeBean")
	@Scope("prototype")
	User userFake() {
		Faker faker = new Faker(new Locale("it", "it"));
		String name = faker.name().fullName();
		String username;
		try {
			username = name.split(" ")[0].toLowerCase();
		} catch (Exception e) {
			username = name.toLowerCase();
		}
		String email = String.format(
				"%s@%s", username, faker.internet().domainName().trim());
		String password = faker.internet().password();
		UserRole role = UserRole.USER;
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		return user;
	}

}
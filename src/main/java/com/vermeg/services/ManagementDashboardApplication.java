package com.vermeg.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vermeg.services.services.UserService;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = { "com.vermeg.services" })
public class ManagementDashboardApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ManagementDashboardApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {

//		User admin = new User();
//		admin.setUsername("admin");
//		admin.setName("admin");
//		admin.setPassword("admin");
//		admin.setEmail("admin@email.com");
//		admin.setRoles(new HashSet<Role>(Arrays.asList(Role.ROLE_ADMIN)));
//
//		userService.signup(admin);
	}

}

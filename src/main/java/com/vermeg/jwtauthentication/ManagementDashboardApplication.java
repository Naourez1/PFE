package com.vermeg.jwtauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.vermeg.jwtauthentication.model.User;
import com.vermeg.jwtauthentication.repository.UserRepository;
@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.example.demo", "controller", "service" })
@SpringBootApplication
public class ManagementDashboardApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ManagementDashboardApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		/*userRepository.save(new User("Naourez", "Naourezzz", "naourez65@gmail.com", "159951"));*/
		
	}
	
	
}



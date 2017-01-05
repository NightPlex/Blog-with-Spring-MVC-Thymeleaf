package com.webstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.webstore.models.User;
import com.webstore.services.UserRepository;


@SpringBootApplication
public class NightPlexProductionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NightPlexProductionsApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner studentDemo(UserRepository urepository) {
		return (args) -> {
				
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "karujusss", "USER");
			User user2 = new User("admin", "karujusss", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			

		};
	}
}

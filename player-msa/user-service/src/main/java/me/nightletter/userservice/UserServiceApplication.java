package me.nightletter.userservice;

import com.netflix.discovery.converters.Auto;
import jakarta.annotation.PostConstruct;
import me.nightletter.userservice.domain.User;
import me.nightletter.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void init() {
		userRepository.save( new User( "init1" ) );
		userRepository.save( new User( "init2" ) );
	}
}

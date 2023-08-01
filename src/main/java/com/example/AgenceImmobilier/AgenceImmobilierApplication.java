package com.example.AgenceImmobilier;

import com.example.AgenceImmobilier.models.user.ERole;
import com.example.AgenceImmobilier.models.user.Role;
import com.example.AgenceImmobilier.models.user.UserModel;
import com.example.AgenceImmobilier.repositories.RoleRepository;
import com.example.AgenceImmobilier.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AgenceImmobilierApplication {
	@Autowired
	PasswordEncoder encoder;
	public static void main(String[] args) {
		SpringApplication.run(AgenceImmobilierApplication.class, args);

	}
	@Bean
	CommandLineRunner run(RoleRepository roleRpository ,  UserRepository userRepository){
		return args -> {

			if (roleRpository.count()<1) {

				roleRpository.save(new Role( null,ERole.ROLE_ADMIN));
				roleRpository.save(new Role(null,ERole.ROLE_USER));
				roleRpository.save(new Role(null,ERole.ROLE_HOST));
			}
			if(!userRepository.existsByEmail("Admin")){
				UserModel user = new UserModel(
						"Admin",

						encoder.encode("password")
				);
				Role userRole = roleRpository.findRoleByName(ERole.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));

				user.getRoles().add(userRole);
				userRepository.save(user);
			}
		};
	}
}

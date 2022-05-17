package com.example.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.collection.domain.Collectible;
import com.example.collection.domain.CollectibleRepository;
import com.example.collection.domain.Category;
import com.example.collection.domain.CategoryRepository;
import com.example.collection.domain.User;
import com.example.collection.domain.UserRepository;



@SpringBootApplication
public class CollectionApplication {
	private static final Logger log = LoggerFactory.getLogger(CollectionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CollectionApplication.class, args);
	}
	@Bean
	public CommandLineRunner collectibleDemo(CollectibleRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("Add collectibles");
			Category category1 = new Category("Cards");
			crepository.save(category1);
			Category category2 = new Category("Old School");
			crepository.save(category2);
			Category category3 = new Category("Stamps");
			crepository.save(category3);
			
			repository.save(new Collectible(category1, "Korttikokoelma", "Tässä kokelmassa on arvokkaita kortteja", 15));
			
			// Create users: admin/admin user/user
			User user1 = new User("user@user.com", "user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin@admin.com", "admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all collectibles");
			for (Collectible collectible : repository.findAll()) {
				log.info(collectible.toString());
			}

		};
	}

}

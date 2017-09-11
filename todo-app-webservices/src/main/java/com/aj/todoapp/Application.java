package com.aj.todoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aj.todoapp.data.entity.NoteEntity;
import com.aj.todoapp.data.repository.NoteRepository;

@SpringBootApplication
// @EnableAutoConfiguration
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(NoteRepository repository) {
		return (args) -> {
			// save a couple of notes
			repository.save(new NoteEntity("Spring Boot", "Need to implement REST Services"));
			repository.save(new NoteEntity("Learn Maven", "Learn the concept of Dependency Mangement"));
			repository.save(new NoteEntity("ABC", "Bla Bla Bla.."));

			// fetch all notes
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (NoteEntity notes : repository.findAll()) {
				log.info(notes.toString());
			}
		};
	}
}

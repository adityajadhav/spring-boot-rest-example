package com.aj.todoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aj.todoapp.data.entity.NoteEntity;
import com.aj.todoapp.data.repository.NoteRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(NoteRepository repository) {
		return (args) -> {

			// save a couple of notes
			repository.save(new NoteEntity("Spring Boot", "Setup spring boot application"));
			repository.save(new NoteEntity("Maven Multi Module", "build a multi module maven project"));
			repository.save(new NoteEntity("Learn JPA", "Go though basic concepts of JPA"));

			// fetch all notes
			log.info("Notes found with findAll():");
			log.info("-------------------------------");
			for (NoteEntity notes : repository.findAll()) {
				log.info(notes.toString());
			}
		};
	}
}

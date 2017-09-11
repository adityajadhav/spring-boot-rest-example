package com.aj.todoapp.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aj.todoapp.data.entity.NoteEntity;
import com.aj.todoapp.data.repository.NoteRepository;

@RestController()
@RequestMapping(value = "/todo")
public class TodoController {

	@Autowired
	private NoteRepository repository;

	@GetMapping("/")
	public List<NoteEntity> home() {
		return (List<NoteEntity>) repository.findAll();
	}

}

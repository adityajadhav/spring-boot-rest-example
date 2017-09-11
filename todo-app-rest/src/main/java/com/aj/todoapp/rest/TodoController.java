package com.aj.todoapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aj.todoapp.data.entity.NoteEntity;
import com.aj.todoapp.services.NoteService;

@RestController()
@RequestMapping(value = "/todo")
public class TodoController extends AbstractRestHandler {

	@Autowired
	private NoteService noteService;

	@GetMapping
	public List<NoteEntity> list() {
		return noteService.list();
	}

	@GetMapping("/{noteId}")
	public NoteEntity get(@PathVariable String noteId) {
		return noteService.get(noteId);
	}

	@PostMapping
	public NoteEntity create(@RequestBody NoteEntity noteEntity) {
		return noteService.create(noteEntity);
	}

	@PutMapping("/{noteId}")
	public NoteEntity update(@PathVariable String noteId, @RequestBody NoteEntity noteEntity) {
		checkResourceFound(this.noteService.get(noteId));
		return noteService.update(noteEntity);
	}

	@DeleteMapping("/{noteId}")
	public void delete(@PathVariable String noteId) {
		noteService.delete(noteId);
	}

}

package com.aj.todoapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aj.todoapp.data.entity.NoteEntity;
import com.aj.todoapp.data.repository.NoteRepository;

@Service
public class NoteService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NoteRepository userRepository;

	public List<NoteEntity> list() {
		return (List<NoteEntity>) userRepository.findAll();
	}

	public NoteEntity get(String noteId) {
		return userRepository.findOne(noteId);
	}

	public NoteEntity create(NoteEntity noteEntity) {
		return userRepository.save(noteEntity);
	}

	public NoteEntity update(NoteEntity noteEntity) {
		return userRepository.save(noteEntity);
	}

	public void delete(String noteId) {
		userRepository.delete(noteId);
	}

}

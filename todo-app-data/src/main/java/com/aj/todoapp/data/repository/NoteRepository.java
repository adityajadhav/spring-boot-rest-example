package com.aj.todoapp.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.aj.todoapp.data.entity.NoteEntity;

public interface NoteRepository extends CrudRepository<NoteEntity, String> {

}

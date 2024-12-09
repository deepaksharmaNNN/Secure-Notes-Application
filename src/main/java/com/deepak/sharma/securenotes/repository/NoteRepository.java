package com.deepak.sharma.securenotes.repository;

import com.deepak.sharma.securenotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUsername(String username);
}

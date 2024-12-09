package com.deepak.sharma.securenotes.service.impl;

import com.deepak.sharma.securenotes.model.Note;
import com.deepak.sharma.securenotes.repository.NoteRepository;
import com.deepak.sharma.securenotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNoteForUser(String username, String noteContent) {
        Note note = new Note();
        note.setNoteContent(noteContent);
        note.setUsername(username);
        return noteRepository.save(note);
    }

    @Override
    public Note updateNoteForUser(String username, Long noteId, String noteContent) {
        return null;
    }

    @Override
    public void deleteNoteForUser(String username, Long noteId) {

    }

    @Override
    public List<Note> getNotesForUser(String username) {
        return List.of();
    }
}

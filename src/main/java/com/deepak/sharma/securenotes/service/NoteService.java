package com.deepak.sharma.securenotes.service;

import com.deepak.sharma.securenotes.model.Note;

import java.util.List;

public interface NoteService {
    Note createNoteForUser(String username, String noteContent);
    Note updateNoteForUser(String username, Long noteId, String noteContent);
    void deleteNoteForUser(String username, Long noteId);
    List<Note> getNotesForUser(String username);
}

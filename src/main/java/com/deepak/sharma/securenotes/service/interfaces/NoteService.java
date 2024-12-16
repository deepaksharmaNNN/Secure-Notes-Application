package com.deepak.sharma.securenotes.service.interfaces;

import com.deepak.sharma.securenotes.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    Note createNoteForUser(String username, String noteContent);
    Note updateNoteForUser(String username, Long noteId, String noteContent);
    void deleteNoteForUser(String username, Long noteId);
    List<Note> getNotesForUser(String username);
}

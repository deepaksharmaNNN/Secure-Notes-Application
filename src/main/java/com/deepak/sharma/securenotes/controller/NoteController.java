package com.deepak.sharma.securenotes.controller;

import com.deepak.sharma.securenotes.service.interfaces.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public void createNote(@RequestBody String content, @AuthenticationPrincipal String username) {
        noteService.createNoteForUser(username, content);
    }
}

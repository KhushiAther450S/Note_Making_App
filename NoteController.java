package com.javaguides.springboot.note;

import com.javaguides.springboot.entity.NoteTable;
import com.javaguides.springboot.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/api/notes")
    public String createNote(@RequestBody NoteTable note)
    {

//        return noteService.savetoDb(note);
        return "Hii Post Request";

    }
}

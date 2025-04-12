package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class MyController {
    @Autowired
    private NotesService service;

    @PostMapping("/add")
    public Note addNote(@RequestBody Note note) {
        service.addNote(note);
        return note;
    }

    @GetMapping("/get/{username}")
    public List<Note> getNotes(@PathVariable String username){
        return service.getNotes(username);
    }

    @DeleteMapping("/delete")
    public String deleteNotes(){
        service.deleteAllNotes();
        return "All notes deleted.";
    }

    @PostMapping("/create-user")
    public String createUser(@RequestBody User user){
        service.createUser(user);
        return "User created successfully.";
    }
}

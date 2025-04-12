package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepo;

    @Autowired
    private UserRepository userRepo;

    public void addNote(Note note){
        notesRepo.save(note);
    }

    public List<Note> getNotes(String username){
        return notesRepo.findByUsername(username);
    }

    public void createUser(User user){
        userRepo.save(user);
    }

    public void deleteAllNotes(){
        notesRepo.deleteAll();
    }
}

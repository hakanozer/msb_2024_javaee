package com.works.restapi.controllers;

import com.works.restapi.models.Note;
import com.works.restapi.services.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class NoteRestController {

    @GetMapping("/noteList")
    public List<Note> noteList() {
        NoteService noteService = new NoteService();
        return noteService.allNote();
    }

    //@PostMapping("/noteAdd")
    /*
    public void noteAdd(@RequestParam String title ) {
        System.out.println(title);
    }

    @PostMapping("/noteAdd/{title}")
    public void noteAdd(@PathVariable String title ) {
        System.out.println(title);
    }
    */

    @PostMapping("/noteAdd")
    public Note noteAdd( @RequestBody Note note ) {
        Random random = new Random();
        int id = random.nextInt(0, 100);
        note.setNid(id);
        return note;
    }

}

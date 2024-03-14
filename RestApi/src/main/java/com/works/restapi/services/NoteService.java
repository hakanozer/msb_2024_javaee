package com.works.restapi.services;

import com.works.restapi.models.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteService {

    public List<Note> allNote() {
        List<Note> ls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Note note = new Note();
            note.setNid(i);
            note.setTitle("Title:"+i);
            note.setDetail("Detail:"+i);
            ls.add(note);
        }
        return ls;
    }


}

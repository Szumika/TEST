package com.example.start.model;


import com.example.start.repositories.ActorsNameOnly;
import lombok.Value;

import java.util.Set;

@Value
//@Getter
public class FilmProjection {
    String title, description;
    Set<ActorsNameOnly> actors;
    String languageName;

//    public FilmProjection(String title, String description, List<ActorsNameOnly> actors) {
//        this.title = title;
//        this.description = description;
//        this.actors = actors;
//    }
}

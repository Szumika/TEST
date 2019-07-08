package com.example.start.repositories;

import java.util.List;

public interface FilmAllById {
    String getTitle();
    String getDescription();
    List<ActorsNameOnly> getActors();
    List<CategoryNameOnly> getFilmCategory();
    LanguageNameOnly getLanguage();
}

package com.example.start.DTO;


import com.example.start.model.Film;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@ToString
@Getter
@Setter
public class FilmDTO {
    public Long filmId;
    public String filmname;
    public String desc;
    public List<ActorDTO> actors;
    public List<CategoryDTO> caregory;
//    public List<LanguageDTO> lan;
    public String language;



    public FilmDTO(Film film) {
        this.actors = film.getActors().stream()
                .map(ActorDTO::new)
                .collect(Collectors.toList());
        this.caregory = film.getFilmCategory().stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
        this.filmname = film.getTitle();
        this.desc = film.getDescription();
        this.language = film.getLanguage().getName();

    }


}

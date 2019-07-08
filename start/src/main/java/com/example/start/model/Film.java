package com.example.start.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Film {
    @Id
    @GeneratedValue
    public Long filmId;
    public String title;
    public String description;
    @ManyToMany
            @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "filmId"),
            inverseJoinColumns = @JoinColumn(name = "actorId"))
    @JsonManagedReference //bez klasy DTO json po pierwszym aktorze sie zapętlał dzięki tym adnotacją wyświetlał wszystkich aktorów tylko raz
    public Set<Actor> actors;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "filmId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    @JsonManagedReference
    public Set<Category> filmCategory;
    @ManyToOne
    @JoinColumn(name="language_id")
    private Language language;
    private int rentalDuration;
    private double rentalRate;

    public Film(Optional<Film> film) {
        this.filmId = film.get().filmId;
        this.title = film.get().getTitle();
        this.description = film.get().getDescription();
        this.actors = film.get().getActors();
        this.filmCategory = film.get().getFilmCategory();
        this.language = film.get().getLanguage();
    }


    public void AddActor(Actor actor) {
        this.actors.add(actor);
    }
}

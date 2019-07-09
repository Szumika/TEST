package com.example.start.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "actor_actor_id_seq")
//    @SequenceGenerator(name="actor_actor_id_seq", sequenceName="actor_actor_id_seq")
    public Long actorId;
    public String firstName;
    public String lastName;
    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    private Set<Film> films = new HashSet<>();

    public Actor(String firstName, String lastName, Film films) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.films.add(films);
    }


    public void addFilm(Film film) {
        this.films.add(film);
    }
}

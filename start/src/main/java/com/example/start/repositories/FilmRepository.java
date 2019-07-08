package com.example.start.repositories;

import com.example.start.model.Actor;
import com.example.start.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    <T> Collection<T> findAllProjectedBy(Class<T> type);
//   Collection<FilmAllById> findByFilmId(Long id);
    Collection<FilmAllById> findByFilmId(Long id);
    Collection<ActorsOnly> findActorByfilmId(Long id);

    @Query(value = "SELECT title from film where title LIKE %:title%", nativeQuery = true)
    Collection<FilmTitle> findAllTitleLike(@Param("title") String like);
    Collection<FilmTitle> findByTitleLike(String str);
    Set<Actor> findAllActorsByFilmId(Long id);

//    @Query(value = "Select title from film where film.actor")
    Collection<FilmTitle> findAllTitleByActors_lastName(String lastname);
    Collection<FilmTitle> findAllTitleByActors_actorId(Long id);

        @Query(value = "SELECT title, description, first_name as firstName, last_name as lastName " +
                "FROM film_actor " +
                "INNER JOIN actor ON actor.actor_id = film_actor.actor_id " +
                "INNER JOIN film ON film.film_id = film_actor.film_id " +
                "WHERE title LIKE :title% AND last_name like :name%"
            , nativeQuery = true)
    Collection<FilmAndActor> findByActors_lastName(@Param("name")String name, @Param("title") String title);
}

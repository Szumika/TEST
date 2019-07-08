package com.example.start.repositories;

import com.example.start.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    <T>Collection<T> findByLastName(Class<T> type,String lastname);
    Optional<ActorsNameOnly> findByActorId(Long id);

    @Query(value = "SELECT last_name as lastName, first_name as firstName FROM actor  where last_name LIKE :name%", nativeQuery = true)
    Collection<ActorsNameOnly> findAllActorLike(@Param("name") String like);
    //    ActorsNamesOnly findByLastName(String lastName);
}

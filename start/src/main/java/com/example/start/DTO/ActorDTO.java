package com.example.start.DTO;

import com.example.start.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class ActorDTO {

    public Long actorId;
    public String firstName;
    public String lastName;


    public ActorDTO(Actor actor) {
        this.firstName = actor.firstName;
        this.lastName = actor.lastName;
        this.actorId = actor.actorId;
    }

}

package com.example.start.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Category {
    @Id
    public Long categoryId;
    public String name;
    @ManyToMany(mappedBy = "filmCategory")
    @JsonBackReference
    private List<Film> film;

}

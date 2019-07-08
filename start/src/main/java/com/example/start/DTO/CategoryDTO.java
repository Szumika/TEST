package com.example.start.DTO;

import com.example.start.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    public String name;


    public CategoryDTO(Category cat) {
        this.name = cat.name;
    }

    public CategoryDTO() {
    }

}

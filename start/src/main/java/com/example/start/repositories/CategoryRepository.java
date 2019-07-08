package com.example.start.repositories;

import com.example.start.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
Collection<CategoryNameOnly> findByCategoryId(Long id);
}

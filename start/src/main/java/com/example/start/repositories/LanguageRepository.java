package com.example.start.repositories;

import com.example.start.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
Collection<LanguageNameOnly> findByLanguageId(Long id);
}

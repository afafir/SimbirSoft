package ru.javalab.simbirsofttask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javalab.simbirsofttask.model.WordCount;
@Repository
public interface WordCountRepositoryJpa extends JpaRepository<WordCount, Long> {
}

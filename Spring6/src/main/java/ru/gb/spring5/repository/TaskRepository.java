package ru.gb.spring5.repository;


import org.springframework.data.repository.CrudRepository;
import ru.gb.spring5.model.Task;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Optional<Task> findById(Long id);
}

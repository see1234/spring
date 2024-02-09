package ru.gb.spring5.repository;


import org.springframework.data.repository.CrudRepository;
import ru.gb.spring5.model.Task;
import ru.gb.spring5.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus taskStatus);
}

package ru.gb.spring5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring5.model.Task;
import ru.gb.spring5.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskServices {

    @Autowired
    TaskRepository taskRep;

    public List<Task> getAllTask() {
        return StreamSupport.stream(taskRep.findAll().spliterator(), false).collect(Collectors.toList());
    }



    public void saveTask(Task task) {
        taskRep.save(task);
    }

    public void deleteTask(Long id) {
        if (taskRep.existsById(id))
            taskRep.deleteById(id);
    }

    public Optional<Task> findTaskById(Long id) {
        return taskRep.findById(id);
    }

    public Task addTask(String name, String description) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);

        task.setCreatedDate(LocalDateTime.now());
        return task;
    }


}
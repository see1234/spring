package ru.gb.spring5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring5.model.Task;
import ru.gb.spring5.model.TaskStatus;
import ru.gb.spring5.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static ru.gb.spring5.model.TaskStatus.*;

@Service
public class TaskServices {

    @Autowired
    TaskRepository taskRep;

    public List<Task> getAllTask() {
        return StreamSupport.stream(taskRep.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public List<Task> getTaskByStatus(TaskStatus taskStatus) {
        return taskRep.findByStatus(taskStatus);
    }

    public void saveTask(Task task) {
        taskRep.save(task);
    }

    public void deleteTask(Long id) {
        if (taskRep.existsById(id))
            taskRep.deleteById(id);
    }

    public Task addTask(String name, String description) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setStatus(NOT_STARTED);
        task.setCreatedDate(LocalDateTime.now());
        return task;
    }

    public void updateStatus(Long id) {
        if (taskRep.existsById(id)) {
            Task task = taskRep.findById(id).orElse(null);
            if (task != null) {
                switch (task.getStatus()) {
                    case NOT_STARTED -> {
                        task.setStatus(IN_PROGRESS);
                    }
                    case IN_PROGRESS -> {
                        task.setStatus(COMPLETED);
                    }
                    default -> {
                        return;
                    }
                }
            }
            taskRep.save(task);
        }
    }
}
package ru.gb.spring5.methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.spring5.model.Task;
import ru.gb.spring5.model.TaskStatus;
import ru.gb.spring5.services.TaskServices;

import java.util.List;

@Controller
public class ViewTask {
    @Autowired
    TaskServices ts;

    @GetMapping("/")
    public String checker(@RequestParam(value = "filter", required = false) String filter, Model model) {
        if (filter == null) {
            filter = "all";
        }
        filter = filter.toLowerCase();
        List<Task> tasks;
        if (filter.equals("not_started")) {
            tasks = ts.getTaskByStatus(TaskStatus.NOT_STARTED);
        } else if (filter.equals("in_progress")) {
            tasks = ts.getTaskByStatus(TaskStatus.IN_PROGRESS);
        } else if (filter.equals("completed")) {
            tasks = ts.getTaskByStatus(TaskStatus.COMPLETED);
        } else {
            tasks = ts.getAllTask();
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("filter", filter);
        return "index";
    }
}
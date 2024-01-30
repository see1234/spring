package ru.gb.spring5.methods;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.spring5.services.TaskServices;

@Controller
@Log
public class AddTask {
    @Autowired
    TaskServices ts;

    @GetMapping("/addtask")
    public String addTaskForm() {
        return "addtask";
    }

    @PostMapping("/addtask")
    public String addTaskAction(
            @RequestParam String name,
            @RequestParam String description,
            Model model) {
        ts.saveTask(ts.addTask(name, description));
        model.addAttribute("tasks", ts.getAllTask());
        return "index";
    }
}
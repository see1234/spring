package ru.gb.spring5.methods;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.spring5.model.Task;
import ru.gb.spring5.services.TaskServices;

import java.time.LocalDateTime;
import java.util.Optional;


@Controller
@Log
public class EditTask {
    @Autowired
    TaskServices ts;

    @GetMapping("/edittask/{id}")
    public String addTaskForm(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "edittask";
    }

    @PostMapping("/edittask/{id}")
    public ModelAndView addTaskAction(@PathVariable Long id,
                                      @RequestParam String name,
                                      @RequestParam String description) {

        Optional<Task> optionalTask = ts.findTaskById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setName(name);
            task.setDescription(description);
            ts.saveTask(task);
        }

        return new ModelAndView("redirect:/");
    }
}
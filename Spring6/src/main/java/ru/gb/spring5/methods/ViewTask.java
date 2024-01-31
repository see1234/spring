package ru.gb.spring5.methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.spring5.model.Task;
import ru.gb.spring5.services.TaskServices;

import java.util.List;

@Controller
public class ViewTask {
    @Autowired
    TaskServices ts;

    @GetMapping("/")
    public String checker(@RequestParam(value = "filter", required = false) String filter, Model model) {

        List<Task> tasks;

            tasks = ts.getAllTask();

        model.addAttribute("tasks", tasks);
        model.addAttribute("filter", filter);
        return "index";
    }
}
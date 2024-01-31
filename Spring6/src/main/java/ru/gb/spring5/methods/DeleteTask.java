package ru.gb.spring5.methods;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.spring5.services.TaskServices;

@Controller
@Log
public class DeleteTask {
    @Autowired
    TaskServices ts;

    @GetMapping("/deltask/{id}")
    public ModelAndView deleteTask(@PathVariable Long id) {
        ts.deleteTask(id);
        return new ModelAndView("redirect:/");
    }
}
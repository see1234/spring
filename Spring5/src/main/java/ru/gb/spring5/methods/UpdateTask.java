package ru.gb.spring5.methods;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.spring5.services.TaskServices;

/**
 * Обработчик изменения статуса задачи
 */
@Controller
@Log
public class UpdateTask {

    @Autowired
    TaskServices ts;
    @GetMapping("/upd/{id}")
    public String updateTaskStatus(@PathVariable Long id) {
        ts.updateStatus(id);
        return "redirect:/";
    }
}

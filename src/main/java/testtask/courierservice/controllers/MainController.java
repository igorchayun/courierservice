package testtask.courierservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import testtask.courierservice.domain.Task;
import testtask.courierservice.mapper.TaskMapper;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class MainController {

    private TaskMapper taskMapper;

    public MainController(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @GetMapping("/")
    public String index(Task task, Model model) {
        model.addAttribute( "task", task);
        return "index";
    }

    @PostMapping("/")
    public String addTask(@Valid Task task, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        if (!taskMapper.findByOrderNumber(task.getOrderNumber()).isEmpty()) {
            model.addAttribute(
                    "orderNumberError",
                    "Order with number '" + task.getOrderNumber() + "' has already been added to tasks"
            );
            return "index";
        }
        task.setCreationDate(LocalDateTime.now());
        taskMapper.createTask(task);
        return "redirect:/";
    }
}

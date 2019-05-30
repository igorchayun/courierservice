package testtask.courierservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import testtask.courierservice.mapper.TaskMapper;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskMapper taskMapper;

    public TaskController(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public String viewTasks(@RequestParam(required=false, defaultValue="") String filter, Model model) {
        if (!StringUtils.isEmpty(filter)) {
            model.addAttribute("tasks", taskMapper.findByFilter(filter));
        } else {
            model.addAttribute("tasks", taskMapper.findAll());
        }
        model.addAttribute("filter", filter);
        return "tasks";
    }
}

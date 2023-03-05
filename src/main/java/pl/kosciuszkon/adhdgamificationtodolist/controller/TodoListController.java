package pl.kosciuszkon.adhdgamificationtodolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kosciuszkon.adhdgamificationtodolist.model.ApplicationUser;
import pl.kosciuszkon.adhdgamificationtodolist.model.TodoTask;
import pl.kosciuszkon.adhdgamificationtodolist.service.TodoService;

import java.util.List;

@Controller
public class TodoListController {

    private TodoService todoService;

    @Autowired
    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/mainpage")
    public String returnMainPage(Model model, @AuthenticationPrincipal ApplicationUser applicationUser) {
        List<TodoTask> allTodoTask = todoService.listAllTodo();
        model.addAttribute("allTodoTask", allTodoTask);
        return "main_page";
    }

    @PostMapping("createtodotask")
    public String createTodoTask(@ModelAttribute TodoTask todoTask) {
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteTodoTask(@RequestParam Long id) {
        todoService.deleteTodo(id);
        return "redirect:/";
    }

    @PutMapping("/update")
    public String updateTodoTask(@RequestParam Long id) {
        todoService.updateTodoStatus(id);
        return "redirect:/";
    }
}

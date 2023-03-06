package pl.kosciuszkon.adhdgamificationtodolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kosciuszkon.adhdgamificationtodolist.model.ApplicationUser;
import pl.kosciuszkon.adhdgamificationtodolist.model.TodoTask;
import pl.kosciuszkon.adhdgamificationtodolist.service.ApplicationUserService;
import pl.kosciuszkon.adhdgamificationtodolist.service.TodoService;

import java.util.List;

@Controller
public class TodoListController {

    private TodoService todoService;

    private ApplicationUserService applicationUserService;

    @Autowired
    public TodoListController(TodoService todoService, ApplicationUserService applicationUserService) {
        this.todoService = todoService;
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("/mainpage")
    public String returnMainPage(Model model, @AuthenticationPrincipal ApplicationUser applicationUser) {
        System.out.println(applicationUser.getUsername());
        List<TodoTask> allTodoTask = todoService.listAllTodoForSpecificUser(applicationUser.getUsername());
        model.addAttribute("allTodoTask", allTodoTask);
        model.addAttribute("name", applicationUser.getName());
        model.addAttribute("level", applicationUser.getLevel());
        return "main_page";
    }

    @PostMapping("createtodotask")
    public String createTodoTask(@ModelAttribute TodoTask todoTask) {
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteTodoTask(@RequestParam Long id) {
        todoService.deleteTodo(id);
        return "redirect:/mainpage";
    }

    @GetMapping("/update")
    public String updateTodoTask(@RequestParam Long id, @AuthenticationPrincipal ApplicationUser applicationUser) {
        todoService.updateTodoStatus(id);
        applicationUserService.increaseLevel(applicationUser);
        return "redirect:/mainpage";
    }
}

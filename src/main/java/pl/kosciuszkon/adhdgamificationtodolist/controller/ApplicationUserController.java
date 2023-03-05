package pl.kosciuszkon.adhdgamificationtodolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kosciuszkon.adhdgamificationtodolist.model.ApplicationUser;
import pl.kosciuszkon.adhdgamificationtodolist.service.ApplicationUserService;

@Controller
public class ApplicationUserController {

    private ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping({"", "/login"})
    public String loginPage() {
        return "login_page";
    }

    @PostMapping("/register")
    public String register(ApplicationUser applicationUser) {
        applicationUserService.addUser(applicationUser);
        return "redirect:/";
    }

    /*
    @GetMapping("/character")
    public String characterSelection(@RequestParam String email) {
        applicationUserService.characterSelection(email);
        return "character_selection";
    }
     */
}

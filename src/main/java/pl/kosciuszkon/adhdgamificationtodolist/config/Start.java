package pl.kosciuszkon.adhdgamificationtodolist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.kosciuszkon.adhdgamificationtodolist.model.ApplicationUser;
import pl.kosciuszkon.adhdgamificationtodolist.model.TodoTask;
import pl.kosciuszkon.adhdgamificationtodolist.repository.ApplicationUserRepository;
import pl.kosciuszkon.adhdgamificationtodolist.repository.TodoRepository;

import java.util.List;

@Configuration
public class Start {

    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    public Start(ApplicationUserRepository applicationUserRepository, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;

        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername("test@test.com");
        applicationUser.setPassword(passwordEncoder.encode("test"));
        applicationUser.setName("Kacper");
        applicationUser.setLevel(1);
        applicationUserRepository.save(applicationUser);
    }

    @Bean
    CommandLineRunner commandLineRunner(TodoRepository todoRepository) {
        return args -> {
            TodoTask homework = new TodoTask("Homework");
            TodoTask rubbish = new TodoTask("Rubbish");
            TodoTask dinner = new TodoTask("Cook dinner");
            homework.setUsernameOwner("test@test.com");
            rubbish.setUsernameOwner("test@test.com");
            dinner.setUsernameOwner("test2@test.com");
            todoRepository.saveAll(List.of(homework, rubbish, dinner));
        };
    }

}

package pl.kosciuszkon.adhdgamificationtodolist.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kosciuszkon.adhdgamificationtodolist.model.TodoTask;
import pl.kosciuszkon.adhdgamificationtodolist.repository.TodoRepository;

import java.util.List;

@Configuration
public class Start {

    @Bean
    CommandLineRunner commandLineRunner(TodoRepository todoRepository) {
        return args -> {
            TodoTask homework = new TodoTask("Homework");
            TodoTask rubbish = new TodoTask("Rubbish");
            todoRepository.saveAll(List.of(homework, rubbish));
        };
    }

}

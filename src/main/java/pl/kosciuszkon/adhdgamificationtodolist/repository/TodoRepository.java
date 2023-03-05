package pl.kosciuszkon.adhdgamificationtodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosciuszkon.adhdgamificationtodolist.model.TodoTask;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoTask, Long> {

    Optional<TodoTask> findByDescription(String description);

}

package pl.kosciuszkon.adhdgamificationtodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kosciuszkon.adhdgamificationtodolist.model.TodoTask;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoTask, Long> {

    Optional<TodoTask> findByDescription(String description);

    @Query("FROM TodoTask WHERE USERNAME_OWNER = :searchValue AND STATUS = FALSE")
    List<TodoTask> getTodoTasksByUsernameOwner(String searchValue);

}

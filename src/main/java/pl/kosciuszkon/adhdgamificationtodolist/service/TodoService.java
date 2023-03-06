package pl.kosciuszkon.adhdgamificationtodolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosciuszkon.adhdgamificationtodolist.model.ApplicationUser;
import pl.kosciuszkon.adhdgamificationtodolist.model.TodoTask;
import pl.kosciuszkon.adhdgamificationtodolist.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoTask> listAllTodo() {
        return todoRepository.findAll();
    }

    public List<TodoTask> listAllTodoForSpecificUser(String username) {
        return todoRepository.getTodoTasksByUsernameOwner(username);
    }

    public void deleteTodo(Long id) {
        if (todoRepository.findById(id).isPresent()) todoRepository.deleteById(id);
        else throw new RuntimeException(); // TODO
    }

    public void createTodoTask(TodoTask todoTask) {
        if (todoRepository.findByDescription(todoTask.getDescription()).isPresent()) throw new RuntimeException();
        else todoRepository.save(todoTask);
    }

    public void updateTodoStatus(Long id) {
        Optional<TodoTask> todoTaskOptional = todoRepository.findById(id);
        if (todoTaskOptional.isPresent()) {
            todoTaskOptional.get().setStatus(true);
            todoRepository.save(todoTaskOptional.get());
        }
        else throw new RuntimeException();
    }
}

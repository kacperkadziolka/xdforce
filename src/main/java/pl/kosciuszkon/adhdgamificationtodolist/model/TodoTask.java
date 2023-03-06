package pl.kosciuszkon.adhdgamificationtodolist.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "todotask")
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private boolean status;

    private String usernameOwner;

    public TodoTask(String description) {
        this.description = description;
    }
}

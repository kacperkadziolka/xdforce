package pl.kosciuszkon.adhdgamificationtodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosciuszkon.adhdgamificationtodolist.model.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    Optional<ApplicationUser> findByUsername(String username);
}

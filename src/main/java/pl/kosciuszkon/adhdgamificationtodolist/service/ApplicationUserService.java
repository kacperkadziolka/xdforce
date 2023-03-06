package pl.kosciuszkon.adhdgamificationtodolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kosciuszkon.adhdgamificationtodolist.model.ApplicationUser;
import pl.kosciuszkon.adhdgamificationtodolist.repository.ApplicationUserRepository;

@Service
public class ApplicationUserService {

    private ApplicationUserRepository applicationUserRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(ApplicationUser applicationUser) {
        applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
        applicationUserRepository.save(applicationUser);
    }

    public void increaseLevel(ApplicationUser applicationUser) {
        applicationUser.setLevel(applicationUser.getLevel() + 1);
        applicationUserRepository.save(applicationUser);
    }
}

package se.iths.paveena.demospringsecurity.util;

import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.iths.paveena.demospringsecurity.model.AppUser;
import se.iths.paveena.demospringsecurity.repository.AppUserRepository;

@Component
public class DatabaseInit {
    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;

    public DatabaseInit(PasswordEncoder passWordEncoder, AppUserRepository appUserRepository) {
        this.passwordEncoder = passWordEncoder;
        this.appUserRepository = appUserRepository;
    }

    @PostConstruct
    public void createUser() {
        AppUser appUser = new AppUser();
        appUser.setUsername("paveena.naebsuwan@gmail.com");
        appUser.setRole("ADMIN");
        appUser.setPassword(passwordEncoder.encode("password"));
        appUserRepository.save(appUser);

        AppUser appUser2 = new AppUser();
        appUser2.setUsername("manager");
        appUser2.setRole("MANAGER");
        appUser2.setPassword(passwordEncoder.encode("manager"));
        appUserRepository.save(appUser2);

    }
}

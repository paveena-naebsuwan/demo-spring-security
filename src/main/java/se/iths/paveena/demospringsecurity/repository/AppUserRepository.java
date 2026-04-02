package se.iths.paveena.demospringsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.iths.paveena.demospringsecurity.model.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}

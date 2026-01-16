package arora.software.task_master_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import arora.software.task_master_backend.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
    
    // Check if user exists before registering
    Boolean existsByUsername(String username);
    
}
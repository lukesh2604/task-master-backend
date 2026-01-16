package arora.software.task_master_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import arora.software.task_master_backend.model.User;
import arora.software.task_master_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User register(User user){
        
        if(userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already present");
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        
        return userRepository.save(newUser);
    }
}

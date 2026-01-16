package arora.software.task_master_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import arora.software.task_master_backend.model.User;
import arora.software.task_master_backend.service.UserService;
import arora.software.task_master_backend.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import arora.software.task_master_backend.util.JwtUtil;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager; 

    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/register")
    public void register(@RequestBody User user) {

        this.userService.register(user);

    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody User loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), 
                loginRequest.getPassword()
            )
        );
        String token = jwtUtil.generateToken(loginRequest.getUsername());
        
        return Map.of("token", token);
    }
    
    

}

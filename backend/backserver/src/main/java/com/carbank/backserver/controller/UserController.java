package com.carbank.backserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carbank.backserver.model.User;
import com.carbank.backserver.repository.UserRepository;

@RestController
//Mapeia esta classe de controle para o caminho '/users'
@RequestMapping("/user")
public class UserController {

	// Injeção de dependência do repositório de carros
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User foundUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (foundUser != null)
        {
            return ResponseEntity.ok("Login successful");
        } else 
        {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}

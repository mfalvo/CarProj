package com.carbank.backserver.controller;

import java.util.Optional;

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

	@GetMapping("/byid/{id}")
	public User findByEmail(@PathVariable String id){
		User founded = userRepository.findById(id).orElse(null);
		 if (founded != null)
	        {
	            return founded;
	        } else 
	        {
	            return null;
	        }

		
	}
	
	
	@PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        User foundUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (foundUser != null)
        {
            return foundUser;
        } else 
        {
        	User emptyUser = new User();
            return emptyUser;
        }
    }
}

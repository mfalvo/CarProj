package com.carbank.backserver.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.carbank.backserver.model.User;


public interface UserRepository extends CrudRepository<User, String> {

  
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password") 
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);   
}
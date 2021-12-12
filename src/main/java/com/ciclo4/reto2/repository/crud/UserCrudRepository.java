/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto2.repository.crud;

import com.ciclo4.reto2.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gonza
 */
public interface UserCrudRepository extends MongoRepository<User, Integer>{
    
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email , String password); 
    
}

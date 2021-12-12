package com.ciclo4.reto2.web;

import com.ciclo4.reto2.model.User;
import com.ciclo4.reto2.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
    @Autowired 
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getUsuarios(){
        return userService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<User> getUsuario(@PathVariable("id") int id){ 
        return userService.getUsuario(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User usuario){
        return userService.create(usuario);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User usuario){
        return userService.update(usuario);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }
    
    @GetMapping("/emailexist/{email}")
    public boolean autenticarEmail(@PathVariable("email") String email){
        return userService.getByEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User autenticarEmailyPassword(@PathVariable("email") String email , @PathVariable("password") String password){
        return userService.getByEmailAndPassword(email, password);
    }
            
}


package com.ciclo4.reto2.service;

import com.ciclo4.reto2.model.User;
import com.ciclo4.reto2.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    
    public List<User> getAll(){
        return userRepository.getAll();
    }
    
    public Optional<User> getUsuario(int id){
        return userRepository.getUsuario(id);
    }
    
    public User create(User usuario){
        
        if(usuario.getId() == null){
            return usuario;
        }else{
            Optional<User> varTmp = userRepository.getUsuario(usuario.getId());
            
            if(varTmp.isPresent()){
                return usuario;
            }else{
                if(getByEmail(usuario.getEmail()) == false ){
                    return userRepository.create(usuario);
                }
                
                return usuario;
            }
        
        }
        
    }
    
    public User update(User usuario){
        if(usuario.getId() != null){
            Optional<User> usuarioDb = userRepository.getUsuario(usuario.getId());
            if(usuarioDb.isPresent()){
                if(usuario.getIdentification() != null){
                    usuarioDb.get().setIdentification(usuario.getIdentification());
                }
                if(usuario.getName() != null){
                    usuarioDb.get().setName(usuario.getName());
                }
                if(usuario.getAddress() != null){
                    usuarioDb.get().setAddress(usuario.getAddress());
                }
                if(usuario.getCellPhone() != null){
                    usuarioDb.get().setCellPhone(usuario.getCellPhone());
                }
                if(usuario.getEmail() != null){
                    usuarioDb.get().setEmail(usuario.getEmail());
                }
                if(usuario.getPassword() != null){
                    usuarioDb.get().setPassword(usuario.getPassword());
                }
                if(usuario.getZone() != null){
                    usuarioDb.get().setZone(usuario.getZone());
                }
                if(usuario.getType() != null){
                    usuarioDb.get().setType(usuario.getType());
                }
                
                userRepository.update(usuarioDb.get());
                return usuarioDb.get();
            }
            
            return usuario;
        
        }
        return usuario;
    }
    
    public boolean delete(int id){
        Boolean eliminar = getUsuario(id).map(usuario -> {
            userRepository.delete(usuario);
            return true;
        }).orElse(false);
        
        return eliminar;
    
    }
    
    public boolean getByEmail(String email){
        Optional<User> verificarEmail = userRepository.getByEmail(email);
        
        return verificarEmail.isPresent();
    }
    
    public User getByEmailAndPassword(String email, String password){
        Optional<User> autenticar = userRepository.getByEmalAndPassword(email, password);
        
        if(autenticar.isPresent()){
            return autenticar.get();
        }else{
            return new User();
        }
                
    }
}

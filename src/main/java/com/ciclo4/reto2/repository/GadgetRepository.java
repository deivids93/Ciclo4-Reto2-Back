
package com.ciclo4.reto2.repository;

import com.ciclo4.reto2.model.Gadget;
import com.ciclo4.reto2.repository.crud.GadgetCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GadgetRepository {
    
    @Autowired
    private GadgetCrudRepository gadgetCrudRepository;
    
    public List<Gadget> getAll(){
        return gadgetCrudRepository.findAll();
    }
    
    public Optional<Gadget> getGadget(int id){
        return gadgetCrudRepository.findById(id);
    }
    
    public Gadget create(Gadget producto){
        return gadgetCrudRepository.save(producto);
    }
    
    public Gadget update(Gadget producto){
        return gadgetCrudRepository.save(producto);
    }
    
    public void delete (Gadget producto){
        gadgetCrudRepository.delete(producto);
    }
}

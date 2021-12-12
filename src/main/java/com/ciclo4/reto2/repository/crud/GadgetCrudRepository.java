package com.ciclo4.reto2.repository.crud;

import com.ciclo4.reto2.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer>{
    
}

package com.ciclo4.reto2.web;

import com.ciclo4.reto2.model.Gadget;
import com.ciclo4.reto2.service.GadgetService;
import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
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
@RequestMapping("/api/gadget")
@CrossOrigin("*")
public class GadgetController {
    
    @Autowired
    private GadgetService gadgetService;
    
    @GetMapping("/all")
    public List<Gadget> getGadgets(){
        return gadgetService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Gadget> getGadget(@PathVariable("id") int id){
        return gadgetService.getGadget(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget create(@RequestBody Gadget producto){
        return gadgetService.create(producto);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget producto){
        return gadgetService.update(producto);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return gadgetService.delete(id);
    }
}

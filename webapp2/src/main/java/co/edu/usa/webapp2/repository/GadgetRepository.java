/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.repository;

import co.edu.usa.webapp2.crud.InterfaceGadget;
import co.edu.usa.webapp2.model.Gadget;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CARLOS ANDRES
 */
@Repository
public class GadgetRepository {
    
    @Autowired
    private InterfaceGadget repo;
    
    public void save(Gadget gadget){
        repo.insert(gadget);
    }
    
    public void update(Gadget gadget){
        repo.save(gadget);
    }
    
    public List<Gadget> getAll(){
    return repo.findAll();
    }
    
     public Optional<Gadget> getById(Integer id){
        return repo.getById(id);
    }
    
    
    public void delete(Gadget gadget){
        repo.delete(gadget);
    }
}

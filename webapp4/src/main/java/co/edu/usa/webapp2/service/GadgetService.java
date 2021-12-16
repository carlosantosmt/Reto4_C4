/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.service;

import co.edu.usa.webapp2.model.Gadget;
import co.edu.usa.webapp2.repository.GadgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS ANDRES
 */
@Service
public class GadgetService {
    
    @Autowired
    private GadgetRepository repo;
    
    public List<Gadget> getAll(){
        return repo.getAll();
    }
    
    public void save(Gadget gadget){
        if(gadget.getId()!=null){
            repo.save(gadget);
        }else{
            Optional<Gadget> gadgetOpt = repo.getById(gadget.getId());
            if(!gadgetOpt.isPresent()){
                repo.save(gadget);
            }
        }
    }
    
    public void delete(Integer id){
        Optional<Gadget> gadgetOpt = repo.getById(id);
        if (gadgetOpt.isPresent()){
            repo.delete(gadgetOpt.get());
        }
    }
    
    public Gadget update(Gadget gadget){
        Optional<Gadget> gadgetOpt = repo.getById(gadget.getId());
        if(gadgetOpt.isPresent()){
            if (gadget.getBrand() != null) {
                    gadgetOpt.get().setBrand(gadget.getBrand());
                }
                if (gadget.getCategory() != null) {
                    gadgetOpt.get().setCategory(gadget.getCategory());
                }
                if (gadget.getName() != null) {
                    gadgetOpt.get().setName(gadget.getName());
                }
                if (gadget.getDescription() != null) {
                    gadgetOpt.get().setDescription(gadget.getDescription());
                }
                if (gadget.getPrice()!= null && gadget.getPrice() > 0) {
                    gadgetOpt.get().setPrice(gadget.getPrice());
                }
                if (gadget.getAvailability() != null) {
                    gadgetOpt.get().setAvailability(gadget.getAvailability());
                }
                if (gadget.getQuantity() != null && gadget.getQuantity() > 0) {
                    gadgetOpt.get().setQuantity(gadget.getQuantity());
                }
                if (gadget.getPhotography() != null) {
                    gadgetOpt.get().setPhotography(gadget.getPhotography());
                }
            repo.update(gadgetOpt.get());
        }
        return gadget;
    }
    
     public Gadget getGadget(Integer id){
        Optional<Gadget> gadgetOpt = repo.getById(id);
        if(gadgetOpt.isPresent()){
            return gadgetOpt.get();
        }
        return null;
    }
     
    public List<Gadget> getGagdgetByPrice(Double price){
        return repo.getGadgetByPrice(price);
    }
    
    public List<Gadget> getGadetByDescription(String text){
        return repo.getGadgetByDescription(text);
    }
}

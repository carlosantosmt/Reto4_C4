/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.crud;

import co.edu.usa.webapp2.model.Gadget;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author CARLOS ANDRES
 */
public interface InterfaceGadget extends MongoRepository<Gadget, Integer> {
    
    @Query("{id: ?0}")
    public Optional<Gadget> getById(Integer id);
    
    @Query("{price: {$lte:?0}}")
    public List<Gadget> findGadgetByPrice(Double price);
    
    @Query("{description: {$regex: /?0/}}")
    public List<Gadget> findGadgetByDescription(String text);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.crud;

import co.edu.usa.webapp2.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author CARLOS ANDRES
 */

public interface InterfaceOrder extends MongoRepository<Order, Integer>{
    
    @Query("{id:?0}")
    public Optional<Order> getdById(Integer id);
    
    //public Optional<Order> findByDate(Date date);
    
    @Query("{'salesMan.zone':?0}")
    public List<Order> findByZone(String zone);
    
    
    
}

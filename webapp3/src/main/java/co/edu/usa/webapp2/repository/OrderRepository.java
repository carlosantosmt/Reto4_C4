/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.repository;

import co.edu.usa.webapp2.crud.InterfaceOrder;
import co.edu.usa.webapp2.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CARLOS ANDRES
 */

@Repository
public class OrderRepository {
    
    @Autowired
    private InterfaceOrder repo;
    
     public void save(Order order){
        repo.insert(order);
    }
    
    public void update(Order order){
        repo.save(order);
    }
    
    public List<Order> getAll(){
    return repo.findAll();
    }
    
    public Optional<Order> getById(Integer id){
        return repo.getdById(id);
    }
    
    public List<Order> getBySalesman(String zone){
        return repo.findByZone(zone);
    }
     
    public void delete(Order order){
        repo.delete(order);
    }
}

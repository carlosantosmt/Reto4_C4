/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.controller;

import co.edu.usa.webapp2.model.Order;
import co.edu.usa.webapp2.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CARLOS ANDRES
 */

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/all")
    public List<Order> getOrders(){
    return orderService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void newOrder(@RequestBody Order newOrder){
        orderService.save(newOrder);
    }
    
    @PutMapping("/update")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity update(@RequestBody Order order){
        orderService.update(order);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @GetMapping("/zona/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return orderService.getByZone(zone);
    }
    
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") Integer id ){
        return orderService.getOrder(id);
    }
    
    @GetMapping("salesman/{id}")
    public List<Order> getOrderBySalesman(@PathVariable("id") Integer id){
        return orderService.getBySalesman(id);
    }
    
    @GetMapping("/date/{date}/{id}")
    public List<Order> getOrdersByDate(@PathVariable("id") Integer id, @PathVariable("date") String date){
        return orderService.getByDate(id, date);
    }
    
    @GetMapping("/state/{status}/{id}")
    public List<Order> getOrdersByStatus(@PathVariable("id") Integer id, @PathVariable("status") String status){
        return orderService.getByStatus(id, status);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer idOrder){
        orderService.delete(idOrder);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

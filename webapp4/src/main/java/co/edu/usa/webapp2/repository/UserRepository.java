/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.repository;

import co.edu.usa.webapp2.crud.InterfaceUser;
import co.edu.usa.webapp2.model.User;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CARLOS ANDRES
 */
@Repository
public class UserRepository {
    
    @Autowired
    private InterfaceUser repo;
    
    public void save(User user){
        repo.insert(user);
    }
    
    public void update(User user){
        repo.save(user);
    }
    
    public List<User> getAll(){
    return repo.findAll();
    }
    
     public Optional<User> getById(Integer id){
        return repo.getById(id);
    }
   
    public boolean exist(String email){
    return repo.existsByEmail(email);
    }
    
    public User validateUser(String email, String pass){
        return repo.findByEmailAndPassword(email, pass);
    }
    
    public void delete(User user){
        repo.delete(user);
    }
    
    public List<User> getUsersByMonth(String mes){
        return repo.findByMonthBirthtDay(mes);
    }
    
}

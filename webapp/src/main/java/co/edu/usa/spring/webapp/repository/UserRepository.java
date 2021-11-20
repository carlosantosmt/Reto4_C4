/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.spring.webapp.repository;

import co.edu.usa.spring.webapp.crudInterface.UserInterface;
import co.edu.usa.spring.webapp.model.User;
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
    private UserInterface userCrudRepository;
    
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    public User newUser(User nUser){
        return userCrudRepository.save(nUser);
    }
    
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    
    public User existEmail(String email){
        return userCrudRepository.findByEmail(email);
    }
    
    public boolean exist(String email){
    return userCrudRepository.existsByEmail(email);
    }
    
    public User validateUser(String email, String pass){
        return userCrudRepository.findByEmailAndPassword(email, pass);
    }
}

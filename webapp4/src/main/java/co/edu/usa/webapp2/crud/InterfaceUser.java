/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.crud;

import co.edu.usa.webapp2.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author CARLOS ANDRES
 */
public interface InterfaceUser extends MongoRepository<User, Integer>{
    @Query("{id: ?0}")
    public Optional<User> getById(Integer id);
    
    public User findByEmail(String email);
    public boolean existsByEmail(String email);
    public User findByEmailAndPassword (String email, String password);
    
    @Query("{monthBirthtDay: ?0}")
    public List<User> findByMonthBirthtDay(String mes);
}

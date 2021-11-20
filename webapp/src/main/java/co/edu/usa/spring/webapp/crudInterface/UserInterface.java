/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.spring.webapp.crudInterface;

import co.edu.usa.spring.webapp.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CARLOS ANDRES
 */

public interface UserInterface extends CrudRepository<User, Integer>{
    
    public User findByEmail(String email);
    public boolean existsByEmail(String email);
    public User findByEmailAndPassword (String email, String password);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository;

import co.usa.edu.spring.rentcar.model.Client;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CARLOS ANDRES
 */

@Repository
public interface ClientInterface extends CrudRepository<Client, Integer> {
    public abstract List<Client> findByEmail(String email);    
}
 
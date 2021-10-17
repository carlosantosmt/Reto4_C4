/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import co.usa.edu.spring.rentcar.crudrepository.repository.ClientRepository;


/**
 *
 * @author CARLOS ANDRES
 */

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAllClients(){
        return (List<Client>)clientRepository.getAll();
    }
    
    public Optional<Client> getClienById(int id){
        return clientRepository.getClient(id);
    }
    
    public Client saveClient(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> clientOpt = clientRepository.getClient(client.getIdClient());
            if (!clientOpt.isPresent()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
        
    }
}

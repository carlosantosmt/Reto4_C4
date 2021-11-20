/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.spring.webapp.service;

import co.edu.usa.spring.webapp.model.User;
import co.edu.usa.spring.webapp.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS ANDRES
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers (){
    return userRepository.getAll();
    }
    
    public User newUser(User nUser){
        if (nUser.getId()==null){
            return userRepository.newUser(nUser);
        }else{
            Optional<User> userOpt = userRepository.getUser(nUser.getId());
            if(userOpt.isPresent()){
                return userRepository.newUser(nUser);
            }else{
                return nUser;
            }
        }
    }
    
    public boolean validateEmail(String email){
        return userRepository.existEmail(email)!=null;
    }
    
    public boolean validate(String email){
        return userRepository.exist(email);
    }
    
    public User validateUser(String email,String pass){
        User user = userRepository.validateUser(email, pass);
        if (user!=null){
            return user;
        }else{
            User user2 = new User();
            user2.setName("NO DEFINIDO");
            user2.setEmail(email);
            user2.setPassword(pass);
            return user2; 
        } 
    }
}

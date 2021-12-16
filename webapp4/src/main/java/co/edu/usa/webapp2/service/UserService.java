/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.service;

import co.edu.usa.webapp2.model.User;
import co.edu.usa.webapp2.repository.UserRepository;
import java.util.Date;
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
    
    public void newUser(User nUser){
        if (nUser.getId() != null){
            userRepository.save(nUser);
        }else{
            Optional<User> userOpt = userRepository.getById(nUser.getId());
            if(userOpt.isPresent()){
                userRepository.save(nUser);
            }
        }
    }
    
    public User update(User user){
        Optional<User> userOpt = userRepository.getById(user.getId());
        if(userOpt.isPresent()){
            if (user.getIdentification()!= null && user.getIdentification().length() > 0) {
                    userOpt.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null && user.getName().length() > 0) {
                    userOpt.get().setName(user.getName());
                }
                if (user.getBirthtDay()!= null) {
                    userOpt.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay()!= null && user.getMonthBirthtDay().length() > 0) {
                    userOpt.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null && user.getAddress().length() > 0) {
                    userOpt.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone()!= null && user.getCellPhone().length() > 0) {
                    userOpt.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail()!= null && user.getEmail().length() > 0) {
                    userOpt.get().setEmail(user.getEmail());
                }
                 if (user.getPassword()!= null && user.getPassword().length() > 0) {
                    userOpt.get().setPassword(user.getPassword());
                }
                 if (user.getZone()!= null && user.getZone().length() > 0) {
                    userOpt.get().setZone(user.getZone());
                }
                 if (user.getType()!= null && user.getType().length() > 0) {
                    userOpt.get().setType(user.getType());
                }
            userRepository.update(userOpt.get());
        }
        return user;
    }
   
    public boolean validate(String email){
        return userRepository.exist(email);
    }
    
    public User validateUser(String email,String pass){
        User user = userRepository.validateUser(email, pass);
        if (user!=null){
            return user;
        }else{
            User user2 = new User(null,null,null,null,null,null,null,null,null,null,null);
            return user2; 
        } 
    }
    
    public void delete(Integer id) {
        Optional<User> userOpt = userRepository.getById(id);
        if (userOpt.isPresent()) {
            userRepository.delete(userOpt.get());
        }
    }
    
    public User getUser(Integer id){
        Optional<User> userOpt = userRepository.getById(id);
        if(userOpt.isPresent()){
            return userOpt.get();
        }
        return null;
    }
    
    public List<User> getUsersByMonth(String mes){
        return userRepository.getUsersByMonth(mes);
    }
}

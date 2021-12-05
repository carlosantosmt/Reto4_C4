/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.webapp2.controller;

import co.edu.usa.webapp2.model.User;
import co.edu.usa.webapp2.service.UserService;
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
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    /**
     * Injección del servicio de usuarios
     */
    @Autowired
    private UserService userService;
    /**
     * Mapeado de petición web Http de tipo GET para obtener todos los usuarios
     * @return recupera todos los usuarios en la BD
     */
    @GetMapping("/all")
    public List<User> getUsers(){
    return userService.getAllUsers();
    }
    /**
     * Mapeado de petición web Http de tipo POST para registrar un nuevo usuario
     * @param newUser objeto de tipo usuario que se debe enviar para su creación
     * 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void newUser(@RequestBody User newUser){
        userService.newUser(newUser);
    }
    /**
     * Mapeado de petición web Http de tipo PUT para actualizar un usuario existente
     * @param usuario objeto de tipo usuario con los atributos a actualizar
     * @return es status afirmativo en caso de actualización
     */
    @PutMapping("/update")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity update(@RequestBody User usuario){
        userService.update(usuario);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    /**
     * Mapeado para la verificación de email existente en la BD por medio de petición
     * web Http tipo GET
     * @param email correo electrónico a verificar su existencia
     * @return una respuesta verdadero o falso dependiendo de la existencia del
     * parámetro enviado
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable String email){
        return userService.validate(email);
    }
    /**
     * Mapeado de petición web Http tipo GET para el login de usuario en la Webapp
     * @param email correo electrónico del usuario a logear
     * @param pass password del usuario a logear
     * @return un objeto de tipo usuario dependiendo de su existencia
     */
    @GetMapping("/{email}/{pass}")
    public User existUser(@PathVariable String email, @PathVariable String pass){
        return userService.validateUser(email, pass);
    }
    /**
     * Mapeado de petición we Http tipo DELETE para borrar un usuario por id
     * @param id del usuario que se desea eliminar
     * @return  codigo de estatus dependiendo de si fu exitoso
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    /**
     * Mapeado de petición web tipo Http GET para recuperar un usuario por id
     * @param idUser del usuario que se desea recuperar
     * @return un objeto tipo User 
     */
     @GetMapping("/{id}")
     public User getUser(@PathVariable("id") Integer idUser){
         return userService.getUser(idUser);
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.spring.webapp.controller;

import co.edu.usa.spring.webapp.model.User;
import co.edu.usa.spring.webapp.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase controlador para el registro y login de Usuarios en la webapp
 * @author CARLOS ANDRES
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class userController {
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
     * @return retorna el usuario creado 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User newUser(@RequestBody User newUser){
    return userService.newUser(newUser);
    }
    
    /**
     * Mapeado para la verificación de email existente en la BD por medio de petición
     * web Http tipo GET
     * @param email correo electrónico a verificar su existencia
     * @return una respuesta verdadero o falso dependiendo de la existencia del
     * parámetro enviado
     */
    @GetMapping("/{email}")
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
}

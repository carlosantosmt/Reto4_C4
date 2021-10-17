/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.model.Car;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.usa.edu.spring.rentcar.crudrepository.CarInterface;

/**
 *
 * @author CARLOS ANDRES
 */

@Repository
public class CarRepository {
    
    @Autowired
    private CarInterface carCrudRepository;
    
    public List<Car> getAll(){
        return (List<Car>) carCrudRepository.findAll();
    }
    
    public Optional<Car> getCar(int id){
        return carCrudRepository.findById(id);
    }
    
    public Car save(Car newCar){
        return carCrudRepository.save(newCar);
    }
}

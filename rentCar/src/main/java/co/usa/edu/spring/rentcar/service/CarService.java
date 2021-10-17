/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.crudrepository.repository.CarRepository;
import co.usa.edu.spring.rentcar.model.Car;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author CARLOS ANDRES
 */

@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;
    
    public List<Car> getAllCars(){
        return (List<Car>) carRepository.getAll();
    }
    
    public Optional<Car> getCarById(int id){
        return carRepository.getCar(id);
    }
    
    public Car saveCar(Car car){
        if(car.getIdCar()==null){
            return carRepository.save(car);
        }else{
            Optional<Car> carOpt = carRepository.getCar(car.getIdCar());
            if (!carOpt.isPresent()){
                return carRepository.save(car);
            }else{
                return car;
            }
        }
        
    }
      
}

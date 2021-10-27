/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.crudrepository.ReservationInterface;
import co.usa.edu.spring.rentcar.model.Client;
import co.usa.edu.spring.rentcar.model.Reservation;
import co.usa.edu.spring.rentcar.model.custom.CountClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CARLOS ANDRES
 */

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationInterface reservaCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservaCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservaCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation newReserv){
        return reservaCrudRepository.save(newReserv);
    }
    
    public void delete(Reservation delReserv){
        reservaCrudRepository.delete(delReserv);
    }
    /*
    public List<Reservation> getByDateRange(Date startDate, Date devDate){
        return (List<Reservation>) reservaCrudRepository.findByDevDateBefore(startDate, devDate);
    }
    
   public List<Object> getCountByStatus(){
        return reservaCrudRepository.countByStatus();
    }
   */
   public List<Reservation> getResByDateRange(Date start, Date end){
       return   reservaCrudRepository.findByStartDateAfterAndStartDateBefore(start, end);
   }
   
   public List<Reservation> getTotalByStatus(String status){
       return reservaCrudRepository.findAllByStatus(status);
   }
   
   public List<CountClient> getTopReservClient(){
       List<CountClient> res = new ArrayList<>();
       
       List<Object[]> report = reservaCrudRepository.countTotalReservationByClient();
       for (int i=0;i<report.size();i++){
            Client cli = (Client) report.get(i)[0];
            Long cantidad = (Long) report.get(i)[1];
            CountClient cClient = new CountClient(cantidad, cli);
            res.add(cClient);
           //res.add(new CountClient((Long) report.get(i)[1], (Client)report.get(i)[0]));
       }
       return res;
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.controller;

import co.usa.edu.spring.rentcar.model.Reservation;
import co.usa.edu.spring.rentcar.model.custom.CountClient;
import co.usa.edu.spring.rentcar.model.custom.StatusAmount;
import co.usa.edu.spring.rentcar.service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    
    @Autowired
    private ReservationService reservService;
   
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservService.getAllReservations();
    }
  
    @GetMapping("/{id}")
    public Optional <Reservation> getReservation(@PathVariable("id") int id){
        return reservService.getReservationById(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reserv){
        return reservService.saveReservation(reserv);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation res){
        return reservService.updateCar(res);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int id){
        return reservService.deleteReservation(id);
    }
    /*
    @GetMapping("/report-dates/{startDate}/{devDate}")
    public List<Reservation> getResByDateRange(@PathVariable("startDate") String startDate, @PathVariable("devDate") String devDate ) throws ParseException{
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date start = formater.parse(startDate);
        Date end = formater.parse(devDate);
        System.out.println("fecha_inicio:"+start+" "+"fecha_fin:"+end);
        return reservService.getResevByDateRange(start, end);
    }
    
  @GetMapping("/report-status")
    public List<Object> getCountByStatus(){
        return reservService.getBySatus();
    }
    */
    @GetMapping("/report-dates/{startDate}/{endDate}")
    public List<Reservation> getResvByDateRange(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        return reservService.getResByDateRange(startDate, endDate);
    }
    
    @GetMapping("/report-status")
    public StatusAmount getStatusByConcept(){
        return reservService.getStatusReport();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getCountTopClients(){
        return reservService.getTopReservClients();
    }
    
}

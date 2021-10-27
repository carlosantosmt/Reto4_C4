/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository;

import co.usa.edu.spring.rentcar.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CARLOS ANDRES
 */

public interface ReservationInterface extends CrudRepository<Reservation, Integer>{
   /* 
   @Query(value = "SELECT * FROM reservation r WHERE r.start_Date >= ?1 AND r.devolution_Date <= ?2", nativeQuery = true)
   List<Reservation> findByDevDateBefore(Date start, Date end);
   
   @Query(value = "SELECT COUNT(CASE WHEN status = 'completed' THEN TRUE END) AS completed, "
           + "COUNT(CASE WHEN status = 'cancelled' THEN TRUE END) AS cancelled FROM reservation ", nativeQuery = true)
   List<Object> countByStatus();
   */
   
   public List<Reservation> findByStartDateAfterAndStartDateBefore(Date start, Date end);
   
   public List<Reservation> findAllByStatus(String status);
   
   
   @Query("select r.client, COUNT(r.client) from Reservation AS r group by r.client order by COUNT(r.client) desc")
   public List<Object[]> countTotalReservationByClient();
   
   
}

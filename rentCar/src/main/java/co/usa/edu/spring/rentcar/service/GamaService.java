/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.service;

import co.usa.edu.spring.rentcar.crudrepository.repository.GamaRepository;
import co.usa.edu.spring.rentcar.model.Gama;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS ANDRES
 */

@Service
public class GamaService {
    
    @Autowired
    private GamaRepository gamaRepository;
    
    public List<Gama> getAllGama(){
        return (List<Gama>) gamaRepository.getAll();
    }
    
    public Optional<Gama> getGamaById(int id){
        return gamaRepository.getGama(id);
    }
    
    public Gama saveGama(Gama gama){
        if(gama.getIdGama() == null){
            return gamaRepository.save(gama);
        }else{
            Optional<Gama> gamaOpt = gamaRepository.getGama(gama.getIdGama());
            if (!gamaOpt.isPresent()){
                return gamaRepository.save(gama);
            }else {
            return gama ;
            }
        }
    }
}

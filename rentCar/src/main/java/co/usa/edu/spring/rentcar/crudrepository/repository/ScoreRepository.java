/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.edu.spring.rentcar.crudrepository.repository;

import co.usa.edu.spring.rentcar.crudrepository.ScoreInterface;
import co.usa.edu.spring.rentcar.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CARLOS ANDRES
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreInterface ScoreCrudRepository;
    
    public List<Score> getAll(){
        return (List<Score>) ScoreCrudRepository.findAll();
    }
    
    public Optional<Score> getScore(int id){
        return ScoreCrudRepository.findById(id);
    }
    
    public Score save(Score newScore){
        return ScoreCrudRepository.save(newScore);
    }
}

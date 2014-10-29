/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab4.services;

import ch.heigvd.amt.lab4.model.Sensor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RigHitZ
 */
@Local
public interface SensorDAOLocal {
    
    public void create(Sensor s);
    public void delete(long id);
    public void update(Sensor s);
    public Sensor findById(long id);
    public List<Sensor> findAll();
  
}

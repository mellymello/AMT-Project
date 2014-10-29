package ch.heigvd.amt.lab5.services;

import ch.heigvd.amt.lab5.model.Sensor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

/**
 *
 * @author RigHitZ
 */
@Stateless
public class SensorJpaDAO implements SensorDaoLocal {

  
    
    @PersistenceContext
    EntityManager em;
    @Override
    public void create(long sensorID, String description, String type) {
        Sensor s= new Sensor();
        s.setSensorID(sensorID);
        s.setDescription(description);
        s.setType(type);
        em.persist(s);
        em.flush();
    }

    @Override
    public void delete(long id) {
        em.remove(id);
    }

    @Override
    public void update(Sensor s) {
        em.merge(s);
    }

    
        
    @Override
    public Sensor findById(long id) {
        Sensor s = (Sensor) em.createNamedQuery("findSensorById").setParameter("id", id).getSingleResult();
        return s;
    }

    @Override
    public List<Sensor> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab5.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="sensors")
@NamedQueries({
    @NamedQuery(name = "findSensorById", query = "SELECT s FROM Sensor s WHERE s.id LIKE :id")})

public class Sensor implements Serializable {

    public enum Type{TEMPERATURE, SPEED};
    
    @Id
    private long sensorID;
    private String description;
    private String type;
    
     public Sensor() {

    }
    
    public Sensor(long sensorID, String description, String type) {
        this.sensorID = sensorID;
        this.description = description;
        this.type = type;
    }

    public long getSensorID() {
        return sensorID;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void setSensorID(long sensorID) {
        this.sensorID = sensorID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

}

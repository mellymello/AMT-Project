/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab4.model;

/**
 *
 * @author RigHitZ
 */



public class Sensor {

    public enum Type{TEMPERATURE, SPEED};
    
    private long sensorID;
    private String description;
    private String type;
    
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

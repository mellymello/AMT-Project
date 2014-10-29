/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab5.services;

import ch.heigvd.amt.lab5.model.Sensor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author RigHitZ
 */
@Stateless
public class SensorJdbcDAO implements SensorDaoLocal {

    @Resource(lookup = "JDBC/AMTDatabase")
    private DataSource dataSource;

    @Override
    public void create(long sensorID, String description, String type) {
        int generatedId = -1;
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO sensors (description, type) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, description);
            ps.setString(2, type);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.first()) {
// on récupère l'id généré
                generatedId = rs.getInt(1);
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SensorJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(long id) {
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM sensors WHERE id=" + id + ";");

            ResultSet rs = ps.executeQuery();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SensorJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Sensor s) {
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE sensors SET description=" + s.getDescription() + ", type=" + s.getType().toString() + " WHERE id=" + s.getSensorID() + ";");

            ResultSet rs = ps.executeQuery();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SensorJdbcDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Sensor findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sensor> findAll() {
        List<Sensor> result = new LinkedList<>();
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM sensors");

            ResultSet rs = ps.executeQuery();

            Sensor sensor = new Sensor();
            while (rs.next()) {
                sensor.setSensorID(rs.getLong("id"));
                sensor.setDescription(rs.getString("description"));
                sensor.setType(rs.getString("type"));
                result.add(sensor);
            }

            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(SensorJdbcDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
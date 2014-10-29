/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab4.controllers;

import ch.heigvd.amt.lab4.model.Sensor;
import ch.heigvd.amt.lab4.services.SensorDAOLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Calixte
 */
@WebServlet(name = "SensorServlet", urlPatterns = {"/SensorServlet"})
public class SensorServlet extends HttpServlet {

    
    @EJB
    SensorDAOLocal sensorManager;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        List<Sensor> sensors = sensorManager.findAll();
        request.setAttribute("sensors", sensors);
        request.getRequestDispatcher("WEB-INF/views/sensor.jsp").forward(request,response);
        
        

        
        /*try (PrintWriter out = response.getWriter()) { 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SensorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SensorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("<p>All Sensor : </p>");
            for(Sensor s : sensors)
            {
                out.println("<p>"+s.getSensorID()+" "+ s.getDescription()+ " "+ s.getType()+"</p>");
            }
            out.println("</html>");
        }*/
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.AsambleaBusiness;
import business.OrdenDiaBusiness;
import business.RegistroAsambleaBusiness;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistecia.dto.AsambleaDTO;
import persistecia.dto.OrdenDiaDTO;
import persistecia.dto.RegistroAsambleaDTO;
import persistecia.dto.UsuarioDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "EjecucionAsambleaController", urlPatterns = {"/ejecucionAsamblea.do"})
public class EjecucionAsambleaController extends HttpServlet {

    RegistroAsambleaBusiness registroAsambleaBusiness = new RegistroAsambleaBusiness();
    OrdenDiaBusiness ordenDiaBusiness = new OrdenDiaBusiness();
    AsambleaBusiness asambleaBusiness = new AsambleaBusiness();
    
    String labelAprob = "display: none";
    String labelNoAprob = "display: none";            
    

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
        
        PrintWriter out = response.getWriter();
        HttpSession misession= (HttpSession) request.getSession(); 
        UsuarioDTO usuario = (UsuarioDTO)misession.getAttribute("usuario"); 
        AsambleaDTO asamblea = asambleaBusiness.consultarAsambleaPorEstado("Ejecucion");
        
        if(request.getSession().getAttribute("m_ejecucion_asamblea").equals("display: none") || asamblea == null){
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.forward(request, response);        
        }
        else{       
        
        switch (request.getParameter("action")) {
            case "iniciar":                
                request.getSession().setAttribute("labelAprob", labelAprob);
                request.getSession().setAttribute("labelNoAprob", labelNoAprob);
                request.getRequestDispatcher("Asamblea/ejecucionAsamblea.jsp").forward(request, response);                        
                break;
            case "validarOrden":
                
                AsambleaDTO asambleaEjec = asambleaBusiness.consultarAsambleaPorEstado("Ejecucion");
                if(ordenDiaBusiness.validarOrdenDia(asambleaEjec.getIdOrdenDia().getId())){
                    labelAprob = "display:inline";                     
                } else{
                    labelNoAprob = "display:inline";
                } 
                request.getSession().setAttribute("labelAprob", labelAprob);
                request.getSession().setAttribute("labelNoAprob", labelNoAprob);
                request.getRequestDispatcher("Asamblea/ejecucionAsamblea.jsp").forward(request, response);                        
                break;    
            
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "1":
                    
                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
                
            }
        }
        }
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

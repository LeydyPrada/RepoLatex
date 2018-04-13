/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.EstadosAsambleaBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistecia.dto.EstadoAsambleaDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "EstadosAsambleaController", urlPatterns = {"/estadoAsamblea.do"})
public class EstadosAsambleaController extends HttpServlet {

    EstadosAsambleaBusiness estadosAsambleaBusiness = new EstadosAsambleaBusiness();

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
        
        switch (request.getParameter("action")) {
            case "crear":
                EstadoAsambleaDTO estadoAsamblea = new EstadoAsambleaDTO();
                estadoAsamblea.setDescripcion(request.getParameter("txtDescripcion"));
                estadoAsamblea.setActivo(1);
                estadosAsambleaBusiness.crearEstadoAsamblea(estadoAsamblea);
                request.getRequestDispatcher("estadoAsamblea.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<EstadoAsambleaDTO> estadosAsamblea = estadosAsambleaBusiness.consultarEstadosAsamblea(request.getParameter("txtEstadoBuscar"));
                request.getSession().setAttribute("Estados", estadosAsamblea);
                request.getRequestDispatcher("Configuracion/estadoAsamblea.jsp").forward(request, response);
                break;
            case "modificar":
                EstadoAsambleaDTO estadoAsambleaMod = estadosAsambleaBusiness.consultarEstadoAsamPorId(Integer.parseInt(request.getParameter("idEstadoAsamblea")));
                estadoAsambleaMod.setDescripcion(request.getParameter("txtDescripcion"));
                estadosAsambleaBusiness.actualizarEstadoAsamblea(estadoAsambleaMod);
                request.getRequestDispatcher("estadoAsamblea.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<EstadoAsambleaDTO> estadosAsamblea = estadosAsambleaBusiness.listarEstadosAsamblea();
                    request.getSession().setAttribute("Estados", estadosAsamblea);
                    request.getRequestDispatcher("Configuracion/estadoAsamblea.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    EstadoAsambleaDTO estadosAsambleaMod = estadosAsambleaBusiness.consultarEstadoAsamPorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("Estado", estadosAsambleaMod);
                    request.getRequestDispatcher("Configuracion/modificarEstadoAsamblea.jsp").forward(request, response);
                    break;                    
                case "dl"://Eliminar
                    EstadoAsambleaDTO estadoAsamblea = estadosAsambleaBusiness.consultarEstadoAsamPorId(Integer.parseInt(request.getParameter("code")));
                    estadosAsambleaBusiness.cambiarEstadoEstadoAsam(estadoAsamblea);
                    request.getRequestDispatcher("estadoAsamblea.do?method=get&&action=consul").forward(request, response);
                    break;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.TipoAsambleaBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistecia.dto.TipoAsambleaDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "TipoAsambleaController", urlPatterns = {"/tipoAsamblea.do"})
public class TipoAsambleaController extends HttpServlet {

    TipoAsambleaBusiness tipoAsambleaBusiness = new TipoAsambleaBusiness();

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
                TipoAsambleaDTO tipoAsamblea = new TipoAsambleaDTO();
                tipoAsamblea.setTipo(request.getParameter("txtTipo"));
                tipoAsamblea.setActivo(1);
                tipoAsambleaBusiness.crearTipoAsamblea(tipoAsamblea);
                request.getRequestDispatcher("tipoAsamblea.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<TipoAsambleaDTO> tiposAsambleas = tipoAsambleaBusiness.consultarTipoAsamblea(request.getParameter("txtTipoBuscar"));
                request.getSession().setAttribute("Tipos", tiposAsambleas);
                request.getRequestDispatcher("Configuracion/tipoAsamblea.jsp").forward(request, response);
                break;
            case "modificar":
                TipoAsambleaDTO tipoAsambleaMod = tipoAsambleaBusiness.consultarTipoAsamPorId(Integer.parseInt(request.getParameter("idTipoAsamblea")));
                tipoAsambleaMod.setTipo(request.getParameter("txtTipo"));
                tipoAsambleaBusiness.actualizarTipoAsamblea(tipoAsambleaMod);
                request.getRequestDispatcher("tipoAsamblea.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<TipoAsambleaDTO> tiposAsamblea = tipoAsambleaBusiness.listarTiposAsamblea();
                    request.getSession().setAttribute("Tipos", tiposAsamblea);
                    request.getRequestDispatcher("Configuracion/tipoAsamblea.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    TipoAsambleaDTO tiposAsambleaMod = tipoAsambleaBusiness.consultarTipoAsamPorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("Doc", tiposAsambleaMod);
                    request.getRequestDispatcher("Configuracion/modificarTipoAsamblea.jsp").forward(request, response);
                    break;                    
                case "dl"://Eliminar
                    TipoAsambleaDTO tipoAsamblea = tipoAsambleaBusiness.consultarTipoAsamPorId(Integer.parseInt(request.getParameter("code")));
                    tipoAsambleaBusiness.cambiarEstadoTipoEnc(tipoAsamblea);
                    request.getRequestDispatcher("tipoAsamblea.do?method=get&&action=consul").forward(request, response);
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

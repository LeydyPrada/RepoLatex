/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.TipoDocumentoBusiness;
import business.TipoEncuestaBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistecia.dto.TipoDocumentoDTO;
import persistecia.dto.TipoEncuestaDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "TipoEncuestaController", urlPatterns = {"/tipoEncuesta.do"})
public class TipoEncuestaController extends HttpServlet {

    TipoEncuestaBusiness tipoEncuestaBusiness = new TipoEncuestaBusiness();

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
                TipoEncuestaDTO tipoEnc = new TipoEncuestaDTO();
                tipoEnc.setTipo(request.getParameter("txtTipo"));
                tipoEnc.setActivo(1);
                tipoEncuestaBusiness.crearTipoEncuesta(tipoEnc);
                request.getRequestDispatcher("tipoEncuesta.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<TipoEncuestaDTO> encuestas = tipoEncuestaBusiness.consultarTipoEncuesta(request.getParameter("txtTipoBuscar"));
                request.getSession().setAttribute("Tipos", encuestas);
                request.getRequestDispatcher("Configuracion/tipoEncuesta.jsp").forward(request, response);
                break;
            case "modificar":
                TipoEncuestaDTO encuesta = tipoEncuestaBusiness.consultarTipoEncPorId(Integer.parseInt(request.getParameter("idTipoEnc")));
                encuesta.setTipo(request.getParameter("txtTipo"));
                tipoEncuestaBusiness.actualizarTipoEncuesta(encuesta);
                request.getRequestDispatcher("tipoEncuesta.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<TipoEncuestaDTO> tipos = tipoEncuestaBusiness.listarTipoEncuestas();
                    request.getSession().setAttribute("Tipos", tipos);
                    request.getRequestDispatcher("Configuracion/tipoEncuesta.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    TipoEncuestaDTO doc = tipoEncuestaBusiness.consultarTipoEncPorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("Doc", doc);
                    request.getRequestDispatcher("Configuracion/modificarTipoEncuesta.jsp").forward(request, response);
                    break;                    
                case "dl"://Eliminar
                    TipoEncuestaDTO tipoEnc = tipoEncuestaBusiness.consultarTipoEncPorId(Integer.parseInt(request.getParameter("code")));
                    tipoEncuestaBusiness.cambiarEstadoTipoEnc(tipoEnc);
                    request.getRequestDispatcher("tipoEncuesta.do?method=get&&action=consul").forward(request, response);
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

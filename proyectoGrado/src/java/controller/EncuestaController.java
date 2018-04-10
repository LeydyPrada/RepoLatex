/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.EncuestaBusiness;
import business.TipoEncuestaBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistecia.dto.EncuestaDTO;
import persistecia.dto.TipoEncuestaDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "EncuestaController", urlPatterns = {"/encuesta.do"})
public class EncuestaController extends HttpServlet {

    EncuestaBusiness encuestaBusiness = new EncuestaBusiness();
    TipoEncuestaBusiness tipoEncBusiness = new TipoEncuestaBusiness();

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
                EncuestaDTO encuesta = new EncuestaDTO();
                encuesta.setDescripcion(request.getParameter("txtDescripcion"));
                TipoEncuestaDTO tipoEnc = tipoEncBusiness.consultarTipoEncPorId(Integer.parseInt(request.getParameter("txtTipo")));
                encuesta.setTipoEncuesta(tipoEnc);
                encuesta.setActivo(1);
                encuestaBusiness.crearEncuesta(encuesta);
                request.getRequestDispatcher("encuesta.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<EncuestaDTO> encuestas = encuestaBusiness.consultarEncuesta(request.getParameter("txtDescripBuscar"));
                request.getSession().setAttribute("Encuestas", encuestas);
                request.getRequestDispatcher("Encuesta/encuesta.jsp").forward(request, response);
                break;
            case "modificar":
                EncuestaDTO encuest = encuestaBusiness.consultarEncPorId(Integer.parseInt(request.getParameter("idEnc")));
                encuest.setDescripcion(request.getParameter("txtDescripcion"));
                TipoEncuestaDTO tipoEncues = tipoEncBusiness.consultarTipoEncPorId(Integer.parseInt(request.getParameter("txtTipo")));
                encuest.setTipoEncuesta(tipoEncues);
                encuestaBusiness.actualizarEncuesta(encuest);
                request.getRequestDispatcher("encuesta.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<EncuestaDTO> encuestass = encuestaBusiness.listarEncuestas();
                    request.getSession().setAttribute("Encuestas", encuestass);
                    request.getRequestDispatcher("Encuesta/encuesta.jsp").forward(request, response);
                    break;
                case "consulTipos":
                    List<TipoEncuestaDTO> tipos = tipoEncBusiness.listarTipoEncuestas();
                    request.getSession().setAttribute("TipoEncuestas", tipos);
                    request.getRequestDispatcher("Encuesta/crearEncuesta.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    EncuestaDTO doc = encuestaBusiness.consultarEncPorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("Encuesta", doc);
                    List<TipoEncuestaDTO> tiposEn = tipoEncBusiness.listarTipoEncuestas();
                    request.getSession().setAttribute("TipoEncuestas", tiposEn);
                    request.getRequestDispatcher("Encuesta/modificarEncuesta.jsp").forward(request, response);
                    break;
                case "dl"://Eliminar
                    EncuestaDTO tipoEnc = encuestaBusiness.consultarEncPorId(Integer.parseInt(request.getParameter("code")));
                    encuestaBusiness.cambiarEstadoEnc(tipoEnc);
                    request.getRequestDispatcher("encuesta.do?method=get&&action=consul").forward(request, response);
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

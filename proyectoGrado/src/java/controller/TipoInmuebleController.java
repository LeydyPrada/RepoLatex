/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.TipoInmuebleBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistecia.dto.TipoInmuebleDTO;


/**
 *
 * @author USUARIO
 */
@WebServlet(name = "TipoInmuebleController", urlPatterns = {"/tipoInmueble.do"})
public class TipoInmuebleController extends HttpServlet {

     TipoInmuebleBusiness tipoInmuBusiness = new TipoInmuebleBusiness();

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
                TipoInmuebleDTO tipoInmueble = new TipoInmuebleDTO();
                tipoInmueble.setTipoInmueble(request.getParameter("txtTipoInm"));
                tipoInmueble.setActivo(1);
                tipoInmuBusiness.crearTipoInmueble(tipoInmueble);
                request.getRequestDispatcher("tipoInmueble.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<TipoInmuebleDTO> tiposInmueble = tipoInmuBusiness.consultarPorTipoInmueble(request.getParameter("txtTipoBuscar"));
                request.getSession().setAttribute("TipoInm", tiposInmueble);
                request.getRequestDispatcher("Configuracion/tipoInmueble.jsp").forward(request, response);
                break;
            case "modificar":
                TipoInmuebleDTO tipoInmuebleMod = tipoInmuBusiness.consultarTipoInmueblePorId(Integer.parseInt(request.getParameter("idTipoInm")));
                tipoInmuebleMod.setTipoInmueble(request.getParameter("txtTipoInm"));
                tipoInmuBusiness.actualizarTipoInmueble(tipoInmuebleMod);
                request.getRequestDispatcher("tipoInmueble.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<TipoInmuebleDTO> tipos = tipoInmuBusiness.listarTipoDeInmuebles();
                    request.getSession().setAttribute("TipoInm", tipos);
                    request.getRequestDispatcher("Configuracion/tipoInmueble.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    TipoInmuebleDTO tipoInmueble = tipoInmuBusiness.consultarTipoInmueblePorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("TipoInm", tipoInmueble);
                    request.getRequestDispatcher("Configuracion/modificarTipoInmueble.jsp").forward(request, response);
                    break;                    
                case "dl"://Eliminar
                    TipoInmuebleDTO tipoInmuebleElim = tipoInmuBusiness.consultarTipoInmueblePorId(Integer.parseInt(request.getParameter("code")));
                    tipoInmuBusiness.cambiarEstadoTipoInmueble(tipoInmuebleElim);
                    request.getRequestDispatcher("tipoInmueble.do?method=get&&action=consul").forward(request, response);
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

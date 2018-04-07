/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.TipoUsuarioBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistecia.dto.TipoUsuarioDTO;


/**
 *
 * @author USUARIO
 */
@WebServlet(name = "TipoUsuarioController", urlPatterns = {"/tipoUsuario.do"})
public class TipoUsuarioController extends HttpServlet {

     TipoUsuarioBusiness tipoUsrBusiness = new TipoUsuarioBusiness();

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
                TipoUsuarioDTO tipoUsr = new TipoUsuarioDTO();
                tipoUsr.setTipo(request.getParameter("txtTipoUsr"));
                tipoUsr.setActivo(1);
                tipoUsrBusiness.crearTipoUsuario(tipoUsr);
                request.getRequestDispatcher("tipoUsuario.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<TipoUsuarioDTO> tiposUsuario = tipoUsrBusiness.consultarTipoUsrPorTipo(request.getParameter("txtTipoBuscar"));
                request.getSession().setAttribute("TipoUsr", tiposUsuario);
                request.getRequestDispatcher("Configuracion/tipoUsuario.jsp").forward(request, response);
                break;
            case "modificar":
                TipoUsuarioDTO tipoUsuario = tipoUsrBusiness.consultarTipoUsrPorId(Integer.parseInt(request.getParameter("idTipoUsr")));
                tipoUsuario.setTipo(request.getParameter("txtTipoUsr"));
                tipoUsrBusiness.actualizarTipoUsuario(tipoUsuario);
                request.getRequestDispatcher("tipoUsuario.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<TipoUsuarioDTO> tipos = tipoUsrBusiness.listarTipoDeUsuarios();
                    request.getSession().setAttribute("TipoUsr", tipos);
                    request.getRequestDispatcher("Configuracion/tipoUsuario.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    TipoUsuarioDTO tipoUsuario = tipoUsrBusiness.consultarTipoUsrPorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("TipoUsr", tipoUsuario);
                    request.getRequestDispatcher("Configuracion/modificarTipoUsuario.jsp").forward(request, response);
                    break;                    
                case "dl"://Eliminar
                    TipoUsuarioDTO tipoUsr = tipoUsrBusiness.consultarTipoUsrPorId(Integer.parseInt(request.getParameter("code")));
                    tipoUsrBusiness.cambiarEstadoTipoUsr(tipoUsr);
                    request.getRequestDispatcher("tipoUsuario.do?method=get&&action=consul").forward(request, response);
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

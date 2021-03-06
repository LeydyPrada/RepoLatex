/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.InmuebleBusiness;
import business.TipoInmuebleBusiness;
import business.UsuarioBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistecia.dto.InmuebleDTO;
import persistecia.dto.TipoInmuebleDTO;
import persistecia.dto.UsuarioDTO;


/**
 *
 * @author USUARIO
 */
@WebServlet(name = "InmuebleController", urlPatterns = {"/inmueble.do"})
public class InmuebleController extends HttpServlet {

     InmuebleBusiness inmuebleBusiness = new InmuebleBusiness();
     TipoInmuebleBusiness tipoInmuBusiness = new TipoInmuebleBusiness();
     UsuarioBusiness usuarioBusiness = new UsuarioBusiness();

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
        
        HttpSession misession= (HttpSession) request.getSession(); 
        misession.getAttribute("usuario");
        
        if(request.getSession().getAttribute("m_inmueble").equals("display: none")){
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.forward(request, response);
           }
        else{
        
        switch (request.getParameter("action")) {
            case "crear":
                InmuebleDTO inmueble = new InmuebleDTO();
                UsuarioDTO usuario = usuarioBusiness.consultarUsuarioPorId(request.getParameter("txtIdUsuario"));
                TipoInmuebleDTO tipoInmueble = tipoInmuBusiness.consultarTipoInmueblePorId(Integer.parseInt(request.getParameter("txtIdTipoInm")));
                inmueble.setInmueble(request.getParameter("txtInmueble"));
                inmueble.setArea_total(Integer.parseInt(request.getParameter("txtAreaTot")));
                inmueble.setArea_construida(Integer.parseInt(request.getParameter("txtAreaCons")));
                inmueble.setArea_ponderar(Integer.parseInt(request.getParameter("txtAreaPond")));
                inmueble.setCoeficiente(Integer.parseInt(request.getParameter("txtCoeficiente")));
                inmueble.setTipoInmueble(tipoInmueble);
                inmueble.setUsuario(usuario);
                inmueble.setActivo(1);
                inmuebleBusiness.crearInmueble(inmueble);
                request.getRequestDispatcher("inmueble.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<InmuebleDTO> inmuebles = inmuebleBusiness.consultarPorInmueble(request.getParameter("txtInmuBuscar"));
                request.getSession().setAttribute("Inmueble", inmuebles);
                request.getRequestDispatcher("Usuario/inmueble.jsp").forward(request, response);
                break;
            case "modificar":
                InmuebleDTO inmuebleMod = inmuebleBusiness.consultarInmueblePorId(Integer.parseInt(request.getParameter("idInmueble")));
                UsuarioDTO usuarioMod = usuarioBusiness.consultarUsuarioPorId(request.getParameter("txtIdUsuario"));
                TipoInmuebleDTO tipoInmuebleMod = tipoInmuBusiness.consultarTipoInmueblePorId(Integer.parseInt(request.getParameter("txtIdTipoInm")));
                inmuebleMod.setInmueble(request.getParameter("txtInmueble"));
                inmuebleMod.setArea_total(Integer.parseInt(request.getParameter("txtAreaTot")));
                inmuebleMod.setArea_construida(Integer.parseInt(request.getParameter("txtAreaCons")));
                inmuebleMod.setArea_ponderar(Integer.parseInt(request.getParameter("txtAreaPond")));
                inmuebleMod.setCoeficiente(Integer.parseInt(request.getParameter("txtCoeficiente")));
                inmuebleMod.setTipoInmueble(tipoInmuebleMod);
                inmuebleMod.setUsuario(usuarioMod);
                inmuebleBusiness.actualizarInmueble(inmuebleMod);
                request.getRequestDispatcher("inmueble.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<InmuebleDTO> inmuebles = inmuebleBusiness.listarInmuebles();
                    request.getSession().setAttribute("Inmuebles", inmuebles);
                    request.getRequestDispatcher("Usuario/inmueble.jsp").forward(request, response);
                    break;
                case "consulTipos":
                    List<TipoInmuebleDTO> tiposInmu = tipoInmuBusiness.listarTipoDeInmuebles();
                    request.getSession().setAttribute("TiposInmu", tiposInmu);
                    List<UsuarioDTO> usuarios = usuarioBusiness.listarUsuarios();
                    request.getSession().setAttribute("Usr", usuarios);                    
                    request.getRequestDispatcher("Usuario/crearInmueble.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    InmuebleDTO inmueble = inmuebleBusiness.consultarInmueblePorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("Inmueble", inmueble);
                    List<TipoInmuebleDTO> tiposInmuMod = tipoInmuBusiness.listarTipoDeInmuebles();
                    request.getSession().setAttribute("TiposInmu", tiposInmuMod);
                    List<UsuarioDTO> usuariosMod = usuarioBusiness.listarUsuarios();
                    request.getSession().setAttribute("Usr", usuariosMod); 
                    request.getRequestDispatcher("Usuario/modificarInmueble.jsp").forward(request, response);
                    break;                    
                case "dl"://Eliminar
                    InmuebleDTO inmuebleElim = inmuebleBusiness.consultarInmueblePorId(Integer.parseInt(request.getParameter("code")));
                    inmuebleBusiness.cambiarEstadoInmueble(inmuebleElim);
                    request.getRequestDispatcher("inmueble.do?method=get&&action=consul").forward(request, response);
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

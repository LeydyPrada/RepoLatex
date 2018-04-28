/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.TipoDocumentoBusiness;
import business.TipoUsuarioBusiness;
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
import persistecia.dto.TipoDocumentoDTO;
import persistecia.dto.TipoUsuarioDTO;
import persistecia.dto.UsuarioDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/usuario.do"})
public class UsuarioController extends HttpServlet {
    
    UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
    TipoUsuarioBusiness tipoUsuarioBusiness = new TipoUsuarioBusiness();
    TipoDocumentoBusiness tipoDocumentoBusiness = new TipoDocumentoBusiness();

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
                     
        if(request.getSession().getAttribute("m_usuario").equals("display: none")){
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.forward(request, response);        
        }
        else{
               
        
        switch (request.getParameter("action")) {
            case "crear":
                UsuarioDTO usuario = new UsuarioDTO();
                TipoUsuarioDTO tipoUsr = tipoUsuarioBusiness.consultarTipoUsrPorId(Integer.parseInt(request.getParameter("txtIdTipoUsr")));
                TipoDocumentoDTO tipoDoc = tipoDocumentoBusiness.consultarTipoDocPorId(Integer.parseInt(request.getParameter("txtIdTipoDoc")));
                usuario.setId(request.getParameter("txtIdUsuario"));
                usuario.setNombre(request.getParameter("txtNombre"));
                usuario.setApellido(request.getParameter("txtApellido"));
                usuario.setDireccion(request.getParameter("txtDireccion"));
                usuario.setTelefono(request.getParameter("txtTelefono"));
                usuario.setGenero(request.getParameter("txtGenero"));
                usuario.setEmail(request.getParameter("txtEmail"));
                usuario.setUsuarioLogin(request.getParameter("txtLogin"));
                usuario.setContraseña(request.getParameter("txtContrasena"));                
                usuario.setActivo(1);
                usuario.setTipoDocumento(tipoDoc);
                usuario.setTipoUusario(tipoUsr);                
                usuarioBusiness.crearUsuario(usuario);
                request.getRequestDispatcher("usuario.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<UsuarioDTO> usuarios = usuarioBusiness.consultarUsuarioNombre(request.getParameter("txtNombreBuscar"));
                request.getSession().setAttribute("Usuarios", usuarios);
                request.getRequestDispatcher("Usuario/usuario.jsp").forward(request, response);
                break;
            case "modificar":
                UsuarioDTO usuarioMod = usuarioBusiness.consultarUsuarioPorId(request.getParameter("idUsuario"));
                TipoUsuarioDTO tipoUsuario = tipoUsuarioBusiness.consultarTipoUsrPorId(Integer.parseInt(request.getParameter("txtIdTipoUsr")));
                TipoDocumentoDTO tipoDocumento = tipoDocumentoBusiness.consultarTipoDocPorId(Integer.parseInt(request.getParameter("txtIdTipoDoc")));
                usuarioMod.setNombre(request.getParameter("txtNombre"));
                usuarioMod.setApellido(request.getParameter("txtApellido"));
                usuarioMod.setDireccion(request.getParameter("txtDireccion"));
                usuarioMod.setTelefono(request.getParameter("txtTelefono"));
                usuarioMod.setGenero(request.getParameter("txtGenero"));
                usuarioMod.setEmail(request.getParameter("txtEmail"));
                usuarioMod.setUsuarioLogin(request.getParameter("txtLogin"));
                usuarioMod.setContraseña(request.getParameter("txtContrasena"));                
                usuarioMod.setTipoDocumento(tipoDocumento);
                usuarioMod.setTipoUusario(tipoUsuario);
                usuarioBusiness.actualizarUsuario(usuarioMod);
                request.getRequestDispatcher("usuario.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<UsuarioDTO> usuarios = usuarioBusiness.listarUsuarios();
                    request.getSession().setAttribute("Usuarios", usuarios);
                    request.getRequestDispatcher("Usuario/usuario.jsp").forward(request, response);
                    break;
                case "consulTipos":
                    List<TipoDocumentoDTO> tiposDoc = tipoDocumentoBusiness.listarTipoDeDocumentos();
                    request.getSession().setAttribute("TiposDoc", tiposDoc);
                    List<TipoUsuarioDTO> tiposUsr = tipoUsuarioBusiness.listarTipoDeUsuarios();
                    request.getSession().setAttribute("TipoUsr", tiposUsr);                    
                    request.getRequestDispatcher("Usuario/crearUsuario.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    UsuarioDTO usuario = usuarioBusiness.consultarUsuarioPorId(request.getParameter("code"));
                    request.getSession().setAttribute("Usuario", usuario);
                    List<TipoDocumentoDTO> tiposDocum = tipoDocumentoBusiness.listarTipoDeDocumentos();
                    request.getSession().setAttribute("TiposDoc", tiposDocum);
                    List<TipoUsuarioDTO> tiposUsuaro = tipoUsuarioBusiness.listarTipoDeUsuarios();
                    request.getSession().setAttribute("TipoUsr", tiposUsuaro);
                    request.getRequestDispatcher("Usuario/modificarUsuario.jsp").forward(request, response);
                    break;                    
                case "dl"://Eliminar
                    UsuarioDTO usuarioElim = usuarioBusiness.consultarUsuarioPorId(request.getParameter("code"));
                    usuarioBusiness.cambiarEstadoUsuario(usuarioElim);
                    request.getRequestDispatcher("usuario.do?method=get&&action=consul").forward(request, response);
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

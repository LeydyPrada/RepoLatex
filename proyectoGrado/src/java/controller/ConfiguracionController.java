/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.ConfiguracionBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistecia.dto.TipoDocumentoDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ConfiguracionController", urlPatterns = {"/configuracionController"})
public class ConfiguracionController extends HttpServlet {

     ConfiguracionBusiness configBusiness = new ConfiguracionBusiness();

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
                TipoDocumentoDTO tipoDoc = new TipoDocumentoDTO();
                tipoDoc.setCodigo(request.getParameter("txtCodigo"));
                tipoDoc.setTipoDocumento(request.getParameter("txtTipoDoc"));
                tipoDoc.setActivo(1);
                configBusiness.crearTipoDocumento(tipoDoc);
                request.getRequestDispatcher("configuracionController?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<TipoDocumentoDTO> documentos = configBusiness.consultarTipoDoc(request.getParameter("txtCodigoBuscar"));
                request.getSession().setAttribute("Tipos", documentos);
                request.getRequestDispatcher("Configuracion/tipoDocumento.jsp").forward(request, response);
                break;
            case "modificar":
                TipoDocumentoDTO documento = configBusiness.consultarTipoDocPorId(Integer.parseInt(request.getParameter("idTipoDoc")));
                documento.setCodigo(request.getParameter("txtCodigo"));
                documento.setTipoDocumento(request.getParameter("txtTipoDoc"));
                configBusiness.actualizarTipoDocumento(documento);
                request.getRequestDispatcher("configuracionController?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<TipoDocumentoDTO> tipos = configBusiness.listarTipoDeDocumentos();
                    request.getSession().setAttribute("Tipos", tipos);
                    request.getRequestDispatcher("Configuracion/tipoDocumento.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    TipoDocumentoDTO doc = configBusiness.consultarTipoDocPorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("Doc", doc);
                    request.getRequestDispatcher("Configuracion/modificarTipoDocumento.jsp").forward(request, response);
                    break;                    
                case "dl"://Eliminar
                    TipoDocumentoDTO tipoDoc = configBusiness.consultarTipoDocPorId(Integer.parseInt(request.getParameter("code")));
                    configBusiness.cambiarEstadoTipoDoc(tipoDoc);
                    request.getRequestDispatcher("configuracionController?method=get&&action=consul").forward(request, response);
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

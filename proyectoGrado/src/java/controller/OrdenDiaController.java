/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.OrdenDiaBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistecia.dto.OrdenDiaDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "OrdenDiaController", urlPatterns = {"/ordenDia.do"})
public class OrdenDiaController extends HttpServlet {

     OrdenDiaBusiness ordenDiaBusiness = new OrdenDiaBusiness();

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
        
        if(request.getSession().getAttribute("m_orden_dia").equals("display: none")){
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.forward(request, response);
           }
        else{
        
        switch (request.getParameter("action")) {
            case "crear":
                OrdenDiaDTO ordenDia = new OrdenDiaDTO();
                ordenDia.setOrden(request.getParameter("txtOden"));
                ordenDia.setDescripcion(request.getParameter("txtDescripcion"));
                ordenDia.setActivo(1);
                ordenDiaBusiness.crearOrdenDia(ordenDia);
                request.getRequestDispatcher("ordenDia.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<OrdenDiaDTO> ordenesDia = ordenDiaBusiness.consultarPorOrdenDia(request.getParameter("txtOrdenBuscar"));
                request.getSession().setAttribute("Ordenes", ordenesDia);
                request.getRequestDispatcher("Asamblea/ordenDia.jsp").forward(request, response);
                break;
            case "modificar":
                OrdenDiaDTO ordenDiaMod = ordenDiaBusiness.consultarOrdenDiaPorId(Integer.parseInt(request.getParameter("idOrdenDia")));
                ordenDiaMod.setOrden(request.getParameter("txtOden"));
                ordenDiaMod.setDescripcion(request.getParameter("txtDescripcion"));
                ordenDiaBusiness.actualizarOrdenDia(ordenDiaMod);
                request.getRequestDispatcher("ordenDia.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<OrdenDiaDTO> ordenesDia = ordenDiaBusiness.listarOrdenesDeDia();
                    request.getSession().setAttribute("Ordenes", ordenesDia);
                    request.getRequestDispatcher("Asamblea/ordenDia.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    OrdenDiaDTO ordenDia = ordenDiaBusiness.consultarOrdenDiaPorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("Orden", ordenDia);
                    request.getRequestDispatcher("Asamblea/modificarOrdenDia.jsp").forward(request, response);
                    break;                    
                case "dl"://Eliminar
                    OrdenDiaDTO ordenDiaElim = ordenDiaBusiness.consultarOrdenDiaPorId(Integer.parseInt(request.getParameter("code")));
                    ordenDiaBusiness.cambiarEstadoOrdenDia(ordenDiaElim);
                    request.getRequestDispatcher("ordenDia.do?method=get&&action=consul").forward(request, response);
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

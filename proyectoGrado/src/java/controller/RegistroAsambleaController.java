/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.AsambleaBusiness;
import business.OrdenDiaBusiness;
import business.RegistroAsambleaBusiness;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistecia.dto.AsambleaDTO;
import persistecia.dto.OrdenDiaDTO;
import persistecia.dto.RegistroAsambleaDTO;
import persistecia.dto.UsuarioDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "RegistroAsambleaController", urlPatterns = {"/registroAsamblea.do"})
public class RegistroAsambleaController extends HttpServlet {

    RegistroAsambleaBusiness registroAsambleaBusiness = new RegistroAsambleaBusiness();
    OrdenDiaBusiness ordenDiaBusiness = new OrdenDiaBusiness();
    AsambleaBusiness asambleaBusiness = new AsambleaBusiness();
    
    String opcionOrden = "display: none";
    String opcionRegistro = "display:inline";
    String aprobado = "display:inline";
    String noAprobado = "display:inline";
    String preguntas = "display: none";
    
            
    

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
        
        PrintWriter out = response.getWriter();
        HttpSession misession= (HttpSession) request.getSession(); 
        UsuarioDTO usuario = (UsuarioDTO)misession.getAttribute("usuario"); 
        AsambleaDTO asamblea = asambleaBusiness.consultarAsambleaPorEstado("Ejecucion");
        
        if(request.getSession().getAttribute("m_ingreso_asamblea").equals("display: none") || asamblea == null){
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.forward(request, response);        
        }
        else{       
        
        switch (request.getParameter("action")) {
            case "registrar":               
                RegistroAsambleaDTO registroAsamblea =  registroAsambleaBusiness.validarRegistroAsamblea(usuario.getId(), Integer.parseInt(request.getParameter("txtCodigo")));
                if(registroAsamblea.getResultado().equalsIgnoreCase("Registro Valido")){
                    opcionRegistro ="display: none";
                    opcionOrden = "display:inline";
                    request.getSession().setAttribute("opcionOrden", opcionOrden);
                    request.getSession().setAttribute("opcionRegistro", opcionRegistro);                    
                    request.getRequestDispatcher("registroAsamblea.do?method=get&&action=consulOrden").forward(request, response);
                    }
                else{
                    out.println("<font color='red'><b>"+registroAsamblea.getResultado()+"</b></font>");
                }                
                break;                      
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "ingreso":
                    opcionRegistro ="display:inline";
                    opcionOrden = "display: none";
                    request.getSession().setAttribute("opcionRegistro", opcionRegistro);
                    request.getSession().setAttribute("opcionOrden", opcionOrden);
                    request.getRequestDispatcher("Asamblea/ingresoAsamblea.jsp").forward(request, response);
                    break;
                case "consulOrden":
                    AsambleaDTO asambleaEjec = asambleaBusiness.consultarAsambleaPorEstado("Ejecucion");
                    OrdenDiaDTO ordenDia = ordenDiaBusiness.consultarOrdenDiaPorId(asambleaEjec.getIdOrdenDia().getId());
                    request.getSession().setAttribute("OrdenDia", ordenDia);
                    aprobado = "display:inline";
                    noAprobado = "display:inline";
                    preguntas = "display: none";
                    request.getSession().setAttribute("btnAprobado", aprobado);
                    request.getSession().setAttribute("btnNoAprobado", noAprobado);
                    request.getSession().setAttribute("btnPreguntas", preguntas);                    
                    request.getRequestDispatcher("Asamblea/ingresoAsamblea.jsp").forward(request, response);
                    break;
                case "votar":
                    OrdenDiaDTO ordenDelDia = new OrdenDiaDTO();
                    AsambleaDTO asambleaEnEjec = asambleaBusiness.consultarAsambleaPorEstado("Ejecucion");
                    ordenDelDia.setId(asambleaEnEjec.getIdOrdenDia().getId());
                    if(request.getParameter("aprob") != null){
                    ordenDelDia.setAprobado(Integer.parseInt(request.getParameter("aprob")));
                    ordenDelDia.setNoAprobado(0);
                    }else if(request.getParameter("noaprob") != null){
                    ordenDelDia.setNoAprobado(Integer.parseInt(request.getParameter("noaprob")));
                    ordenDelDia.setAprobado(0);
                    }
                    ordenDiaBusiness.votarOrdenDia(ordenDelDia);
                    aprobado = "display: none";
                    noAprobado = "display: none";
                    preguntas = "display:inline";
                    request.getSession().setAttribute("btnAprobado", aprobado);
                    request.getSession().setAttribute("btnNoAprobado", noAprobado);
                    request.getSession().setAttribute("btnPreguntas", preguntas);
                    request.getRequestDispatcher("Asamblea/ingresoAsamblea.jsp").forward(request, response);
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

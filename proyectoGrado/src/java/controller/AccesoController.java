/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.UsuarioBusiness;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistecia.dto.UsuarioDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "AccesoController", urlPatterns = {"/acceso.do"})
public class AccesoController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/index.html");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
            //creamos la instancia de UsuarioBusiness
           UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
           UsuarioDTO usr = usuarioBusiness.autenticacionUsaurio(usuario, password);
                
            if(usr.getId() != null){
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usr);
                RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
                rd.forward(request, response);
                } 
            else{
                out.println("<font color='red'><b>Usuario y/o password incorrecto</b></font>");
                RequestDispatcher rs = request.getRequestDispatcher("/index.html");
                rs.include(request, response);
                }                       
        }
}

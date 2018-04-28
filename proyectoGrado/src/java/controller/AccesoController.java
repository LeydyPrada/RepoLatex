/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.UsuarioBusiness;
import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
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
    
   
    String m_asamblea="display: none";
    String m_orden_dia="display: none";
    String m_preguntas="display: none";
    String m_usuario="display: none";
    String m_inmueble="display: none";
    String m_voto="display: none";
    String m_tipo_asamblea="display: none";
    String m_estado_asamblea="display: none";
    String m_tipo_documento="display: none";
    String m_tipo_inmueble="display: none";
    String m_tipo_usuario="display: none";
    String menu_asamblea_general="display: none";
    String menu_usuarios="display: none";
    String menu_configuracion="display: none";
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
            //creamos la instancia de UsuarioBusiness
           UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
           UsuarioDTO usr = usuarioBusiness.autenticacionUsaurio(usuario, password);
         
             //validar properties para controlar visibilidad de menu segun perfil
                       
               Properties props = new ConfigPerfiles().getProperties();
                          
		for (Enumeration e = props.keys(); e.hasMoreElements() ; ) {
			// Obtenemos el objeto
			Object obj = e.nextElement();
                        String[] valorProp = props.getProperty(obj.toString()).split(",");
                        for (int i=0; i<valorProp.length; i++){
                            if(valorProp[i].equalsIgnoreCase(usr.getTipoUusario().getId().toString()))
                                switch(obj.toString()){
                                  case"asamblea":
                                    m_asamblea = "display:inline";
                                    break;
                                  case"orden_dia":
                                    m_orden_dia = "display:inline";
                                    break;
                                  case"preguntas":
                                    m_preguntas = "display:inline"; 
                                    break;                                    
                                  case"usuario":
                                    m_usuario = "display:inline";
                                    break;
                                  case"inmueble":
                                    m_inmueble = "display:inline";
                                    break;                                  
                                  case"voto":
                                    m_voto = "display:inline";
                                    break;                                    
                                  case"tipo_asamblea":
                                    m_tipo_asamblea = "display:inline";
                                    break;                                    
                                  case"estado_asamblea":
                                    m_estado_asamblea = "display:inline";
                                    break;                                  
                                  case"tipo_documento":
                                    m_tipo_documento = "display:inline";
                                    break;                                   
                                  case"tipo_inmueble":
                                    m_tipo_inmueble = "display:inline";
                                    break;                                  
                                  case"tipo_usuario":
                                    m_tipo_usuario = "display:inline";
                                    break;
                                  case"asamblea_general":
                                    menu_asamblea_general = "display:inline";
                                    break;  
                                  case"usuarios":
                                    menu_usuarios = "display:inline";
                                    break;  
                                  case"configuracion;":
                                    menu_configuracion = "display:inline";
                                    break;  
                                }
                        }                     
			
		}          
                   
          
                
            if(usr.getId() != null){
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usr);
                request.getSession().setAttribute("m_asamblea", m_asamblea);
                request.getSession().setAttribute("m_orden_dia", m_orden_dia);
                request.getSession().setAttribute("m_preguntas", m_preguntas);
                request.getSession().setAttribute("m_usuario", m_usuario);
                request.getSession().setAttribute("m_inmueble", m_inmueble);
                request.getSession().setAttribute("m_voto", m_voto);
                request.getSession().setAttribute("m_tipo_asamblea", m_tipo_asamblea);
                request.getSession().setAttribute("m_estado_asamblea", m_estado_asamblea);
                request.getSession().setAttribute("m_tipo_documento", m_tipo_documento);
                request.getSession().setAttribute("m_tipo_inmueble", m_tipo_inmueble);
                request.getSession().setAttribute("m_tipo_usuario", m_tipo_usuario);  
                request.getSession().setAttribute("menu_asamblea_general", menu_asamblea_general);
                request.getSession().setAttribute("menu_usuarios", menu_usuarios);
                request.getSession().setAttribute("menu_configuracion", menu_configuracion);
                RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
                rd.forward(request, response);
                } 
            else{
                out.println("<font color='red'><b>Usuario y/o password incorrecto</b></font>");
                RequestDispatcher rs = request.getRequestDispatcher("/index.html");
                rs.include(request, response);
                }         
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       processRequest(request, response);                      
        }
}

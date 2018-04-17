/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.AsambleaBusiness;
import business.PreguntasBusiness;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistecia.dto.AsambleaDTO;
import persistecia.dto.PreguntasDTO;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "PreguntasController", urlPatterns = {"/preguntas.do"})
public class PreguntasController extends HttpServlet {

    PreguntasBusiness preguntaBusiness = new PreguntasBusiness();
    AsambleaBusiness asambleBusiness = new AsambleaBusiness();

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

        switch (request.getParameter("action")) {
            case "crear":
                PreguntasDTO preg = new PreguntasDTO();
                preg.setDescripcion(request.getParameter("txtDescripcion"));
                AsambleaDTO asamblea = asambleBusiness.consultarAsambleaPorId(Integer.parseInt(request.getParameter("txtEncuesta")));
                preg.setAsamblea(asamblea);
                preg.setActivo(1);
                preguntaBusiness.crearPreguntas(preg);
                request.getRequestDispatcher("preguntas.do?method=get&&action=consul").forward(request, response);
                break;
            case "consultar":
                List<PreguntasDTO> preguntas = preguntaBusiness.consultarPreguntas(request.getParameter("txtDescripBuscar"));
                request.getSession().setAttribute("Preguntas", preguntas);
                request.getRequestDispatcher("Encuesta/pregunta.jsp").forward(request, response);
                break;
            case "modificar":
                PreguntasDTO pregun = preguntaBusiness.consultarPrePorId(Integer.parseInt(request.getParameter("idPreg")));
                pregun.setDescripcion(request.getParameter("txtDescripcion"));
                AsambleaDTO asambl = asambleBusiness.consultarAsambleaPorId(Integer.parseInt(request.getParameter("txtEncuesta")));
                pregun.setAsamblea(asambl);
                preguntaBusiness.actualizarPreguntas(pregun);
                request.getRequestDispatcher("preguntas.do?method=get&&action=consul").forward(request, response);
                break;
        }

        /*METHOD GET*/
        if ("get".equals(request.getParameter("method"))) {
            switch (request.getParameter("action")) {
                case "consul":
                    List<PreguntasDTO> preguntas = preguntaBusiness.listarPreguntas();
                    request.getSession().setAttribute("Preguntas", preguntas);
                    request.getRequestDispatcher("Encuesta/pregunta.jsp").forward(request, response);
                    break;
                case "consulTipos":
                    List<AsambleaDTO> tipos = asambleBusiness.listarAsambleas();
                    request.getSession().setAttribute("TipoEncuestas", tipos);
                    request.getRequestDispatcher("Encuesta/crearPregunta.jsp").forward(request, response);
                    break;
                case "up"://actualizar
                    PreguntasDTO doc = preguntaBusiness.consultarPrePorId(Integer.parseInt(request.getParameter("code")));
                    request.getSession().setAttribute("Preguntas", doc);
                    List<AsambleaDTO> tiposEn = asambleBusiness.listarAsambleas();
                    request.getSession().setAttribute("Encuestas", tiposEn);
                    request.getRequestDispatcher("Encuesta/modificarPregunta.jsp").forward(request, response);
                    break;
                case "dl"://Eliminar
                    PreguntasDTO pregunta = preguntaBusiness.consultarPrePorId(Integer.parseInt(request.getParameter("code")));
                    preguntaBusiness.cambiarEstadoPre(pregunta);
                    request.getRequestDispatcher("preguntas.do?method=get&&action=consul").forward(request, response);
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

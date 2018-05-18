<%-- 
    Document   : Crear
    Created on : 3/09/2017, 08:20:37 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.TipoAsambleaDTO"%>
<%@page import="persistecia.dao.TipoAsambleaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%  if (request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect("index.html");
    }
    String labelAprob = (String)request.getSession().getAttribute("labelAprob");
    String labelNoAprob = (String)request.getSession().getAttribute("labelNoAprob");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Ejecutar Asamblea</h1></p><br><hr><br></div></div>

          
        <div class="col-md-3">
            <div class="CentrarForm">
                <form id="preguntas" method="post" action="\proyectoGrado\ejecucionAsamblea.do">
                    <input type="hidden" id="action" name="action" value="validarOrden"/>                    
                    <div class="col-md-3">
                        <button type="submit" class="btn btn-default">Validar Orden del Dia</button> 
                        <label style="<%out.print(labelAprob);%>" for="inputEmail3" class="control-label">Orden del dia Aprobada</label>
                        <label style="<%out.print(labelNoAprob);%>" for="inputEmail3" class="control-label">Orden del dia No Aprobada</label>
                    </div>
                </form>                            
            </div>            
        </div>
        
        <div class="col-md-3">
            <div class="CentrarForm">
                <form id="ordenDia" method="post" action="\proyectoGrado\ejecucionAsamblea.do">
                    <input type="hidden" id="action" name="action" value="iniciar"/>                    
                    <div class="col-md-3">
                        <button type="submit" class="btn btn-default">habilitar Preguntas</button>                        
                    </div>
                </form>                            
            </div>
        </div>
        
        <div class="col-md-6 CentrarForm">
            <img src="..\..\proyectoGrado\Content\img\encuesta1.png" class="img-responsive">
        </div>
        <div class="col-md-12"><p></p><br><hr><br></div>
    </body>
</html>

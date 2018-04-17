<%-- 
    Document   : ConsultarEstadoAsamblea
    Created on : 2/04/2018, 11:31:03 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.EstadoAsambleaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%  if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }    
    ArrayList<EstadoAsambleaDTO> estados = null;
    estados = (ArrayList<EstadoAsambleaDTO>) request.getSession().getAttribute("Estados");
%>

<html>
    <body>

        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Listar Estados de Asamblea</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form role="form" method="post" action="\proyectoGrado\estadoAsamblea.do">
                    <input type="hidden" id="action" name="action" value="consultar"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Estado Asamblea</label>
                            <input type="text" class="form-control" id="txtEstadoBuscar" name="txtEstadoBuscar" placeholder="Estado Asamblea">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Buscar</button>
                        <button type="button" class="btn btn-default" onclick="location = 'Configuracion/crearEstadoAsamblea.jsp'">Crear</button>
                    </div>
            </div>
        </form>
    </div>
</div>
<div class="col-md-6 CentrarForm">
    <img src="..\..\proyectoGrado\Content\img\encuesta.png" class="img-responsive"/>
</div>
<div class="col-md-12"><p></p><hr></div>


<%--    if (bandera != null) {
--%>


<div class="col-md-12">
    <div class="container">
        <div class="col-sm-2">
            <a href="Configuracion/estadoAsamblea.jsp" class="btn btn-default ColorFondo1 TextoMenu">Limpiar Resultados</a>
        </div>
        <div class="col-md-12"><p><br></p></div>
        <table class="table">
            <thead class="ColorFondo1 TextoMenu">
                <tr>
                    <th>No</th>
                    <th>Estado</th>
                    <th>Activo</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < estados.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + estados.get(i).getId() + "</td>");
                        out.println("<td>" + estados.get(i).getDescripcion() + "</td>");
                        out.println("<td>" + (estados.get(i).getActivo() == 1 ? "activo" : "inactivo") + "</td>");
                        out.println("<td><a href='estadoAsamblea.do?method=get&&action=up&&code=" + estados.get(i).getId() + "'><i class='fa fa-2x fa-pencil-square-o fa-fw'></i></a><a href='estadoAsamblea.do?method=get&&action=dl&&code=" + estados.get(i).getId() + "'><i class='fa fa-2x fa-exchange fa-fw'></i></a></td>");
                        out.println("</tr>");
                    }
                %>
            </tbody>
        </table>
    </div>
</div>
<div class="col-md-12"><p><br><br><br><br><br></p></div>
</body>
</html>

<%-- 
    Document   : ConsultarTipoDocumento
    Created on : 2/04/2018, 11:31:03 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.PreguntasDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<% 
    if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }
    ArrayList<PreguntasDTO> tipos = null;
    tipos = (ArrayList<PreguntasDTO>) request.getSession().getAttribute("Preguntas");
%>

<html>
    <body>

        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Listar Preguntas</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form role="form" method="post" action="\proyectoGrado\preguntas.do">
                    <input type="hidden" id="action" name="action" value="consultar"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Descripción</label>
                            <input type="text" class="form-control" id="txtDescripBuscar" name="txtDescripBuscar" placeholder="Descripción">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Buscar</button>
                        <button type="button" class="btn btn-default" onclick="location = 'preguntas.do?method=get&&action=consulTipos'">Crear</button>

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
                    <a href="Asamblea/preguntas.jsp" class="btn btn-default ColorFondo1 TextoMenu">Limpiar Resultados</a>
                </div>
                <div class="col-md-12"><p><br></p></div>
                <table class="table">
                    <thead class="ColorFondo1 TextoMenu">
                        <tr>
                            <th>No</th>
                            <th>Descripci&oacute;n</th>
                            <th>Asamblea</th>
                            <th>Estado</th>
                            <th>Acci&oacute;n</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < tipos.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>" + tipos.get(i).getId() + "</td>");
                                out.println("<td>" + tipos.get(i).getDescripcion() + "</td>");
                                out.println("<td>" + tipos.get(i).getAsamblea().getDescripcion()+ "</td>");
                                out.println("<td>" + (tipos.get(i).getActivo() == 1 ? "activo" : "inactivo") + "</td>");
                                out.println("<td><a href='preguntas.do?method=get&&action=up&&code=" + tipos.get(i).getId() + "'><i class='fa fa-2x fa-pencil-square-o fa-fw'></i></a><a href='preguntas.do?method=get&&action=dl&&code=" + tipos.get(i).getId() + "'><i class='fa fa-2x fa-exchange fa-fw'></i></a></td>");
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

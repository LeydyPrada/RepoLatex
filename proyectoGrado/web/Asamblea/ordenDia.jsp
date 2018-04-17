<%-- 
    Document   : ConsultarOrdenDia
    Created on : 2/04/2018, 11:31:03 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.OrdenDiaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%  if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }
    ArrayList<OrdenDiaDTO> ordenesDia = null;
    ordenesDia = (ArrayList<OrdenDiaDTO>) request.getSession().getAttribute("Ordenes");
%>

<html>
    <body>

        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Listar Ordenes del Dia</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form role="form" method="post" action="\proyectoGrado\ordenDia.do">
                    <input type="hidden" id="action" name="action" value="consultar"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Orden</label>
                            <input type="text" class="form-control" id="txtOrdenBuscar" name="txtOrdenBuscar" placeholder="Orden Dia">
                        </div>
                    </div>

                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Buscar</button>
                        <button type="button" class="btn btn-default" onclick="location = 'Asamblea/crearOrdenDia.jsp'">Crear</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-6 CentrarForm">
            <img src="..\..\proyectoGrado\Content\img\tipoDoc.jpg" class="img-responsive">
        </div>
        <div class="col-md-12"><p></p><hr></div>


        <%--    if (bandera != null) {
        --%>


        <div class="col-md-12">
            <div class="container">
                <div class="col-sm-2">
                    <a href="Asamblea/ordenDia.jsp" class="btn btn-default ColorFondo1 TextoMenu">Limpiar Resultados</a>
                </div>
                <div class="col-md-12"><p><br></p></div>
                <table class="table">
                    <thead class="ColorFondo1 TextoMenu">
                        <tr>
                            <th>Id</th>
                            <th>Orden</th>
                            <th>Descripción</th>
                            <th>Activo</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < ordenesDia.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>" + ordenesDia.get(i).getId() + "</td>");
                                out.println("<td>" + ordenesDia.get(i).getOrden() + "</td>");
                                out.println("<td>" + ordenesDia.get(i).getDescripcion() + "</td>");
                                out.println("<td>" + (ordenesDia.get(i).getActivo() == 1 ? "activo" : "inactivo") + "</td>");
                                out.println("<td><a href='ordenDia.do?method=get&&action=up&&code=" + ordenesDia.get(i).getId() + "'><i class='fa fa-2x fa-pencil-square-o fa-fw'></i></a><a href='ordenDia.do?method=get&&action=dl&&code=" + ordenesDia.get(i).getId() + "'><i class='fa fa-2x fa-exchange fa-fw'></i></a></td>");
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

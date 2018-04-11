<%-- 
    Document   : ConsultarInmueble
    Created on : 6/04/2018, 03:00:00 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.InmuebleDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%
    ArrayList<InmuebleDTO> inmuebles = null;
    inmuebles = (ArrayList<InmuebleDTO>) request.getSession().getAttribute("Inmuebles");
%>

<html>
    <body>

        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Listar Inmuebles</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form role="form" method="post" action="\proyectoGrado\inmueble.do">
                    <input type="hidden" id="action" name="action" value="consultar"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Inmueble</label>
                            <input type="text" class="form-control" id="txtInmuBuscar" name="txtInmuBuscar" placeholder="Inmueble">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Buscar</button>
                        <button type="button" class="btn btn-default" onclick="location = 'inmueble.do?method=get&&action=consulTipos'">Crear</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-6 CentrarForm">
            <img src="..\..\proyectoGrado\Content\img\tipoDoc.jpg" class="img-responsive">
        </div>
        <div class="col-md-12"><p></p><hr></div>



        <div class="col-md-12">
            <div class="container">
                <div class="col-sm-2">
                    <a href="Usuario/inmueble.jsp" class="btn btn-default ColorFondo1 TextoMenu">Limpiar Resultados</a>
                </div>
                <div class="col-md-12"><p><br></p></div>
                <table class="table">
                    <thead class="ColorFondo1 TextoMenu">
                        <tr>
                            <th>ID</th>
                            <th>Inmueble</th>
                            <th>Area Total</th>
                            <th>Area Const</th>
                            <th>Area Ponderar</th>
                            <th>Coeficiente</th>
                            <th>Tipo Inmueble</th>
                            <th>Usuario</th>                            
                            <th>Estado</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < inmuebles.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>" + inmuebles.get(i).getId() + "</td>");
                                out.println("<td>" + inmuebles.get(i).getInmueble() + "</td>");
                                out.println("<td>" + inmuebles.get(i).getArea_total() + "</td>");
                                out.println("<td>" + inmuebles.get(i).getArea_construida() + "</td>");
                                out.println("<td>" + inmuebles.get(i).getArea_ponderar() + "</td>");
                                out.println("<td>" + inmuebles.get(i).getCoeficiente() + "</td>");
                                out.println("<td>" + inmuebles.get(i).getTipoInmueble().getTipoInmueble() + "</td>");
                                out.println("<td>" + inmuebles.get(i).getUsuario().getNombre() + " "+ inmuebles.get(i).getUsuario().getApellido() +"</td>");
                                out.println("<td>" + (inmuebles.get(i).getActivo() == 1 ? "activo" : "inactivo") + "</td>");
                                out.println("<td><a href='inmueble.do?method=get&&action=up&&code=" + inmuebles.get(i).getId() + "'><i class='fa fa-2x fa-pencil-square-o fa-fw'></i></a><a href='inmueble.do?method=get&&action=dl&&code=" + inmuebles.get(i).getId() + "'><i class='fa fa-2x fa-exchange fa-fw'></i></a></td>");
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

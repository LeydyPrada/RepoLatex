<%-- 
    Document   : ConsultarTipoDocumento
    Created on : 2/04/2018, 11:31:03 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.TipoDocumentoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%
    ArrayList<TipoDocumentoDTO> tipos = null;
        tipos = (ArrayList<TipoDocumentoDTO>) request.getSession().getAttribute("Tipos");
%>

<html>
    <body>

        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Listar Tipos de Documento</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form class="form-horizontal" role="form" method="post" action="\proyectoGrado\configuracionController">
                    <input type="hidden" id="action" name="action" value="consultar"/>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label for="inputEmail3" class="control-label">Código</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="txtCodigoBuscar" name="txtCodigoBuscar" placeholder="Código">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="col-sm-offset-2 col-sm-1">
                            <button type="submit" class="btn btn-default">Buscar</button>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="col-sm-offset-2 col-sm-1">
                            <button type="button" class="btn btn-default" onclick="location='Configuracion/crearTipoDocumento.jsp'">Crear</button>
                        </div>
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
                    <a href="Configuracion/tipoDocumento.jsp" class="btn btn-default ColorFondo1 TextoMenu">Limpiar Resultados</a>
                </div>
                <div class="col-md-12"><p><br></p></div>
                <table class="table">
                    <thead class="ColorFondo1 TextoMenu">
                        <tr>
                            <th>No</th>
                            <th>Codigo</th>
                            <th>Tipo</th>
                            <th>Activo</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < tipos.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>" + tipos.get(i).getId() + "</td>");
                                out.println("<td>" + tipos.get(i).getCodigo() + "</td>");
                                out.println("<td>" + tipos.get(i).getTipoDocumento()+ "</td>");
                                out.println("<td>" + (tipos.get(i).getActivo() == 1? "activo": "inactivo")+ "</td>");
                                out.println("<td><a href='configuracionController?method=get&&action=up&&code=" + tipos.get(i).getId() + "'><i class='fa fa-2x fa-pencil-square-o fa-fw'></i></a><a href='configuracionController?method=get&&action=dl&&code=" + tipos.get(i).getId() + "'><i class='fa fa-2x fa-exchange fa-fw'></i></a></td>");
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

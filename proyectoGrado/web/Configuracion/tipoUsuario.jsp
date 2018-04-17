<%-- 
    Document   : ConsultarTipoUsuario
    Created on : 6/04/2018, 03:00:00 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.TipoUsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%  if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }    
    ArrayList<TipoUsuarioDTO> tiposUsr = null;
    tiposUsr = (ArrayList<TipoUsuarioDTO>) request.getSession().getAttribute("TipoUsr");
%>

<html>
    <body>

        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Listar Tipos de Usuarios</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form role="form" method="post" action="\proyectoGrado\tipoUsuario.do">
                    <input type="hidden" id="action" name="action" value="consultar"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Tipo</label>
                            <input type="text" class="form-control" id="txtCodigoBuscar" name="txtTipoBuscar" placeholder="Tipo">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Buscar</button>
                        <button type="button" class="btn btn-default" onclick="location = 'Configuracion/crearTipoUsuario.jsp'">Crear</button>
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
                    <a href="Configuracion/tipoDocumento.jsp" class="btn btn-default ColorFondo1 TextoMenu">Limpiar Resultados</a>
                </div>
                <div class="col-md-12"><p><br></p></div>
                <table class="table">
                    <thead class="ColorFondo1 TextoMenu">
                        <tr>
                            <th>Codigo</th>
                            <th>Tipo Usuario</th>
                            <th>Activo</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < tiposUsr.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>" + tiposUsr.get(i).getId() + "</td>");
                                out.println("<td>" + tiposUsr.get(i).getTipo() + "</td>");
                                out.println("<td>" + (tiposUsr.get(i).getActivo() == 1 ? "activo" : "inactivo") + "</td>");
                                out.println("<td><a href='tipoUsuario.do?method=get&&action=up&&code=" + tiposUsr.get(i).getId() + "'><i class='fa fa-2x fa-pencil-square-o fa-fw'></i></a><a href='tipoUsuario.do?method=get&&action=dl&&code=" + tiposUsr.get(i).getId() + "'><i class='fa fa-2x fa-exchange fa-fw'></i></a></td>");
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

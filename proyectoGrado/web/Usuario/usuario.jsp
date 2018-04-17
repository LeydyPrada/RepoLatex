<%-- 
    Document   : ConsultarUsuario
    Created on : 6/04/2018, 03:00:00 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%
    if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }
    
    ArrayList<UsuarioDTO> usuarios = null;
    usuarios = (ArrayList<UsuarioDTO>) request.getSession().getAttribute("Usuarios");
%>

<html>
    <body>

        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Listar Usuarios</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form role="form" method="post" action="\proyectoGrado\usuario.do">
                    <input type="hidden" id="action" name="action" value="consultar"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Nombre</label>
                            <input type="text" class="form-control" id="txtNombreBuscar" name="txtNombreBuscar" placeholder="Nombre">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Buscar</button>
                        <button type="button" class="btn btn-default" onclick="location = 'usuario.do?method=get&&action=consulTipos'">Crear</button>
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
                    <a href="Usuario/usuario.jsp" class="btn btn-default ColorFondo1 TextoMenu">Limpiar Resultados</a>
                </div>
                <div class="col-md-12"><p><br></p></div>
                <table class="table">
                    <thead class="ColorFondo1 TextoMenu">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Dirección</th>
                            <th>Teléfono</th>
                            <th>Genero</th>
                            <th>Email</th>
                            <th>Dirección</th>
                            <th>Usuario</th>
                            <th>Tipo Doc</th>
                            <th>Tipo Usr</th>
                            <th>Estado</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < usuarios.size(); i++) {
                                out.println("<tr>");
                                out.println("<td>" + usuarios.get(i).getId() + "</td>");
                                out.println("<td>" + usuarios.get(i).getNombre() + "</td>");
                                out.println("<td>" + usuarios.get(i).getApellido() + "</td>");
                                out.println("<td>" + usuarios.get(i).getDireccion() + "</td>");
                                out.println("<td>" + usuarios.get(i).getTelefono() + "</td>");
                                out.println("<td>" + usuarios.get(i).getGenero() + "</td>");
                                out.println("<td>" + usuarios.get(i).getEmail() + "</td>");
                                out.println("<td>" + usuarios.get(i).getDireccion() + "</td>");
                                out.println("<td>" + usuarios.get(i).getUsuarioLogin() + "</td>");
                                out.println("<td>" + usuarios.get(i).getTipoDocumento().getCodigo() + "</td>");
                                out.println("<td>" + usuarios.get(i).getTipoUusario().getTipo() + "</td>");
                                out.println("<td>" + (usuarios.get(i).getActivo() == 1 ? "activo" : "inactivo") + "</td>");
                                out.println("<td><a href='usuario.do?method=get&&action=up&&code=" + usuarios.get(i).getId() + "'><i class='fa fa-2x fa-pencil-square-o fa-fw'></i></a><a href='usuario.do?method=get&&action=dl&&code=" + usuarios.get(i).getId() + "'><i class='fa fa-2x fa-exchange fa-fw'></i></a></td>");
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

<%-- 
    Document   : CrearUsuario
    Created on : 06/04/2018, 08:20:37 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.TipoUsuarioDTO"%>
<%@page import="persistecia.dto.TipoDocumentoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%
    ArrayList<TipoUsuarioDTO> tiposUsr = null;
    tiposUsr = (ArrayList<TipoUsuarioDTO>) request.getSession().getAttribute("TipoUsr");    

    ArrayList<TipoDocumentoDTO> tiposDoc = null;
    tiposDoc = (ArrayList<TipoDocumentoDTO>) request.getSession().getAttribute("TiposDoc");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Crear Nuevo Usuario</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\usuario.do">
                    <input type="hidden" id="action" name="action" value="crear"/>
                    <div class="col-md-12">                                           
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Nombre</label>
                            <input type="text" class="form-control" id="txtNombre" name="txtNombre" placeholder="Nombre" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Apellido</label>
                            <input type="text" class="form-control" id="txtApellido" name="txtApellido" placeholder="Apellido" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Dirección</label>
                            <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" placeholder="Direccion" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Teléfono</label>
                            <input type="text" class="form-control" id="txtTelefono" name="txtTelefono" placeholder="Telefono" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Genero</label>
                            <input type="text" class="form-control" id="txtGenero" name="txtGenero" placeholder="Genero" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Email</label>
                            <input type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="Email" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Usuario</label>
                            <input type="text" class="form-control" id="txtLogin" name="txtLogin" placeholder="Usuario Login" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Contraseña</label>
                            <input type="text" class="form-control" id="txtContrasena" name="txtContrasena" placeholder="Contrasena" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Tipo Documento</label>
                            <select class="form-control" id="txtIdTipoDoc" name="txtIdTipoDoc" required>
                                <%
                                    out.println("<option value="+"></option>");
                                    for (int i = 0; i < tiposDoc.size(); i++) {
                                        out.println("<option value=" + tiposDoc.get(i).getId() + ">" + tiposDoc.get(i).getTipoDocumento() + "</option>");
                                    }
                                %>
                            </select>
                        </div>
                            
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Num Identificación</label>
                            <input type="text" class="form-control" id="txtIdUsuario" name="txtIdUsuario" placeholder="Num Identificacion" required>
                        </div>    
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Tipo Usuario</label>
                            <select class="form-control" id="txtIdTipoUsr" name="txtIdTipoUsr" required>
                                <%
                                    out.println("<option value="+"></option>");
                                    for (int i = 0; i < tiposUsr.size(); i++) {
                                        out.println("<option value=" + tiposUsr.get(i).getId() + ">" + tiposUsr.get(i).getTipo() + "</option>");
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Crear</button>
                        <a href="..\usuario.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-6 CentrarForm">
            <img src="..\..\proyectoGrado\Content\img\TipoDocumento.jpg" class="img-responsive">
        </div>
        <div class="col-md-12"><p></p><br><hr><br></div>
    </body>
</html>

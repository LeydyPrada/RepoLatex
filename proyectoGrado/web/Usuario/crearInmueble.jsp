<%-- 
    Document   : CrearUsuario
    Created on : 06/04/2018, 08:20:37 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.UsuarioDTO"%>
<%@page import="persistecia.dto.TipoInmuebleDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%
    ArrayList<UsuarioDTO> usuarios = null;
    usuarios = (ArrayList<UsuarioDTO>) request.getSession().getAttribute("Usr");    

    ArrayList<TipoInmuebleDTO> tiposInmu = null;
    tiposInmu = (ArrayList<TipoInmuebleDTO>) request.getSession().getAttribute("TiposInmu");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Crear Nuevo Inmueble</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\inmueble.do">
                    <input type="hidden" id="action" name="action" value="crear"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Inmueble</label>
                            <input type="text" class="form-control" id="txtInmueble" name="txtInmueble" placeholder="Inmueble" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Area Total</label>
                            <input type="text" class="form-control" id="txtAreaTot" name="txtAreaTot" placeholder="Area Total" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Area Construida</label>
                            <input type="text" class="form-control" id="txtAreaCons" name="txtAreaCons" placeholder="Area Construida" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Area Ponderar</label>
                            <input type="text" class="form-control" id="txtAreaPond" name="txtAreaPond" placeholder="Area Ponderar" required>
                        </div>
                    
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Coeficiente</label>
                            <input type="text" class="form-control" id="txtCoeficiente" name="txtCoeficiente" placeholder="Coeficiente" required>
                        </div>
                                                                   
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Tipo Inmueble</label>
                            <select class="form-control" id="txtIdTipoInm" name="txtIdTipoInm" required>
                                <%
                                    out.println("<option value="+"></option>");
                                    for (int i = 0; i < tiposInmu.size(); i++) {
                                        out.println("<option value=" + tiposInmu.get(i).getId() + ">" + tiposInmu.get(i).getTipoInmueble() + "</option>");
                                    }
                                %>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Usuario</label>
                            <select class="form-control" id="txtIdUsuario" name="txtIdUsuario" required>
                                <%
                                    out.println("<option value="+"></option>");
                                    for (int i = 0; i < usuarios.size(); i++) {
                                        out.println("<option value=" + usuarios.get(i).getId() + ">" + usuarios.get(i).getNombre() + "</option>");
                                    }
                                %>
                            </select>
                        </div>
                                            
                                            
                        
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Crear</button>
                        <a href="..\inmueble.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
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

<%-- 
    Document   : modificar
    Created on : 5/09/2017, 01:22:27 AM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.TipoUsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%  
    if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }    
    TipoUsuarioDTO tipoUsuario = (TipoUsuarioDTO) request.getSession().getAttribute("TipoUsr");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Modificar Tipo de Usuario</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\tipoUsuario.do">
                    <input type="hidden" id="action" name="action" value="modificar"/>
                    <input type="hidden" id="idTipoUsr" name="idTipoUsr" value="<%out.print(tipoUsuario.getId());%>"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Tipo de Usuario</label>
                            <input type="text" class="form-control" id="txtTipoUsr" name="txtTipoUsr" placeholder="Tipo de usuario" required value="<%out.print(tipoUsuario.getTipo());%>">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Modificar</button>
                        <a href="tipoUsuario.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
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

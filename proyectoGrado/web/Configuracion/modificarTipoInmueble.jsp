<%-- 
    Document   : modificar
    Created on : 5/09/2017, 01:22:27 AM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.TipoInmuebleDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%
    if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }
    TipoInmuebleDTO tipoInmueble = (TipoInmuebleDTO) request.getSession().getAttribute("TipoInm");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Modificar Tipo de Usuario</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form class="form-horizontal" method="post" action="\proyectoGrado\tipoInmueble.do">
                    <input type="hidden" id="action" name="action" value="modificar"/>
                    <input type="hidden" id="idTipoUsr" name="idTipoInm" value="<%out.print(tipoInmueble.getId());%>"/>
                    <div class="form-group">
                        <div class="col-sm-5">
                            <label for="inputEmail3" class="control-label">Tipo de Inmueble</label>
                        </div>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="txtTipoUsr" name="txtTipoInm" placeholder="Tipo de usuario" required value="<%out.print(tipoInmueble.getTipoInmueble());%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Modificar</button>
                            <a href="tipoInmueble.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
                        </div>
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

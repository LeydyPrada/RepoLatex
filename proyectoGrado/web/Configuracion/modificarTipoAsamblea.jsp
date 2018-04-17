<%-- 
    Document   : modificar
    Created on : 5/09/2017, 01:22:27 AM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.TipoAsambleaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%  if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }
    TipoAsambleaDTO tipoAsam = (TipoAsambleaDTO) request.getSession().getAttribute("Doc");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Modificar Tipo Asamblea</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\tipoAsamblea.do">
                    <input type="hidden" id="action" name="action" value="modificar"/>
                    <input type="hidden" id="idTipoAsamblea" name="idTipoAsamblea" value="<%out.print(tipoAsam.getId());%>"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Tipo Asamblea</label>
                            <input type="text" class="form-control" id="txtTipo" name="txtTipo" placeholder="Tipo Asamblea" required value="<%out.print(tipoAsam.getTipo());%>">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Modificar</button>
                        <a href="tipoAsamblea.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-md-6 CentrarForm">
            <img src="..\..\proyectoGrado\Content\img\encuesta1.png" class="img-responsive">
        </div>
        <div class="col-md-12"><p></p><br><hr><br></div>
    </body>
</html>

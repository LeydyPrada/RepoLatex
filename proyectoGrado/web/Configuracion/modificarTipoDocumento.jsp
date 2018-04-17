<%-- 
    Document   : modificar
    Created on : 5/09/2017, 01:22:27 AM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.TipoDocumentoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%
    if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }
    TipoDocumentoDTO doc = (TipoDocumentoDTO) request.getSession().getAttribute("Doc");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Modificar Tipo Documento</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\tipoDocumento.do">
                    <input type="hidden" id="action" name="action" value="modificar"/>
                    <input type="hidden" id="idTipoDoc" name="idTipoDoc" value="<%out.print(doc.getId());%>"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Código</label>
                            <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" placeholder="Código" required value="<%out.print(doc.getCodigo());%>">
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Tipo de Documento</label>
                            <input type="text" class="form-control" id="txtTipoDoc" name="txtTipoDoc" placeholder="Tipo de documento" required value="<%out.print(doc.getTipoDocumento());%>">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Modificar</button>
                        <a href="tipoDocumento.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
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

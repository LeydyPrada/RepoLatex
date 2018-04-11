 <%-- 
    Document   : modificar
    Created on : 11/04/2018, 01:22:27 AM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.OrdenDiaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%
    OrdenDiaDTO ordenDia = (OrdenDiaDTO) request.getSession().getAttribute("Orden");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Modificar Orden</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\ordenDia.do">
                    <input type="hidden" id="action" name="action" value="modificar"/>
                    <input type="hidden" id="idOrdenDia" name="idOrdenDia" value="<%out.print(ordenDia.getId());%>"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Orden</label>
                            <input type="text" class="form-control" id="txtOden" name="txtOden" placeholder="Orden" required value="<%out.print(ordenDia.getOrden());%>">
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Descripcion</label>
                            <input type="text" class="form-control" id="txtDescripcion" name="txtDescripcion" placeholder="Descripcion" required value="<%out.print(ordenDia.getDescripcion());%>">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Modificar</button>
                        <a href="ordenDia.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
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

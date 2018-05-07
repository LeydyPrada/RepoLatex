<%-- 
    Document   : Crear
    Created on : 3/09/2017, 08:20:37 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.TipoAsambleaDTO"%>
<%@page import="persistecia.dao.TipoAsambleaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%  if (request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect("index.html");
    }
    ArrayList<TipoAsambleaDTO> tiposUsr = null;
    tiposUsr = (ArrayList<TipoAsambleaDTO>) request.getSession().getAttribute("TipoAsamblea");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Crear Nuevo Encuesta</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\asamblea.do">
                    <input type="hidden" id="action" name="action" value="crear"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Descripción</label>
                            <input type="text" class="form-control" id="txtDescripcion" name="txtDescripcion" placeholder="Descripcion Encuesta" required>

                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Tipo Documento</label>
                            <select class="form-control" id="txtIdTipoDoc" name="txtIdTipoDoc" required>
                                <%
                                    out.println("<option value=" + "></option>");
                                    for (int i = 0; i < tiposUsr.size(); i++) {
                                        out.println("<option value=" + tiposUsr.get(i).getId() + ">" + tiposUsr.get(i).getTipo() + "</option>");
                                    }
                                %>
                            </select>
                        </div>
                        <div>
                            <input type="date" name="fecha">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Crear</button>
                        <a href="asamblea.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
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

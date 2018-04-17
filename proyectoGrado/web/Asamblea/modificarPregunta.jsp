<%-- 
    Document   : modificar
    Created on : 5/09/2017, 01:22:27 AM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.PreguntasDTO"%>
<%@page import="persistecia.dto.AsambleaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%  if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");
    }
    PreguntasDTO pregunta = (PreguntasDTO) request.getSession().getAttribute("Preguntas");
    ArrayList<AsambleaDTO> tipos = (ArrayList<AsambleaDTO>) request.getSession().getAttribute("Encuestas");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Modificar Preguntas</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\preguntas.do">
                    <input type="hidden" id="action" name="action" value="modificar"/>
                    <input type="hidden" id="idTipoDoc" name="idPreg" value="<%out.print(pregunta.getId());%>"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Descripción</label>
                            <input type="text" class="form-control" id="txtDescripcion" name="txtDescripcion" placeholder="Descripcion Pregunta" required value="<%out.print(pregunta.getDescripcion());%>">
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Encuesta</label>
                            <select class="form-control" id="txtTipo" name="txtEncuesta" required>
                                <%
                                    for (int i = 0; i < tipos.size(); i++) {
                                        if (tipos.get(i).getId() == pregunta.getAsamblea().getId()) {
                                            out.println("<option value=" + tipos.get(i).getId() + " selected>" + tipos.get(i).getDescripcion()+ "</option>");
                                        } else {
                                            out.println("<option value=" + tipos.get(i).getId() + ">" + tipos.get(i).getDescripcion()+ "</option>");
                                        }
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Modificar</button>
                        <a href="preguntas.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
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

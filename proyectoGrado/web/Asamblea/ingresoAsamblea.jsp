<%-- 
    Document   : Crear
    Created on : 3/09/2017, 08:20:37 PM
    Author     : USUARIO
--%>

<%@page import="persistecia.dto.OrdenDiaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<%
    if(request.getSession().getAttribute("usuario") == null){
      response.sendRedirect("index.html");   
    }
    String opcionOrden = (String)request.getSession().getAttribute("opcionOrden");
    String opcionRegistro = (String)request.getSession().getAttribute("opcionRegistro");
    String aprobado = (String)request.getSession().getAttribute("btnAprobado");
    String noAprobado = (String)request.getSession().getAttribute("btnNoAprobado");
    String preguntas = (String)request.getSession().getAttribute("btnPreguntas");
    OrdenDiaDTO ordenDia = new OrdenDiaDTO();
    ordenDia = (OrdenDiaDTO) request.getSession().getAttribute("OrdenDia");
%>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12" style="<%out.print(opcionRegistro);%>"><p><h1>Ingresar Asamblea</h1></p><br><hr></div></div>
        <div class="col-md-6" style="<%out.print(opcionRegistro);%>">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\registroAsamblea.do">
                    <input type="hidden" id="action" name="action" value="registrar"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Codigo de Registro</label>
                            <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" placeholder="Codigo Registro" required>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Ingreso</button>
                        <a href="..\tipoAsamblea.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
                    </div>
                </form>
            </div>            
        </div>               
        <div class="col-md-6 CentrarForm" style="<%out.print(opcionRegistro);%>">
            <img src="..\..\proyectoGrado\Content\img\encuesta1.png" class="img-responsive">
        </div>
             
        <div class="col-md-12 CentrarForm" style="<%out.print(opcionOrden);%>">
            <div class="col-md-12 container"><div class="col-md-12"><p><h1>Orden del Dia</h1></p><br></div></div>
            <textarea name="OrdenDia" cols="100" rows="10" readonly="readonly" style="overflow:scroll;">
                <% if(ordenDia == null){out.print(" ");} else {out.print(ordenDia.getDescripcion());}%></textarea>
            <div class="col-md-12"><p></p><br><br></div> 
            <div class="col-md-12">
                <a href="registroAsamblea.do?method=get&&action=votar&&aprob=1" class="btn btn-default" style="<%out.print(aprobado);%>">Aprobado</a>
                <a href="registroAsamblea.do?method=get&&action=votar&&noaprob=1" class="btn btn-default" style="<%out.print(noAprobado);%>">No Aprobado</a>
                <a href="registroAsamblea.do?method=get&&action=votar&&noaprob=1" class="btn btn-default" style="<%out.print(preguntas);%>">Preguntas</a>
            </div>
         <div class="col-md-12"><p></p><br><br></div> 
        </div>
    </body>
</html>

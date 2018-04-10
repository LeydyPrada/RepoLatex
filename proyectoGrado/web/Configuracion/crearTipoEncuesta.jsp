<%-- 
    Document   : Crear
    Created on : 3/09/2017, 08:20:37 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/masterpage.jsp" %>

<html>
    <body>
        <div class="col-md-12"><p><br></p></div>
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Crear Nuevo Tipo de Encuesta</h1></p><br><hr><br></div></div>

        <div class="col-md-6">
            <div class="CentrarForm">
                <form method="post" action="\proyectoGrado\tipoEncuesta.do">
                    <input type="hidden" id="action" name="action" value="crear"/>
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="inputEmail3" class="control-label">Tipo Encuesta</label>
                            <input type="text" class="form-control" id="txtTipo" name="txtTipo" placeholder="Tipo Encuesta" required>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-default">Crear</button>
                        <a href="..\tipoEncuesta.do?method=get&&action=consul" class="btn btn-default">Cancelar</a>
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

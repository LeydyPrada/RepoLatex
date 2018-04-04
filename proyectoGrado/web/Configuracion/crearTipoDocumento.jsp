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
        <div class="col-md-12 container"><div class="col-md-12"><p><h1>Crear Nuevo Tipo de Documento</h1></p><br><hr><br></div></div>


        <div class="col-md-6">
            <div class="CentrarForm">
                <form class="form-horizontal" method="post" action="\proyectoGrado\ConfiguracionController">
                    <input type="hidden" id="action" name="action" value="crear"/>
                    <div class="form-group">
                        <div class="col-sm-5">
                            <label for="inputEmail3" class="control-label">Código</label>
                        </div>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" placeholder="Código" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-5">
                            <label for="inputEmail3" class="control-label">Tipo de Documento</label>
                        </div>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="txtTipoDoc" name="txtTipoDoc" placeholder="Tipo de documento" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-5 col-sm-7">
                            <button type="submit" class="btn btn-default">Crear</button>
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
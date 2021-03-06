<%-- 
    Document   : masterpage
    Created on : 7/09/2017, 06:22:49 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String m_asamblea = (String) request.getSession().getAttribute("m_asamblea");
    String m_orden_dia = (String) request.getSession().getAttribute("m_orden_dia");
    String m_preguntas = (String) request.getSession().getAttribute("m_preguntas");
    String m_usuario = (String) request.getSession().getAttribute("m_usuario");
    String m_inmueble = (String) request.getSession().getAttribute("m_inmueble");
    String m_voto = (String) request.getSession().getAttribute("m_voto");
    String m_tipo_asamblea = (String) request.getSession().getAttribute("m_tipo_asamblea");
    String m_estado_asamblea = (String) request.getSession().getAttribute("m_estado_asamblea");
    String m_tipo_documento = (String) request.getSession().getAttribute("m_tipo_documento");
    String m_tipo_inmueble = (String) request.getSession().getAttribute("m_tipo_inmueble");
    String m_tipo_usuario = (String) request.getSession().getAttribute("m_tipo_usuario");
    String m_ingreso_asamblea = (String)request.getSession().getAttribute("m_ingreso_asamblea");
    String m_ejecucion_asamblea = (String)request.getSession().getAttribute("m_ejecucion_asamblea");
    String menu_asamblea_general = (String) request.getSession().getAttribute("menu_asamblea_general");
    String menu_usuarios = (String) request.getSession().getAttribute("menu_usuarios");
    String menu_configuracion = (String) request.getSession().getAttribute("menu_configuracion");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="..\..\proyectoGrado\Content\css\Style.css" rel="stylesheet" type="text/css">
        <link href="..\..\proyectoGrado\Content\css\General.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <div class="navbar navbar-default navbar-static-top col-md-12 body TextoMenu colorLink colorLista">
            <div class="container col-md-12 body colorLink colorLista">
                <div class="col-md-12 body colorLink colorLista">
                    <div class="navbar-header TextoMenu col-md-4">
                        <button type="button" class="navbar-toggle menuIconResponsive" data-toggle="collapse" data-target="#navbar-ex-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar body"></span>
                            <span class="icon-bar body"></span>
                            <span class="icon-bar body"></span>
                        </button>
                        <div class="col-md-12">
                            <a class="navbar-brand TextoMenu" href="#"><span>AR PERDOMO</span></a>
                        </div>
                    </div>
                    <div class="collapse navbar-collapse TextoMenu col-md-10" id="navbar-ex-collapse">
                        <ul class="nav navbar-nav navbar-right colorLink colorLista">
                            <li><a href="..\..\proyectoGrado\Home.jsp">Home</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-expanded="false" style="<%out.print(menu_asamblea_general);%> text-align:center">Asamblea General<i class="fa fa-caret-down"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <a href="..\..\proyectoGrado\Asamblea\asamblea.jsp" style="<%out.print(m_asamblea);%>">Asamblea</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\ordenDia.do?method=get&&action=consul" style="<%out.print(m_orden_dia);%>">Orden del día</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\preguntas.do?method=get&&action=consul" style="<%out.print(m_preguntas);%>">Preguntas</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\registroAsamblea.do?method=get&&action=ingreso" style="<%out.print(m_ingreso_asamblea);%>">Ingreso Asamblea</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\ejecucionAsamblea.do?method=get&&action=iniciar" style="<%out.print(m_ejecucion_asamblea);%>">Ejecutar Asamblea</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-expanded="false" style="<%out.print(menu_usuarios);%> text-align:center">Usuarios <i class="fa fa-caret-down"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <a href="..\..\proyectoGrado\usuario.do?method=get&&action=consul" style="<%out.print(m_usuario);%>">Usuario</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\inmueble.do?method=get&&action=consul" style="<%out.print(m_inmueble);%>">Inmueble</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Persona\consultar.jsp" style="<%out.print(m_voto);%>">Voto</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-expanded="false" style="<%out.print(menu_configuracion);%> text-align:center">Configuración <i class="fa fa-caret-down"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <a href="..\..\proyectoGrado\tipoAsamblea.do?method=get&&action=consul" style="<%out.print(m_tipo_asamblea);%>">Tipo Asamblea</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\estadoAsamblea.do?method=get&&action=consul" style="<%out.print(m_estado_asamblea);%>">Estado Asamblea</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\tipoDocumento.do?method=get&&action=consul" style="<%out.print(m_tipo_documento);%>">Tipo documento</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\tipoInmueble.do?method=get&&action=consul" style="<%out.print(m_tipo_inmueble);%>">Tipo inmueble</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\tipoUsuario.do?method=get&&action=consul" style="<%out.print(m_tipo_usuario);%>">Tipo usuario</a>
                                    </li>
                                </ul>
                            </li>


                        </ul>
                    </div>
                    <div class="col-md-3">
                        <a class="navbar-brand TextoMenu" href="..\..\proyectoGrado\cerrar.do">Cerrar Sesion</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

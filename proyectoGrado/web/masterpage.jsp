<%-- 
    Document   : masterpage
    Created on : 7/09/2017, 06:22:49 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <div class="navbar-header TextoMenu">
                        <button type="button" class="navbar-toggle menuIconResponsive" data-toggle="collapse" data-target="#navbar-ex-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar body"></span>
                            <span class="icon-bar body"></span>
                            <span class="icon-bar body"></span>
                        </button>
                        <a class="navbar-brand TextoMenu" href="#"><span>AR PERDOMO</span></a>
                    </div>
                    <div class="collapse navbar-collapse TextoMenu" id="navbar-ex-collapse">
                        <ul class="nav navbar-nav navbar-right colorLink colorLista">
                            <li><a href="..\..\proyectoGrado\Home.jsp">Home</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-expanded="false">Asamblea General<i class="fa fa-caret-down"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <a href="..\..\proyectoGrado\Asamblea\Asamblea.jsp">Asamblea</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Asamblea\OrdenDia.jsp">Orden del día</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-expanded="false">Encuestas <i class="fa fa-caret-down"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <a href="..\..\proyectoGrado\Encuesta\Encuesta.jsp">Encuestas</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Encuesta\Preguntas.jsp">Preguntas</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Encuesta\Respuestas.jsp">Respuestas</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-expanded="false">Usuarios <i class="fa fa-caret-down"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <a href="..\..\proyectoGrado\usuario.do?method=get&&action=consul">Usuario</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Persona\consultar.jsp">Inmueble</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Persona\consultar.jsp">Voto</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-expanded="false">Configuración <i class="fa fa-caret-down"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <a href="..\..\proyectoGrado\reservas.do?method=get&&action=consul">Tipo Asamblea</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Configuracion\consultar.jsp">Estado Asamblea</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\configuracionController?method=get&&action=consul">Tipo documento</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Configuracion\consultar.jsp">Tipo encuesta</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Configuracion\consultar.jsp">Tipo inmueble</a>
                                    </li>
                                    <li>
                                        <a href="..\..\proyectoGrado\Configuracion\consultar.jsp">Tipo usuario</a>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

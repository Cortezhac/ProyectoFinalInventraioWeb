<%-- 
    Document   : Agregar
    Created on : 28-jun-2020, 14:56:39
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/Vistas-Parciales/css-js.jspf" %>                
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/Vistas-Parciales/encabezado.jspf" %>        
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-12">
                    <form class="form-horizontal" action="Usuario" method="POST">
                        <input type="hidden" name="accion" value="agregar" />
                        <div class="row">
                            <div class="form-group col-sm-11 col-md-6">
                                <label class="label-info" for="nombre">Nombre</label>
                                <input class="form-control" type="text" name="nombre" value="">
                            </div>
                            <div class="form-group col-sm-11 col-md-6">
                                <label class="label-info" for="nombre">Apellido</label>
                                <input class="form-control" type="text" name="apellido" value="">
                            </div>
                            <div class="form-group col-sm-11 col-md-6">
                                <label class="label-info" for="nombre">Correo</label>
                                <input class="form-control" type="text" name="correo" value="">
                            </div>
                            <div class="form-group col-sm-11 col-md-6">
                                <label class="label-info" for="usuario">Nombre de Usuario</label>
                                <input class="form-control" type="text" name="clave" value="">
                            </div>
                            <div class="form-group col-sm-11 col-md-6">
                                <label class="label-info" for="clave">Contraseña</label>
                                <input class="form-control" type="password" name="clave" value="">
                            </div>
                            <div class="form-group col-sm-11 col-md-6">
                                <label class="label-info" for="tipo">Tipo Usuario</label>
                                <select class="form-control" name="tipo">
                                    <option value="1">Administrador</option>
                                    <option value="0" selected>Cliente</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-11 col-md-6">
                                <label class="label-info" for="estado">Estado Usuario</label>
                                <select class="form-control" name="estado">
                                    <option value="1" selected>Activo</option>
                                    <option value="0">Inactivo</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-11 col-md-6">
                                <label class="label-info" for="pregunta">Pregunta Recuperacion</label>
                                <input class="form-control" type="text" name="pregunta" value="">
                            </div>
                            <div class="form-group col-sm-11 col-md-6">
                                <label class="label-info" for="respuesta">Respuesta de Pregunta</label>
                                <input class="form-control" type="text" name="respuesta" value="">
                            </div>
                        </div>
                        <div class="row justify-content-center">
                            <div class="col-sm-12 col-md-6">
                                <button class="btn btn-success w-100" type="submit">Guardar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

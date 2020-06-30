<%-- 
    Document   : Agregar
    Created on : 24-jun-2020, 2:12:06
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
                <h1>Agregar</h1>
                    <form action="Categorias" method="POST">
                        <input type="hidden" name="accion" value="agregar" />                          
                        <div class="form-group">
                            <label class="label-info" for="nombre">Nombre categoria</label>
                            <input class="form-control" type="text" name="nombre" value="" />
                        </div>
                        <div class="form-group">
                            <label for="estado">Estado Categoria</label>
                            <select name="estado" class="form-control">
                                <option value="1" selected>Disponible</option>
                                <option value="0">No disponible</option>
                            </select>
                        </div>
                        <input class="btn btn-success w-100" type="submit" value="Agregar" />
                    </form> 
                </div>               
            </div>
        </div>
    </body>
</html>

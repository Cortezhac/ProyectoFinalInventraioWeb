<%-- 
    Document   : Eliminar
    Created on : 24-jun-2020, 14:34:58
    Author     : JCH
--%>

<%@page import="Modelos.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="/Vistas-Parciales/encabezado.jspf" %>
        <jsp:useBean id="ListaResultado" scope="session" class="java.util.ArrayList" />
        <div class="container">
            <br><br>
            <h1 class="text-center">Eliminar</h1>
            <br>
            <hr><br>
            <%
            //Llamo al obeto categoria y almceno el valor del array
                Producto pro = (Producto) ListaResultado.get(0);
            %>
            <h5 class="text-center"><b>¿Estas seguro de querer borrar este registro?</b></h5><br>
            <form action="Productos" method="POST">
                <div class="form-group">
                    <input type="text" class="form-control" name="id" value="<%= pro.getId_producto()%>" />
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" disabled name="nombre" value="<%= pro.getNom_producto()%>" />
                </div><br>
                <input type="hidden" name="accion" value="eliminar"/>
                <div class="form-group">
                    <input type="submit" value="Eliminar" class="btn btn-lg btn-primary btn-block">
                </div>
            </form>
        </div>
        <br><br><br>
        <a href="Productos" class="btn btn-danger">Regresar</a>
        <br><br><br>
        <%@include file="/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

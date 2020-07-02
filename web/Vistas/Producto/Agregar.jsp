<%-- 
    Document   : Agregar
    Created on : 24-jun-2020, 14:34:17
    Author     : JCH
--%>
<%@page import="Modelos.Categoria"%>
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
        <div class="container">
            <br><br>
            <h1 class="text-center">Agregar</h1>
            <br>
            <hr>
            <form action="Productos" method="POST">
                <input type="hidden" name="accion" value="agregar" />
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="" />
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripcion</label>
                    <input type="text" class="form-control" name="descripcion" value="" />
                </div>
                <div class="form-group">
                    <label for="stock">Stock</label>
                    <input type="text" class="form-control" name="stock" value="" />
                </div>
                <div class="form-group">
                    <label for="precio">Precio</label>
                    <input type="text" class="form-control" name="precio" value="" />
                </div>
                <div class="form-group">
                    <label for="medida">Unidad de medida</label>
                    <input type="text" name="medida" class="form-control" value="" />
                </div>
                <div class="form-group">
                    <label for="categoria">Categoria</label>
                    <jsp:useBean id="Listar" scope="session" class="java.util.ArrayList"/>
                    <select class="custom-select" name="categoria">
                        <option selected>Seleccione una</option>
                    <% 
                        for(int i = 0; i < Listar.size(); i++ ){
                            Categoria prod = (Categoria) Listar.get(i);

                    %>
                        <option value="<%= prod.getId_categoria() %>"><%= prod.getNom_categoria() %></option>
                    <% 
                        }        
                    %>
                    </select>
                </div>
                <div class="form-group">
                    <label for="estado">Estado</label>
                    <select class="custom-select" name="estado">
                        <option selected value="1">Activo</option>
                        <option value="2">Inactivo</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha de entrada</label>
                    <input type="date" name="fecha" value="" class="form-control" />
                </div><br>
                <div class="form-group">
                    <input type="submit" value="Agregar" class="btn btn-primary btn-lg btn-block"/>
                </div>
            </form>
        </div>
        <br><br><br>
        <a href="Productos" class="btn btn-danger">Regresar</a>
        <br><br><br>
        <%@include file="/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

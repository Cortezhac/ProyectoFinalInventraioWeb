<%-- 
    Document   : Eliminar
    Created on : 24-jun-2020, 12:06:19
    Author     : Admin
--%>

<%@page import="Modelos.Categoria"%>
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
        <jsp:useBean id="ListaEliminar" scope="session" class="java.util.ArrayList"/>
        <%
        Categoria categoria = (Categoria) ListaEliminar.get(0);
        %>
            <div class="container">
                <div class="row justify-content-center mt-4">
                    <div class="col col-md-10 h5">
                        <h1 class="text-center">Eliminar</h1>
                        <hr>
                        <h4 class="text-center">Esta seguro de eliminar</h4>
                    <%
                        String estado = (categoria.getEstado_categoria() == 1)? "Activo" : "Inactivo" ;
                    %>
                    <div class="form-group">
                        <label class="label">Nombre Categoria</label>
                        <input class="form-control" type value="<%=categoria.getNom_categoria()%>" disabled="">
                    </div>
                </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col col-md-10">
                        <a class="btn btn-info w-100" href="Categorias?accion=Eliminar&id=<%=categoria.getId_categoria()%>">Eliminar</a>
                    </div>
                </div>
            </div>
    </body>
</html>

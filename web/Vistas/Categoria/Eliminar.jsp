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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="ListaEliminar" scope="session" class="java.util.ArrayList"/>
        <%
        Categoria categoria = (Categoria) ListaEliminar.get(0);
        %>
        <h1>Hello World!</h1>
        <div>
            <%=categoria.getNom_categoria()%><br>
            <%=categoria.getEstado_categoria()%><br>
        </div>
        <a href="Categorias?accion=Eliminar&id=<%=categoria.getId_categoria()%>">Eliminar</a>
    </body>
</html>

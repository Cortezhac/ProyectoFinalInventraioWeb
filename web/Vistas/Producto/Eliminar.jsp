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
    </head>
    <body>
        <jsp:useBean id="ListaResultado" scope="session" class="java.util.ArrayList" />
        <h1>Hello World! Eliminar</h1>
        <%
            //Llamo al obeto categoria y almceno el valor del array
                Producto pro = (Producto) ListaResultado.get(0);
        %>
                    <form action="Productos" method="POST">
                        <input type="text" name="id" value="<%= pro.getId_producto()%>" />
                        <input type="hidden" name="accion" value="eliminar"/>
                        <td><input type="submit" value="Eliminar"></td>
                    </form>
    </body>
</html>


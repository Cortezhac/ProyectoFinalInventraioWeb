<%-- 
    Document   : Listar
    Created on : 22-jun-2020, 17:28:18
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
        <h1>Categorias</h1>
        <table>
            <thead>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>ESTADO</th>
                <th>ACCIONES</th>
            </thead>
            <tbody>
                
        <jsp:useBean id="Lista" scope="session" class="java.util.ArrayList"/>
        <% 
            for(int i = 0; i < Lista.size(); i++ ){
                Categoria categoria = (Categoria) Lista.get(i);

        %>
        
        <tr>
            <td><%=categoria.getId_categoria()%></td>
            <td><%=categoria.getNom_categoria()%></td>
            <td><%=categoria.getEstado_categoria()%></td>
            <td>
                <a href="#">Eliminar</a>
                <a href="#">Editar</a>
            </td>
        </tr>
        
        <% 
            }        
        %>
            </tbody>
        </table>
    </body>
</html>

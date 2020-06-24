<%-- 
    Document   : Listar
    Created on : 23-jun-2020, 10:16:46
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
        <h1>Categorias</h1>
        <table border="1">
            <thead>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>DESCRIPCION</th>
                <th>STOCK</th>
                <th>PRECIO</th>
                <th>MEDIDA</th>
                <th>ESTADO</th>
                <th>CATEGORIA</th>
                <th>FECHA</th>
                <th>ACCIONES</th>
            </thead>
            <tbody>
                
        <jsp:useBean id="Lista" scope="session" class="java.util.ArrayList"/>
        <% 
            for(int i = 0; i < Lista.size(); i++ ){
                Producto prod = (Producto) Lista.get(i);

        %>
        
        <tr>
            <td><%= prod.getId_producto() %></td>
            <td><%= prod.getNom_producto() %></td>
            <td><%= prod.getDes_producto() %></td>
            <td><%= prod.getStock() %></td>
            <td><%= prod.getPrecio() %></td>
            <td><%= prod.getUnidad_de_medida() %></td>
            <td><%= prod.getEstado_producto() %></td>
            <td><%= prod.getCategoria() %></td>
            <td><%= prod.getFecha_entrada() %></td>
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

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
        <a href="Categorias?accion=AD">Agregar</a>
        <table>
            <thead>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>ESTADO</th>
                <th>ACCIONES</th>
            </thead>
            <tbody>
        <!-- Permite usar la Lista guardada en session  -->
        <jsp:useBean id="Lista" scope="session" class="java.util.ArrayList"/>
        <% 
            // Bucle que extrae todos los valores del array
            for(int i = 0; i < Lista.size(); i++ ){
                // Guarda los valores en el objeto categoria para 
                // estraer mas facilemtne con los getter
                Categoria categoria = (Categoria) Lista.get(i);

        %>
        
        <tr>
            <td><%=categoria.getId_categoria()%></td>
            <td><%=categoria.getNom_categoria()%></td>
            <td><%=categoria.getEstado_categoria()%></td>
            <td>
                <a href="Categorias?accion=E&id=<%=categoria.getId_categoria()%>">Editar</a>
                <a href="#">Eliminar</a>
            </td>
        </tr>
        
        <% 
            }        
        %>
            </tbody>
        </table>
    </body>
</html>

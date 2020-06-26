<%-- 
    Document   : Listar
    Created on : 06-26-2020, 12:25:10 AM
    Author     : isaac
--%>

<%@page import="Modelos.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <a href="Usuario?accion=AD">Agregar</a>
        <table>
            <thead>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>APELLIDO</th>
                <th>CORREO</th>
                <th>USUARIO</th>
                <th>CLAVE</th>
                <th>TIPO</th>
                <th>ESTADO</th>
                <th>PREGUNTA</th>
                <th>RESPUESTA</th>
            </thead>
            <tbody>
        <!-- Permite usar la Lista guardada en session  -->
        <jsp:useBean id="Lista" scope="session" class="java.util.ArrayList"/>
        <% 
            // Bucle que extrae todos los valores del array
            for(int i = 0; i < Lista.size(); i++ ){
                // Guarda los valores en el objeto categoria para 
                // estraer mas facilemtne con los getter
                usuario usuario = (usuario) Lista.get(i);

        %>
        
        <tr>
            <td><%=usuario.getIdusuario()%></td>
            <td><%=usuario.getNombre()%></td>
            <td><%= usuario.getApellido()%></td>
            <td> <%= usuario.getCorreo()%></td>
             <td><%= usuario.getUsuario()%></td>
            <td><%=  usuario.getClave()%></td>
            <td><%= usuario.getTipo()%></td>
            <td><%= usuario.getEstado() %></td>
            <td><%= usuario.getPregunta() %></td>
            <td><%=  usuario.getRespuesta()%></td>
            <td> <> </td>>
            <td>
                <a href="Usuario?accion=E&id=<%=usuario.getIdusuario()%>">Editar</a>
                <a href="Usuario?accion=DEL&id=<%=usuario.getIdusuario()%>">Eliminar</a>
                
                
            </td>
        </tr>
        
        <% 
            }        
        %>
            </tbody>
        </table>
    </body>
</html>
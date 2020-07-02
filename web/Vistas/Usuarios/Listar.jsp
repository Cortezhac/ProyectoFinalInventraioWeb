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
        <%@include file="/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="/Vistas-Parciales/encabezado.jspf" %>
        <div class="container">
            <h1>Usuarios</h1>
            <a href="Usuario?accion=AD" class="btn btn-success">
                <svg class="bi bi-plus-circle" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M8 3.5a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-.5.5H4a.5.5 0 0 1 0-1h3.5V4a.5.5 0 0 1 .5-.5z"/>
                    <path fill-rule="evenodd" d="M7.5 8a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1H8.5V12a.5.5 0 0 1-1 0V8z"/>
                    <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                </svg> Agregar
            </a>
            <a href="GenerarPDF?tabla=Usuario" class="btn btn-info">
                <svg class="bi bi-file-earmark" width="1em"
                    height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                <path
                    d="M4 1h5v1H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V6h1v7a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2z" />
                <path d="M9 4.5V1l5 5h-3.5A1.5 1.5 0 0 1 9 4.5z" />
                </svg> IMPRIMIR
            </a>
        </div>
        <div class="container-fluid mt-4">
            <a href="../Producto/Listar.jsp"></a>
            <table class="table table-responsive mx-2 ">
                <thead class="thead-dark">
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
                    <th>REGISTRADO</th>
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
                    usuario usuarios = (usuario) Lista.get(i);

            %>

            <tr>
                <td><%= usuarios.getIdusuario()%></td>
                <td><%= usuarios.getNombre()%></td>
                <td><%= usuarios.getApellido()%></td>
                <td><%= usuarios.getCorreo()%></td>
                <td><%= usuarios.getUsuario()%></td>
                <td><%= usuarios.getClave().hashCode()%></td>
                <td>
                       <% if(usuarios.getTipo() == 1){%>
                       Administrador
                       <%}else {%>
                       Cliente
                       <%} %>
                </td>
                <td>
                    <% if(usuarios.getTipo() == 1){%>
                    Activo
                    <%}else {%>
                    Inactivo
                    <%} %>                         
                </td>
                <td><%= usuarios.getPregunta() %></td>
                <td><%= usuarios.getRespuesta().hashCode()%></td>
                <td><%= usuarios.getFechaRegistro()%></td>
                <td>
                    <a class="btn btn-warning" href="Usuario?accion=E&id=<%=usuarios.getIdusuario()%>">
                        <svg class="bi bi-pencil-square" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                        </svg> Editar
                    </a>
                    <a class="btn btn-danger" href="Usuario?accion=DEL&id=<%=usuarios.getIdusuario()%>">
                        <svg class="bi bi-trash" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
                            <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
                        </svg> Eliminar
                    </a>
                </td>
            </tr>

            <% 
                }        
            %>
                </tbody>
            </table>            
        </div>
    </body>
</html>
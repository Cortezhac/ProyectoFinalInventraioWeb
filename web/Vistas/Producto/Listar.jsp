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
        <%@include file="/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="/Vistas-Parciales/encabezado.jspf" %>
        <br><br>
        <div class="container">
            <h1>Productos</h1>
            <br><br>
            <a href="Productos?accion=AD" class="btn btn-success">
                <svg class="bi bi-plus-circle" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M8 3.5a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-.5.5H4a.5.5 0 0 1 0-1h3.5V4a.5.5 0 0 1 .5-.5z"/>
                    <path fill-rule="evenodd" d="M7.5 8a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1H8.5V12a.5.5 0 0 1-1 0V8z"/>
                    <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                </svg> Agregar
            </a>
            <a href="GenerarPDF?tabla=Productos" class="btn btn-info">
                <svg class="bi bi-file-earmark" width="1em"
                        height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M4 1h5v1H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V6h1v7a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2z" />
                    <path d="M9 4.5V1l5 5h-3.5A1.5 1.5 0 0 1 9 4.5z" />
                </svg> IMPRIMIR
            </a>
            <table class="table table-hover">
                <thead class="thead-dark">
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
                    String msj = "";
                    if (prod.getEstado_producto() == 1) {
                            msj = "Activo";
                    }else{
                        msj = "Desactivo";
                    }

            %>

            <tr>
                <td><%= prod.getId_producto() %></td>
                <td><%= prod.getNom_producto() %></td>
                <td><%= prod.getDes_producto() %></td>
                <td><%= prod.getStock() %></td>
                <td><%= prod.getPrecio() %></td>
                <td><%= prod.getUnidad_de_medida() %></td>
                <td>
                    <%
                        if(msj == "Activo"){
                        
                    %>
                    <svg class="bi bi-check-circle" style="color: green;" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path fill-rule="evenodd" d="M10.97 4.97a.75.75 0 0 1 1.071 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.236.236 0 0 1 .02-.022z"/>
                    </svg>
                    <%
                        }else{
                        
                    %>
                    <svg class="bi bi-x-circle" style="color: red;" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path fill-rule="evenodd" d="M11.854 4.146a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708-.708l7-7a.5.5 0 0 1 .708 0z"/>
                        <path fill-rule="evenodd" d="M4.146 4.146a.5.5 0 0 0 0 .708l7 7a.5.5 0 0 0 .708-.708l-7-7a.5.5 0 0 0-.708 0z"/>
                    </svg>
                    <%
                        }
                        
                    %>
                </td>
                <td><%= prod.getCategoria() %></td>
                <td><%= prod.getFecha_entrada() %></td>
                <td>
                    <a href="Productos?accion=E&id=<%= prod.getId_producto() %>" class="btn btn-warning">
                        <svg class="bi bi-pencil-square" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                        </svg> Editar
                    </a>
                    <a href="Productos?accion=DE&id=<%= prod.getId_producto() %>" class="btn btn-danger">
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
            <br><br>
        </div>
        <%@include file="/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

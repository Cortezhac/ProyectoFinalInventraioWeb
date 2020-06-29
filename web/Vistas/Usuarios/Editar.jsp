<%-- 
    Document   : Eliminar
    Created on : 28-jun-2020, 10:20:00
    Author     : Admin
--%>

<%@page import="Modelos.usuario"%>
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
        <div class="container">
            <!-- Obtiene los valores de la session          Tipo ArrayList se debe importar -->
            <jsp:useBean id="ListaEditarUsuario" scope="session" class="java.util.ArrayList" />
            <h1>Editar</h1>    
        </div>

        <div class="row container-fluid">
            <div class="col">
                <table class="table table-responsive">
                    <thead class="thead-dark">
                        <th>NOMBRE</th>
                        <th>APELLIDOS</th>
                        <th>CORREO</th>
                        <th>USUARIO</th>
                        <th>CLAVE</th>
                        <th>TIPO</th>
                        <th>ESTADO</th>
                        <th>PREGUNTA</th>
                        <th>RESPUESTA</th>
                        <th></th>
                    </thead>
                    <tbody>
                    <%
                        //Llamo al objeto usuario y almceno el valor del array
                        usuario us = (usuario) ListaEditarUsuario.get(0);
                    %>
                    <form action="Usuario" method="POST">
                        <tr>
                        <input type="hidden" value="<%=ListaEditarUsuario.size()%>"> 
                            <input type="hidden" name="id" value="<%= us.getIdusuario()%>" />
                            <input type="hidden" name="accion" value="UP"/>
                            <td><input class="form-control" type="text" name="nombre" value="<%= us.getNombre()%>" /></td>
                            <td><input class="form-control" type="text" name="apellido" value="<%= us.getApellido()%>" /></td>
                            <td><input class="form-control" type="text" name="correo" value="<%= us.getCorreo() %>" /></td>
                            <td><input class="form-control" type="text" name="usuario" value="<%= us.getUsuario() %>" /></td>
                            <td><input class="form-control" type="password" name="clave" value="<%= us.getClave()%>" /></td>
                            <td>
                                <select class="form-control" name="tipo">
                                    <% if(us.getTipo() == 1){%>
                                    <option value="<%=us.getTipo()%>">Administrador</option>
                                    <option value="0">Cliente</option>
                                    <%}else {%>
                                    <option value="<%=us.getTipo()%>">Cliente</option>
                                    <option value="1">Administrador</option>
                                    <%} %>
                                </select>
                            </td>
                            <td>
                                <select class="form-control" name="estado">
                                    <% if(us.getTipo() == 1){%>
                                    <option value="<%=us.getTipo()%>">Activo</option>
                                    <option value="0">Inactivo</option>
                                    <%}else {%>
                                    <option value="<%=us.getTipo()%>">Inactivo</option>
                                    <option value="1">Activo</option>
                                    <%} %>                                
                                </select>
                            </td>
                            <td><input class="form-control" type="text" name="pregunta" value="<%= us.getPregunta() %>" /></td>
                            <td><input class="form-control" type="text" name="respuesta" value="<%= us.getRespuesta()  %>" /></td>
                            <td><input class="btn btn-success" type="submit" value="Actualizar"></td>
                        </tr>
                    </form>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>

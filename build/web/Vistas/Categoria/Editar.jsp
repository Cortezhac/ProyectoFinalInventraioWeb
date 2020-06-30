<%-- 
    Document   : Eliminar
    Created on : 23-jun-2020, 11:35:43
    Author     : Admin
--%>

<%@page import="java.lang.Object"%>
<%@page import="Modelos.Categoria"%>
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
        <!-- Obtiene los valores de la session          Tipo ArrayList se debe importar -->
        <jsp:useBean id="ListaResultado" scope="session" class="java.util.ArrayList" />

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-10">
                    <h1>Editar</h1>
                    <br/>
                    <table class="table table-responsive">
                        <thead  class="thead-dark">
                            <th>NOMBRE</th>
                            <th>ESTADO</th>
                            <th></th>
                        </thead>
                        <tbody>
                        <%
                            //Llamo al obeto categoria y almceno el valor del array
                            Categoria cat = (Categoria) ListaResultado.get(0);
                        %>
                        <tr>
                        <form action="Categorias" method="POST">
                            <input type="hidden" name="id" value="<%= cat.getId_categoria()%>" />
                            <input type="hidden" name="accion" value="UP"/>
                            <td><input class="form-control" type="text" name="nombre" value="<%=cat.getNom_categoria()%>" /></td>
                            <td>
                                <select class="form-control" name="estado">
                                    <% 
                                    if(cat.getEstado_categoria() == 1){
                                    %>
                                    <option value="1" selected>Disponible</option>
                                    <option value="0">No disponible</option> 
                                    <%} else{%>
                                    <option value="1">Disponible</option>
                                    <option value="0" selected>No disponible</option> 
                                    <% } %>
                                </select>
                            </td>
                            <td><input class="btn btn-success" type="submit" value="Actualizar"></td>
                        </form>
                        </tr>
                        </tbody>
                    </table>
                    <br>
                    <a href="Categorias" class="btn btn-primary">Regresar</a>
                </div>
            </div>
        </div>
    </body>
</html>

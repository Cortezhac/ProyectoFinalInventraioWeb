<%-- 
    Document   : Eliminar
    Created on : 23-jun-2020, 11:35:43
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
        <!-- Obtiene los valores de la session          Tipo ArrayList se debe importar -->
        <jsp:useBean id="ListaResultado" scope="session" class="java.util.ArrayList" />
        <h1>Editar</h1>

        <div class="row">
            <div class="col">
                <table>
                    <thead>
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
                        <input type="hidden" name="accion" vale="UP"/>
                        <td><input type="text" name="nombre" value="<%=cat.getNom_categoria()%>" /></td>
                        <td><input type="text" name="estado" value="<%=cat.getEstado_categoria()%>" /></td>
                        <td><input type="submit" value="Actualizar"></td>
                    </form>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

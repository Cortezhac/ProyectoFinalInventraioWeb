<%-- 
    Document   : Editar
    Created on : 24-jun-2020, 14:34:38
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
        <!-- Obtiene los valores de la session          Tipo ArrayList se debe importar -->
        <jsp:useBean id="ListaResultado" scope="session" class="java.util.ArrayList" />
        <h1>Editar</h1>

        <div class="row">
            <div class="col">
                <table>
                    <thead>
                        <th>NOMBRE</th>
                        <th>DESCRIPCION</th>
                        <th>STOCK</th>
                        <th>PRECIO</th>
                        <th>MEDIDA</th>
                        <th>ESTADO</th>
                        <th>CATEGORIA</th>
                        <th>FECHA</th>
                        <th></th>
                    </thead>
                    <tbody>
                    <%
                        //Llamo al obeto categoria y almceno el valor del array
                        Producto pro = (Producto) ListaResultado.get(0);
                    %>
                    <tr>
                    <form action="Productos" method="POST">
                        <input type="hidden" name="id" value="<%= pro.getId_producto()%>" />
                        <input type="hidden" name="accion" value="UP"/>
                        <td><input type="text" name="nombre" value="<%= pro.getNom_producto()%>" /></td>
                        <td><input type="text" name="descripcion" value="<%= pro.getDes_producto() %>" /></td>
                        <td><input type="text" name="stock" value="<%= pro.getStock() %>" /></td>
                        <td><input type="text" name="precio" value="<%= pro.getPrecio() %>" /></td>
                        <td><input type="text" name="medida" value="<%= pro.getUnidad_de_medida() %>" /></td>
                        <td><input type="text" name="categoria" value="<%= pro.getCategoria() %>" /></td>
                        <td><input type="text" name="estado" value="<%= pro.getEstado_producto()%>" /></td>
                        <td><input type="text" name="fecha" value="<%= pro.getFecha_entrada() %>" /></td>
                        <td><input type="submit" value="Actualizar"></td>
                    </form>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>


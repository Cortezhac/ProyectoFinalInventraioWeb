<%-- 
    Document   : Editar
    Created on : 24-jun-2020, 14:34:38
    Author     : JCH
--%>
<%@page import="Modelos.Producto"%>
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
            <br><br>
            <h1 class="text-center">Editar</h1>
            <br>
            <hr>
            <div class="row">
                <div class="container">
                    <table class="table table-responsive">
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
                        <form action="Productos" method="POST" class="form-group" >
                            <input type="hidden" name="id" value="<%= pro.getId_producto()%>" />
                            <input type="hidden" name="accion" value="UP"/>
                            <td><input type="text" class="form-control" name="nombre" value="<%= pro.getNom_producto()%>" /></td>
                            <td><input type="text" class="form-control" name="descripcion" value="<%= pro.getDes_producto() %>" /></td>
                            <td><input type="text" class="form-control" name="stock" value="<%= pro.getStock() %>" /></td>
                            <td><input type="text" class="form-control" name="precio" value="<%= pro.getPrecio() %>" /></td>
                            <td><input type="text" class="form-control" name="medida" value="<%= pro.getUnidad_de_medida() %>" /></td>
                            <td>
                                <jsp:useBean id="Listar" scope="session" class="java.util.ArrayList"/>
                                <select class="custom-select" name="categoria">
                                    <option selected>Seleccione una</option>
                                <% 
                                    for(int i = 0; i < Listar.size(); i++ ){
                                        Categoria prod = (Categoria) Listar.get(i);

                                %>
                                    <option value="<%= prod.getId_categoria() %>"><%= prod.getNom_categoria() %></option>
                                <% 
                                    }        
                                %>
                                </select>

                            </td>
                            <td><input type="text" class="form-control" name="estado" value="<%= pro.getEstado_producto()%>" /></td>
                            <td><input type="text" class="form-control" name="fecha" value="<%= pro.getFecha_entrada() %>" /></td>
                            <br>
                            <div class="form-group">
                                <input type="submit" value="Actualizar" class="btn btn-primary btn-lg btn-block"/>
                            </div>
                        </form>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <br><br><br>
        <a href="Productos" class="btn btn-danger">Regresar</a>
        <br><br><br>
        <%@include file="/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

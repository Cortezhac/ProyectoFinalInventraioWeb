<%-- 
    Document   : Agregar
    Created on : 24-jun-2020, 14:34:17
    Author     : JCH
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="Productos" method="POST">
            <input type="hidden" name="accion" value="agregar" />
            <div>
                <label>Nombre</label>
                <input type="text" name="nombre" value="" />
            </div>
            <div>
                <label>Descripcion</label>
                <input type="text" name="descripcion" value="" />
            </div>
            <div>
                <label>Stock</label>
                <input type="text" name="stock" value="" />
            </div>
            <div>
                <label>Precio</label>
                <input type="text" name="precio" value="" />
            </div>
            <div>
                <label>Unidad de medida</label>
                <input type="text" name="medida" value="" />
            </div>
            <div>
                <label>Categoria</label>
                <input type="text" name="categoria" value="" />
            </div>
            <div>
                <label>Estado</label>
                <input type="text" name="estado" value="1" />
            </div>
            <div>
                <label>Fecha de entrada</label>
                <input type="date" name="fecha" value="" />
            </div>
            <div>
                <input type="submit" value="Agregar" />
            </div>
        </form>
    </body>
</html>

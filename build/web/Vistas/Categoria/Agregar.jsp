<%-- 
    Document   : Agregar
    Created on : 24-jun-2020, 2:12:06
    Author     : Admin
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
        <form action="Categorias" method="POST">
            <input type="hidden" name="accion" value="agregar" />
            <input type="text" name="nombre" value="" />
            <input type="text" name="estado" value="1" />
            <input type="submit" value="Agregar" />
        </form>
    </body>
</html>

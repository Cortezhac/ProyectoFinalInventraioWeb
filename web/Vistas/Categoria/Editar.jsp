<%-- 
    Document   : Eliminar
    Created on : 23-jun-2020, 11:35:43
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
        <jsp:useBean id="ListaResultado" scope="session" class="java.util.ArrayList" />
        <h1>Editar</h1>
        <%=ListaResultado.size() %>
        <div class="row">
            <div class="col">
                <table>
                    <thead>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>ESTADO</th>
                    </thead>
                    <tbody>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

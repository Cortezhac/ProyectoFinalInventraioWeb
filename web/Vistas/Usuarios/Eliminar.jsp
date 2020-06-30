<%-- 
    Document   : Eliminar
    Created on : 28-jun-2020, 17:52:23
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
        <jsp:useBean id="ListaResultado" scope="session" class="java.util.ArrayList" />
            <div class="container">
                <% 
                    usuario Usuario = (usuario) ListaResultado.get(0);
                %>
                <div class="row justify-content-center mt-4">
                    <div class="col col-md-10 h5">
                        <h1 class="text-center">Eliminar</h1>
                        <hr>
                        <h4 class="text-center">Esta seguro de eliminar</h4>
                   
                    <div class="form-group">
                        <label class="label">Nombre Usuario</label>
                        <input class="form-control" type value="<%=Usuario.getUsuario()%>" disabled="">
                    </div>
                </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col col-md-10">
                        <a class="btn btn-info w-100" href="Usuario?accion=Eliminar&id=<%=Usuario.getIdusuario()%>">Eliminar</a>
                    </div>
                </div>
            </div>
    </body>
</html>

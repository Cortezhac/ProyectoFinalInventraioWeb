<%-- 
    Document   : index
    Created on : 21-jun-2020, 19:48:15
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
       <%
           request.getRequestDispatcher("index").forward(request, response);
       %>
    </body>
</html>

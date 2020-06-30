<%-- 
    Document   : Recuperar
    Created on : 29-jun-2020, 18:35:29
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
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-8 mt-4">
                    <h2 class="text-center">Recuperar contraseña</h2>
                    <hr>
                    <% 
                    String action = "/ProyectoFinalInventraioWeb/Login";
                    String accion = "recovery";
                    String cambio = "no";
                    String cambioSalida;
                    String preguntar = ""; 
                    String respuestaBD = "";
                    String correo2  = "";

                    %>
                    <form class="form-horizontal" action="/ProyectoFinalInventraioWeb/Login" method="POST">
                        <div class="form-group">
                            <%
                                preguntar = String.valueOf(request.getAttribute("obetenerPregunta"));
                                if(preguntar.equalsIgnoreCase("simon")){
                                    accion = "preguntar";
                                    cambio = "si";
                                    usuario User = (usuario) request.getAttribute("DatosUsuario");
                                    out.print("<span class='text-center'>" + User.getPregunta() + "?</span>");
                            %>
                            <input type="hidden" name="correo" value="<%=User.getCorreo()%>">
                            <input type="hidden" name="accion" value="Comparar">
                            <% 
                            }else{ %>
                            <input type="hidden" name="accion" value="buscarUsuario">
                          <%}
                            %>
                            <label class="label" for="<%=cambioSalida = (cambio.equalsIgnoreCase("si"))? "respuesta" : "correo"%>">Introduce tu <%=cambioSalida = (cambio.equalsIgnoreCase("si"))? "respuesta" : "correo"%></label>
                            <input class="form-control" type="<%=cambioSalida = (cambio.equalsIgnoreCase("si"))? "text" : "email"%>" name="<%=cambioSalida = (cambio.equalsIgnoreCase("si"))? "respuesta" : "correo"%>" placeholder="<%=cambioSalida = (cambio.equalsIgnoreCase("si"))? "respuesta" : "correo@example.com"%>">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-info w-100" type="submit">Procesar</button>
                        </div>
                    </form>
                        <% 
                            usuario Usergetdata = (usuario) request.getAttribute("datosRecuperados");
                            if(Usergetdata != null){
                                if(Usergetdata.getClave().length() > 0){                                
                        %>
                                <div class="row justify-content-center">
                                    <div class="col-sm-12 col-md-8 ">
                                        <div class="form-control  text-center">Usuario: <%=Usergetdata.getUsuario()%></div>
                                        <div class="form-control  text-center">Clave: <%=Usergetdata.getClave()%></div>
                                    </div>
                                </div>
                                <div class="row justify-content-center mt-2">
                                    <div class="col-sm-12 col-md-2">
                                        <a class="btn btn-success w-100" href="/ProyectoFinalInventraioWeb/Login">Login</a>
                                    </div>
                                </div>
                        <%
                                }
                            }
                        %>
                </div>
            </div>
        </div>
    </body>
</html>

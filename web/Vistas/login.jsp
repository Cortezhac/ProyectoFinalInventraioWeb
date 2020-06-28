<%@page import="Modelos.usuario" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <%@include file="../Vistas-Parciales/login.jspf" %>
    <body>
        <div class="container">
        <div class="row">
            <div class="col-md-5 mx-auto">
                <div id="first">
                    <div class="myform form ">
                        <div class="logo mb-3">
                            <div class="col-md-12 text-center">
                                <h1>Iniciar sesión</h1>
                            </div>
                        </div>

                        <form action="" method="post" name="login" action="Usuario">
                            <div class="form-group">
                                <label for="usuario">Nombre Usuario</label>
                                <input type="usuario" name="txtUsuario" class="form-control" id="usuario"
                                    aria-describedby="usuario" placeholder="Digita tu usuario" >
                            </div>
                            <div class="form-group">
                                <label for="clave">Contraseña</label>
                                <input type="password" name="txtContra" id="clave" class="form-control"
                                    aria-describedby="emailHelp" placeholder="Digita tu clave" >
                            </div>

                            <div class="col-md-12 text-center "> 
                                <button type="submit" name="btnIniciar" class=" btn btn-block mybtn btn-primary tx-tfm">Iniciar</button>
                            </div>
                            <div class="col-md-12 ">
                                <div class="login-or">
                                    <hr class="hr-or">
                                    <span class="span-or">Hey</span>
                                </div>
                            </div>
                            <div class="col-md-12 mb-3">
                                <p class="text-center">
                                    <a href="" class="google btn mybtn"><i class="fa fa-google-plus">
                                        </i> Olvidaste tu contraseña_?
                                    </a>
                                </p>
                            </div>
                        </form>
                        
                        <%
                            HttpSession sesion = request.getSession();
                            
                             List<usuario> datos = new ArrayList<usuario>();
                            if(request.getAttribute("fail")!=null){
                                out.print("<script>alert('Usuario o contra erroneos!');</script> ");
                            }
                            if(request.getAttribute("datos")!=null){
                                datos = (List<usuario>)request.getAttribute("datos");
                                String nombre = "";
                                int tipo = 0;
                                for(usuario u : datos ){
                                    nombre = u.getNombre();
                                    tipo = u.getTipo();
                                }
                                sesion.setAttribute("usuario", nombre);
                                sesion.setAttribute("tipo", tipo);
                                response.sendRedirect("../index.jsp");
                            }
                            if(request.getParameter("cerrar")!=null){
                                sesion.invalidate();
                                response.sendRedirect("login.jsp");
                            }
                        %>

                     
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

    </body>
</html>



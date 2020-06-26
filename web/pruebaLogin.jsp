<%-- 
    Document   : pruebaLogin
    Created on : 06-26-2020, 12:20:40 AM
    Author     : Ernesto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <%@include file="/Vistas-Parciales/login.jspf" %>
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

                        <form action="" method="post" name="login">
                            <div class="form-group">
                                <label for="usuario">Nombre Usuario</label>
                                <input type="usuario" name="usuario" class="form-control" id="usuario"
                                    aria-describedby="usuario" placeholder="Digita tu usuario" required>
                            </div>
                            <div class="form-group">
                                <label for="clave">Contraseña</label>
                                <input type="password" name="clave" id="clave" class="form-control"
                                    aria-describedby="emailHelp" placeholder="Digita tu clave" required>
                            </div>

                            <div class="col-md-12 text-center ">
                                <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Iniciar</button>
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

                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

    </body>
</html>

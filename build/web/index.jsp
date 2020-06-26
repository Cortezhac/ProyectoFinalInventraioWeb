<%-- 
    Document   : index
    Created on : 06-14-2020, 10:47:46 PM
    Author     : Ernesto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Inventario</title> 
        <%@include file="/Vistas-Parciales/css-js.jspf" %>
    </head>
    <body>
        <!-- Vista parcial de la parte superior de nuestra aplicacion-->
        <%@include file="/Vistas-Parciales/encabezado.jspf" %>
        <div class="container">
            <br><br>
            <h1 class="text-center"><b>Bienvenido</b></h1>
            <br>
            <hr>
            <div class="row">
                <div class="col-lg-3 shadow p-3 mb-5 bg-white rounded efecto">
                    <center>
                        <svg class="bi bi-person rounder-circle img-rounded" width="140" height="140" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                        </svg>
                    </center><br>
                    <div class="no">
                        <h3 class="text-center">Usuario</h3>
                    </div>
                    <div class="no">
                        <p class="text-justify">
                            Los usuarios son los que tienen derecho a manipular el sistema
                        </p>
                        <a href="Usuario" class="btn btn-info btn-lg btn-block">Ir </a>
                    </div>
                </div>
                <div class="col-lg-1"></div>
                <div class="col-lg-3 shadow p-3 mb-5 bg-white rounded efecto">
                    <center>
                        <svg class="bi bi-bookmark-plus" width="140" height="140" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M4.5 2a.5.5 0 0 0-.5.5v11.066l4-2.667 4 2.667V8.5a.5.5 0 0 1 1 0v6.934l-5-3.333-5 3.333V2.5A1.5 1.5 0 0 1 4.5 1h4a.5.5 0 0 1 0 1h-4zm9-1a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1H13V1.5a.5.5 0 0 1 .5-.5z"/>
                            <path fill-rule="evenodd" d="M13 3.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0v-2z"/>
                        </svg>
                    </center><br>
                    <div class="no">
                        <h3 class="text-center">Categoria</h3>
                    </div>
                    <div class="no">
                        <p class="text-justify">
                            Las categorias permiten clasificar a los productos facilitando su busqueda
                        </p>
                        <a href="Categorias" class="btn btn-info btn-lg btn-block">Ir </a>
                    </div>
                </div>
                <div class="col-lg-1"></div>
                <div class="col-lg-3 shadow p-3 mb-5 bg-white rounded efecto">
                    <center>
                        <svg class="bi bi-box-seam" width="140" height="140" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M8.186 1.113a.5.5 0 0 0-.372 0L1.846 3.5l2.404.961L10.404 2l-2.218-.887zm3.564 1.426L5.596 5 8 5.961 14.154 3.5l-2.404-.961zm3.25 1.7l-6.5 2.6v7.922l6.5-2.6V4.24zM7.5 14.762V6.838L1 4.239v7.923l6.5 2.6zM7.443.184a1.5 1.5 0 0 1 1.114 0l7.129 2.852A.5.5 0 0 1 16 3.5v8.662a1 1 0 0 1-.629.928l-7.185 2.874a.5.5 0 0 1-.372 0L.63 13.09a1 1 0 0 1-.63-.928V3.5a.5.5 0 0 1 .314-.464L7.443.184z"/>
                        </svg>
                    </center><br>
                    <div class="no">
                        <h3 class="text-center">Producto</h3>
                    </div>
                    <div class="no">
                        <p class="text-justify">
                            Los productos son los bienes que estan registrados en este sistema
                        </p>
                        <a href="Productos" class="btn btn-info btn-lg btn-block">Ir </a>
                    </div>
                </div>
            </div>
        </div>
        <br><br><br><br>
        <%@include file="/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

<%-- 
    Document   : BaseTablas
    Created on : 06-24-2020, 12:36:35 AM
    Author     : Ernesto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Table</title>
    </head>
    <body> 
    <br>
    
    <div class="container">
        <h1>Categorias</h1>
        <div class="d-flex justify-content-end">
            <button href="" type="button" class="btn btn-warning"><svg class="bi bi-file-earmark" width="1em"
                    height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M4 1h5v1H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V6h1v7a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2z" />
                    <path d="M9 4.5V1l5 5h-3.5A1.5 1.5 0 0 1 9 4.5z" />
                </svg> IMPRIMIR</button>
        </div>
    </div>

<br>
    <table class="responsive">
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr align="center">

                    <th scope="col">NOMBRE</th>
                    <th scope="col">APELLIDO</th>
                    <th scope="col">CORREO</th>
                    <th scope="col">USUARIO</th>
                    <th scope="col">TIPO</th>
                    <th scope="col">ESTADO</th>
                    <th scope="col">CORREO</th>
                    <th scope="col">ACCIONES</th>
                </tr>
            </thead>
            <tbody align="center">
                <tr>
                    <td>ACA CODE</td>
                    <td>ACA CODE</td>
                    <td>ACA CODE</td>
                    <td>@ACA CODE</td>
                    <td>ACA CODE</td>
                    <td>ACA CODE</td>
                    <td>@ACA CODE</td>
                    <td>
                        <button href="view" type="button" class="btn btn-success"><svg class="bi bi-pencil-square"
                                width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor"
                                xmlns="http://www.w3.org/2000/svg">
                                <path
                                    d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                                <path fill-rule="evenodd"
                                    d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                            </svg></button>
                        <button href="" type="button" class="btn btn-danger"><svg class="bi bi-trash" width="1em"
                                height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path
                                    d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
                                <path fill-rule="evenodd"
                                    d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
                            </svg></button>
                    </td>
                </tr>
               
            </tbody>
        </table>
    </table>
    </body>
</html>





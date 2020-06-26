<%-- 
    Document   : acercade
    Created on : 06-25-2020, 10:43:57 PM
    Author     : Ernesto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acerca de</title>
    </head>
     <%@include file="/Vistas-Parciales/acercade.jspf" %>
    <%@include file="/Vistas-Parciales/css-js.jspf" %>
    
    <body>
        <%@include file="/Vistas-Parciales/encabezado.jspf" %>
    <div class="todo">

        <div class="container">
        <center><img src="https://www.itca.edu.sv/wp-content/themes/elaniin-itca/images/logoColor.png" alt="" class="img-fluid"
                     srcset=""></center></div>
        <br>
        <hr>
        <div class="carrera">
            
            <div class="container"><center>
                <h2 id="master-text">Técnico en ingeniería de sistemas informáticos</h2>
            </center></div>
          

        </div>
<hr>

        <br>
        <div class="container">



            <div class="row">

                <div class="col-md-3">
                    <div class="card profile-card-1">
                        <img src="https://images.pexels.com/photos/946351/pexels-photo-946351.jpeg?w=500&h=650&auto=compress&cs=tinysrgb"
                            alt="profile-sample1" class="background" />
                        <img src="img/4.jpeg" alt="profile-image" class="profile" />
                        <div class="card-content">
                            <h2>Irvin Cortez<small>Scrum Master</small></h3>
                                <div class="icon-block"><a href="#"><i class="fa fa-facebook"></i></a><a href="#">
                                        <i class="fa fa-twitter"></i></a><a href="#"> <i
                                            class="fa fa-google-plus"></i></a>
                                </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card profile-card-1">
                        <img src="https://images.pexels.com/photos/946351/pexels-photo-946351.jpeg?w=500&h=650&auto=compress&cs=tinysrgb"
                            alt="profile-sample1" class="background" />
                        <img src="img/1.jpg" alt="profile-image" class="profile" />
                        <div class="card-content">
                            <h2>Ernesto Acevedo<small>Analista</small></h3>
                                <div class="icon-block"><a href="#"><i class="fa fa-facebook"></i></a><a href="#">
                                        <i class="fa fa-twitter"></i></a><a href="#"> <i
                                            class="fa fa-google-plus"></i></a>
                                </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card profile-card-1">
                        <img src="https://images.pexels.com/photos/946351/pexels-photo-946351.jpeg?w=500&h=650&auto=compress&cs=tinysrgb"
                            alt="profile-sample1" class="background" />
                        <img src="img/2.jpg" alt="profile-image" class="profile" />
                        <div class="card-content">
                            <h2>Josué Chorro<small>Dev Backend</small></h3>
                                <div class="icon-block"><a href="#"><i class="fa fa-facebook"></i></a><a href="#">
                                        <i class="fa fa-twitter"></i></a><a href="#"> <i
                                            class="fa fa-google-plus"></i></a>
                                </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="card profile-card-1">
                        <img src="https://images.pexels.com/photos/946351/pexels-photo-946351.jpeg?w=500&h=650&auto=compress&cs=tinysrgb"
                            alt="profile-sample1" class="background" />
                        <img src="img/3.jpg" alt="profile-image" class="profile" />
                        <div class="card-content">
                            <h2>Isaac Galvez<small>Diseñador</small></h3>
                                <div class="icon-block"><a href="#"><i class="fa fa-facebook"></i></a><a href="#">
                                        <i class="fa fa-twitter"></i></a><a href="#"> <i
                                            class="fa fa-google-plus"></i></a>
                                </div>
                        </div>
                    </div>
                </div>
            </div>


            <br><br>
            <center>
                <h2 class="nigga">Módulo: </h2>
            <h3>Selección de Técnicas de Ingeniería de Software</h3>
            </center>

            <br><br>
            <center>
                <h2 class="nigga">Facilitador: </h2>
            <h3>Manuel de Jesús Gámez López</h3>
            </center>

            <br><br><br><br>
            <center>
                <div class="espa">
                    <h5>"Canta en tus momentos alegres y de tristeza"</h5>
                </div>
            </center>
        </div>

    </body>
     <%@include file="/Vistas-Parciales/pie.jspf" %>
     <script>
    //type writer
    var text = document.getElementById("master-text");
    var str = text.innerHTML;

    text.innerHTML = "";

    var speed = 100;
    var i = 0;

    //Aqui va el efecto type
    function typeWriter() {
        if (i < str.length) {
            text.innerHTML += str.charAt(i);
            i++;
            setTimeout(typeWriter, speed);
        }
    }

    setTimeout(typeWriter, speed);
</script>
</html>

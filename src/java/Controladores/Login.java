/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.loginDAO;
import Modelos.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
       }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        if(opcion != null){
            HttpSession session = request.getSession();
            session.invalidate();
        }
        request.getRequestDispatcher("Vistas/login.jsp").forward(request, response);
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String accion = request.getParameter("accion");
            String boton = request.getParameter("btnIniciar");
            String usuario = "";
            String clave = "";
            if(accion != null && boton!= null){
                loginDAO dao = new loginDAO();
                System.out.println("Boton " + boton);
                System.out.println("Accion " + accion);
                usuario = request.getParameter("txtUsuario");
                clave = request.getParameter("txtContra");
                
                System.out.println("Nombre usuario + " + usuario);
                System.out.println("Clave usuario + " + clave);
                List<usuario> datos = new ArrayList<usuario>();
                datos = dao.accesar(usuario, clave);

                if(datos.size() > 0){
                //================================================================
                usuario us = datos.get(0);// Extraer para probar si la salida es correcta
                System.out.println("Info salida user");
                System.out.println("Usuario bd " + us.getUsuario());
                System.out.println("Nombre bd " + us.getNombre());
                System.out.println("Tipo bd " + us.getTipo());
                //================================================================
                    System.out.println("Usuario encontrado");
                    // hay datos creamos la sesion
                    HttpSession UsuarioLogeado = request.getSession(true);
                    UsuarioLogeado.setAttribute("datosUsuario", us);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }else {
                    System.out.println("No encontrado");
                    request.setAttribute("fail", "No hay acceso");
                    request.getRequestDispatcher("Vistas/login.jsp").forward(request, response);
                }
            }else if(accion != null){
                loginDAO login = new loginDAO();
                if(accion.equalsIgnoreCase("buscarUsuario")){
                   System.out.println("Buscando usuario");
                   String correo = request.getParameter("correo");
                   System.out.println("Correo recibido " + correo);
                   request.setAttribute("DatosUsuario", login.recuperar(correo).get(0));
                   request.setAttribute("obetenerPregunta", "simon");
                   request.getRequestDispatcher("Vistas/Recuperar.jsp").forward(request, response);
                }else if(accion.equalsIgnoreCase("Comparar")){
                   System.out.println("Comparando");
                   String correo = request.getParameter("correo");
                   String respuestaUsuario = request.getParameter("respuesta");
                   System.out.println("Correo " + correo);
                   System.out.println("Respuesta Usuario " + respuestaUsuario);
                   usuario usercomparar = login.recuperar(correo).get(0);
                    if (usercomparar.getRespuesta().equals(respuestaUsuario)) {
                        request.setAttribute("datosRecuperados", usercomparar);
                        request.getRequestDispatcher("Vistas/Recuperar.jsp").forward(request, response);
                    }else{
                        request.getRequestDispatcher("Vistas/Recuperar.jsp").forward(request, response);
                    }
                }else{
                   request.getRequestDispatcher("Vistas/Recuperar.jsp").forward(request, response);
                }
               
            }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

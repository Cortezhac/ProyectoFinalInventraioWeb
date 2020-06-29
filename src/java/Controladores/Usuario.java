/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.loginDAO;
import DAO.usuarioDAO;
import Factory.CRUDUntil;
import Modelos.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author isaac
 */
public class Usuario extends HttpServlet {

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

            String usuario = "";
            String clave = "";
            loginDAO dao = new loginDAO();
            List<usuario> datos = new ArrayList<usuario>();

            if (request.getParameter("btnIniciar") != null) {
                usuario = request.getParameter("txtUsuario");
                clave = request.getParameter("txtContra");
                datos = dao.accesar(usuario, clave);
                if (datos.size() > 0) {
                    request.setAttribute("datos", datos);
                    request.getRequestDispatcher("Vistas/login.jsp").forward(request, response);
                }else{
                    request.setAttribute("fail", "NO HAY ACCESO!");
                    request.getRequestDispatcher("Vistas/login.jsp").forward(request, response);
                    
                }
            }
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
        usuarioDAO usDA = new usuarioDAO("tb_usuario");

        String accion = request.getParameter("accion");// Capturar parametro accion
        System.out.println("Accion " + accion);// para el log
        if (accion != null) {
            if (accion.equalsIgnoreCase("E")) { // E significa que va editar el registro
                String id = request.getParameter("id"); // Obtiene el id del campo a editar
                doGetEditar(request, response, id); // llmam a la funcion de editar 
            } else if (accion.equalsIgnoreCase("AD")) {
                request.getRequestDispatcher("Vistas/Usuarios/Agregar.jsp").forward(request, response);
            } else if (accion.equalsIgnoreCase("DEL")) {
                String id = request.getParameter("id"); // Obtiene el id del campo a editar
                doGetEliminar(request, response, id);
            }else if(accion.equalsIgnoreCase("Eliminar")){
                int Eliminarid = Integer.parseInt(request.getParameter("id"));
                doPostEliminar(request, response, Eliminarid);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            HttpSession Resultado = request.getSession();
            Resultado.setAttribute("Lista", usDA.listarRegistros());
            //request.getSession(true).setAttribute("Lista", categoria.listarRegistros());
            request.getRequestDispatcher("Vistas/Usuarios/Listar.jsp").forward(request, response);
            //processRequest(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtengo la accion via POST que esta dentro del formulario
        String accion = request.getParameter("accion");
        System.out.println("Parametro Post" + accion);
        if (accion != null) {// Si la accion esta vacia no hacer nada
            if (accion.equalsIgnoreCase("UP")) {
                // Objeto categoria para guardar los nuevos valores
                usuario usDA = new usuario();

//---------------------------------------------------------------------------------------------------// 
                // id del registro que se va a modificar
                int condicion = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String correo = request.getParameter("correo");
                String usuario = request.getParameter("usuario");
                String clave = request.getParameter("clave");
                int tipo = Integer.parseInt(request.getParameter("tipo"));
                String estado = request.getParameter("estado");
                String pregunta = request.getParameter("pregunta");
                String respuesta = request.getParameter("respuesta");

                // guardar parametros en el objeto producto
                usDA.setNombre(nombre);
                usDA.setApellido(apellido);
                usDA.setCorreo(correo);
                usDA.setUsuario(usuario);
                usDA.setClave(clave);
                usDA.setTipo(tipo);
                usDA.setEstado(estado);
                usDA.setPregunta(pregunta);
                usDA.setRespuesta(respuesta);

                // Llamo a la funcion de actualizacion
                doPostActualizar(request, response, usDA, condicion);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                //-----------------------------------------------------------------------------//
            } else if (accion.equalsIgnoreCase("agregar")) {

//                int condicion = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String correo = request.getParameter("correo");
                String usuario = request.getParameter("usuario");
                String clave = request.getParameter("clave");
                int tipo = Integer.parseInt(request.getParameter("tipo"));
                String estado = request.getParameter("estado");
                String pregunta = request.getParameter("pregunta");
                String respuesta = request.getParameter("respuesta");

                usuario us = new usuario();
                us.setNombre(nombre);
                us.setApellido(apellido);
                us.setCorreo(correo);
                us.setUsuario(usuario);
                us.setClave(clave);
                us.setTipo(tipo);
                us.setEstado(estado);
                us.setPregunta(pregunta);
                us.setRespuesta(respuesta);

                doPostAgregar(request, response, us);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

    }

    protected void doGetEditar(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        usuarioDAO Usuario = new usuarioDAO("tb_usuario");
        String busqueda = " id = " + id; // Condicion para el WHERE
        System.out.println("Condicion de buscqueda " + id ); // para el log
        HttpSession Lista = request.getSession();// Crea la session
        // Guarda la lista en la session
        Lista.setAttribute("ListaEditarUsuario", Usuario.listarRegistros(busqueda));
        // Redirecciona a editar
        request.getRequestDispatcher("Vistas/Usuarios/Editar.jsp").forward(request, response);
    }

    protected void doGetEliminar(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        usuarioDAO Usuario = new usuarioDAO("tb_usuario");
        String busqueda = "id = " + id; // Condicion para el WHERE
        System.out.println("Condicion de buscqueda " + id); // para el log
        HttpSession Lista = request.getSession();// Crea la session
        // Guarda la lista en la session
        Lista.setAttribute("ListaResultado", Usuario.listarRegistros(busqueda));
        // Redirecciona a editar
        request.getRequestDispatcher("Vistas/Usuarios/Eliminar.jsp").forward(request, response);
    }

    protected void doPostAgregar(HttpServletRequest request, HttpServletResponse response, usuario pi) {
        usuarioDAO Usu = new usuarioDAO("tb_usuario");
        Usu.guardarRegistros(pi);
    }

    /**
     * Actaliza los datos del registro con el valor especificado
     *
     * @param request serverlet request
     * @param response serverlet response
     * @param prod Nuevos valores para actulizar
     * @param condicion id del registro que se va a utilizar
     */
    protected void doPostActualizar(HttpServletRequest request, HttpServletResponse response, usuario prod, int condicion) throws ServletException, IOException {
        // Proporciona las funcionabilidades del CRUD
        usuarioDAO Usu = new usuarioDAO("tb_usuario");
        String Condicion = " id = " + condicion; // Condicion para el WHERE
        // Actualiza el registro con el datos especificados y la condicion
        boolean estado = Usu.actualizarRegistro(prod, Condicion);
        System.out.println("Estado update " + estado);
    }

    protected void doPostEliminar(HttpServletRequest request, HttpServletResponse response, int condicion) throws ServletException, IOException {
        // Proporciona las funcionabilidades del CRUD
        usuarioDAO US = new usuarioDAO("tb_usuario");
        String Condicion = " id = " + condicion; // Condicion para el WHERE
        // Actualiza el registro con el datos especificados y la condicion
        boolean estado = US.eliminarRegistro(Condicion);

        System.out.println("Estado delete " + estado);
    }

    /**
     * /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

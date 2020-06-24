/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CategoriaDAO;
import Modelos.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class Categorias extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Categorias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Categorias at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // LLamo a mi objeto DAO para acceder a los datos
        CategoriaDAO categoria = new CategoriaDAO("tb_categoria");// Data Acess Object
        
        String accion = request.getParameter("accion");// Capturar parametro accion
        System.out.println("Accion " + accion);// para el log
        if(accion != null){ // Si la accion viene nula si valor lo mando a listar
            if(accion.equalsIgnoreCase("E")){ // E significa que va editar el registro
                String id = request.getParameter("id"); // Obtiene el id del campo a editar
                doGetEditar(request, response, id); // llmam a la funcion de editar 
            }
        }else {
            HttpSession Resultado = request.getSession(); // Creo una session
            // Guardo los valores en la session bajo el nombre de Lista
            Resultado.setAttribute("Lista", categoria.listarRegistros());
            // Llamar a la vista Listar.jsp
            request.getRequestDispatcher("Vistas/Categoria/Listar.jsp").forward(request, response);
            //processRequest(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtengo la accion via POST que esta dentro del formulario
        String accion = request.getParameter("accion");
        if(accion != null){// Si la accion esta vacia no hacer nada
            if(accion.equalsIgnoreCase("UP")){
                // Objeto categoria para guardar los nuevos valores
                Categoria categoria = new Categoria();
                // id del registro que se va a modificar
                int condicion = Integer.parseInt(request.getParameter("id"));
                // Estado ya editado en el formulario
                int estado = Integer.parseInt(request.getParameter("estado"));
                // Nombre ya editado en el formulario
                String nombre = request.getParameter("nombre");
                // guardar parametros en el objeto categoria
                categoria.setNom_categoria(nombre);
                categoria.setEstado_categoria(estado);
                // Llamo a la funcion de actualizacion
                doPostActualizar(request, response, categoria , condicion);
            }else if(accion.equalsIgnoreCase("AD")){
                
            }
        }
        //processRequest(request, response);
    }
    
    protected void doGetEditar(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException{
        CategoriaDAO categoria = new CategoriaDAO("tb_categoria");
        String busqueda = "id_categoria = "+ id; // Condicion para el WHERE
        System.out.println("Condicion de buscqueda " + id); // para el log
        HttpSession Lista = request.getSession();// Crea la session
        // Guarda la lista en la session
        Lista.setAttribute("ListaResultado", categoria.listarRegistros(busqueda));
        // Redirecciona a editar
        request.getRequestDispatcher("Vistas/Categoria/Editar.jsp").forward(request, response);
    }
    /**
     * Actaliza los datos del registro con el valor especificado
     * @param request serverlet request
     * @param response serverlet response
     * @param categoria Nuevos valores para actulizar
     * @param condicion  id del registro que se va a utilizar
     */
    protected void doPostActualizar(HttpServletRequest request, HttpServletResponse response, Categoria categoria , int condicion){
        // Proporciona las funcionabilidades del CRUD
        CategoriaDAO categoriaDAO = new CategoriaDAO("tb_categoria");
        String Condicion = " id_categoria = " + condicion; // Condicion para el WHERE
        // Actualiza el registro con el datos especificados y la condicion
        categoriaDAO.actualizarRegistro(categoria, Condicion);
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

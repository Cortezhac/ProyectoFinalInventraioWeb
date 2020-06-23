/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CategoriaDAO;
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
        CategoriaDAO categoria = new CategoriaDAO("tb_categoria");// Data Acess Object
        
        String accion = request.getParameter("accion");// Capturar parametro accion
        System.out.println("Accion " + accion);// para el log
        if(accion != null){
            if(accion.equalsIgnoreCase("E")){
                String id = request.getParameter("id");
                doGetEditar(request, response, id);
            }
        }else {
            HttpSession Resultado = request.getSession();
            Resultado.setAttribute("Lista", categoria.listarRegistros());
            //request.getSession(true).setAttribute("Lista", categoria.listarRegistros());
            request.getRequestDispatcher("Vistas/Categoria/Listar.jsp").forward(request, response);
            //processRequest(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void doGetEditar(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException{
        CategoriaDAO categoria = new CategoriaDAO("tb_categoria");
        String busqueda = "id_categoria = "+ id; // Condicion para el WHERE
        System.out.println("Condicion de buscqueda " + id); // para el log
        HttpSession Lista = request.getSession();
        Lista.setAttribute("ListaResultado", categoria.listarRegistros(busqueda));
        request.getRequestDispatcher("Vistas/Categoria/Editar.jsp").forward(request, response);
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

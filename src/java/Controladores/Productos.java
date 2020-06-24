/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.ProductoDAO;
import Modelos.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JCH
 */
public class Productos extends HttpServlet {

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
            out.println("<title>Servlet Productos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Productos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        ProductoDAO prod = new ProductoDAO("tb_producto");
        
        String accion = request.getParameter("accion");// Capturar parametro accion
        System.out.println("Accion " + accion);// para el log
        if(accion != null){
             if(accion.equalsIgnoreCase("E")){ // E significa que va editar el registro
                String id = request.getParameter("id"); // Obtiene el id del campo a editar
                doGetEditar(request, response, id); // llmam a la funcion de editar 
            }else if(accion.equalsIgnoreCase("AD")){
                request.getRequestDispatcher("Vistas/Producto/Agregar.jsp").forward(request, response);
            }else if(accion.equalsIgnoreCase("DE")){
                String id = request.getParameter("id"); // Obtiene el id del campo a editar
                doGetEliminar(request, response, id);
            }
        }else {
            HttpSession Resultado = request.getSession();
            Resultado.setAttribute("Lista", prod.listarRegistros());
            //request.getSession(true).setAttribute("Lista", categoria.listarRegistros());
            request.getRequestDispatcher("Vistas/Producto/Listar.jsp").forward(request, response);
            //processRequest(request, response);
        }

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
        System.out.println("Parametro Post" + accion);
        if(accion != null){// Si la accion esta vacia no hacer nada
            if(accion.equalsIgnoreCase("UP")){
                // Objeto categoria para guardar los nuevos valores
                Producto prod = new Producto();
                
                // id del registro que se va a modificar
                int condicion = Integer.parseInt(request.getParameter("id"));
                // Estado ya editado en el formulario
                int categoria = Integer.parseInt(request.getParameter("categoria"));
                int estado = Integer.parseInt(request.getParameter("estado"));
                // Nombre ya editado en el formulario
                String nombre = request.getParameter("nombre");
                String des = request.getParameter("descripcion");
                String medida = request.getParameter("medida");
                
                float stock = Float.parseFloat(request.getParameter("stock"));
                float precio = Float.parseFloat(request.getParameter("precio"));
                
                Date fecha = Date.valueOf(request.getParameter("fecha"));
                
                // guardar parametros en el objeto producto
                prod.setNom_producto(nombre);
                prod.setDes_producto(des);
                prod.setStock(stock);
                prod.setPrecio(precio);
                prod.setUnidad_de_medida(medida);
                prod.setCategoria(categoria);
                prod.setFecha_entrada(fecha);
                prod.setEstado_producto(estado);
                // Llamo a la funcion de actualizacion
                doPostActualizar(request, response, prod , condicion);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }else if(accion.equalsIgnoreCase("agregar")){
                
                int categoria = Integer.parseInt(request.getParameter("categoria"));
                int estado = Integer.parseInt(request.getParameter("estado"));
                String nombre = request.getParameter("nombre");
                String des = request.getParameter("descripcion");
                String medida = request.getParameter("medida");
                float stock = Float.parseFloat(request.getParameter("stock"));
                float precio = Float.parseFloat(request.getParameter("precio"));
                Date fecha = Date.valueOf(request.getParameter("fecha"));
                
                // guardar parametros en el objeto producto
                
                Producto producto = new Producto();
                producto.setNom_producto(nombre);
                producto.setDes_producto(des);
                producto.setStock(stock);
                producto.setPrecio(precio);
                producto.setUnidad_de_medida(medida);
                producto.setCategoria(categoria);
                producto.setFecha_entrada(fecha);
                producto.setEstado_producto(estado);

                doPostAgregar(request, response, producto);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else if(accion.equalsIgnoreCase("eliminar")){
                int condicion = Integer.parseInt(request.getParameter("id"));
                doPostEliminar(request ,response, condicion);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

     protected void doGetEditar(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException{
        ProductoDAO producto = new ProductoDAO("tb_producto");
        String busqueda = "id_producto = "+ id; // Condicion para el WHERE
        System.out.println("Condicion de buscqueda " + id); // para el log
        HttpSession Lista = request.getSession();// Crea la session
        // Guarda la lista en la session
        Lista.setAttribute("ListaResultado", producto.listarRegistros(busqueda));
        // Redirecciona a editar
        request.getRequestDispatcher("Vistas/Producto/Editar.jsp").forward(request, response);
    }
     
    protected void doGetEliminar(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException{
        ProductoDAO producto = new ProductoDAO("tb_producto");
        String busqueda = "id_producto = "+ id; // Condicion para el WHERE
        System.out.println("Condicion de buscqueda " + id); // para el log
        HttpSession Lista = request.getSession();// Crea la session
        // Guarda la lista en la session
        Lista.setAttribute("ListaResultado", producto.listarRegistros(busqueda));
        // Redirecciona a editar
        request.getRequestDispatcher("Vistas/Producto/Eliminar.jsp").forward(request, response);
    }
    
     
    protected void doPostAgregar(HttpServletRequest request, HttpServletResponse response, Producto prod){
        ProductoDAO DAO = new ProductoDAO("tb_producto");
        DAO.guardarRegistro(prod);
    }
    /**
     * Actaliza los datos del registro con el valor especificado
     * @param request serverlet request
     * @param response serverlet response
     * @param prod Nuevos valores para actulizar
     * @param condicion  id del registro que se va a utilizar
     */
    protected void doPostActualizar(HttpServletRequest request, HttpServletResponse response, Producto prod , int condicion) throws ServletException, IOException{
        // Proporciona las funcionabilidades del CRUD
        ProductoDAO DAO = new ProductoDAO("tb_producto");
        String Condicion = " id_producto = " + condicion; // Condicion para el WHERE
        // Actualiza el registro con el datos especificados y la condicion
        boolean estado = DAO.actualizarRegistro(prod, Condicion);
        System.out.println("Estado update " + estado);
    } 
    
    protected void doPostEliminar(HttpServletRequest request, HttpServletResponse response, int condicion) throws ServletException, IOException{
        // Proporciona las funcionabilidades del CRUD
        ProductoDAO DAO = new ProductoDAO("tb_producto");
        String Condicion = " id_producto = " + condicion; // Condicion para el WHERE
        // Actualiza el registro con el datos especificados y la condicion
        boolean estado = DAO.eliminarRegistro(Condicion);
        System.out.println("Estado delete " + estado);
    }
    /**
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
;
import Modelos.Categoria;
import DAO.CategoriaDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Pruebas {
    public static void main(String[] args) throws IOException, SQLException{
        //guardar();
        listarCategoria();
        //actualizar();
    }
    
    public static void guardar() throws IOException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Nombre categoria");
        String nombre = teclado.readLine();
        
        System.out.println("Estado Categoria");
        int estado = Integer.parseInt(teclado.readLine());
        
        // Llamo utilidades para usar sus funciones de acceso de datos
        CategoriaDAO utilidades = new CategoriaDAO("tbego_categoria");
        // Objeto a llenar
        Categoria categorianueva = new Categoria();
        categorianueva.setNom_categoria(nombre);
        categorianueva.setEstado_categoria(estado);
        // Guarda los registros
        utilidades.guardarRegistro(categorianueva);
    }
    
    
    public static void listarCategoria(){
        // Se llamas las utilidades y se le da el nombre de la tabla a usar
        CategoriaDAO utilidadeDAO = new CategoriaDAO("tb_categoria");
        // Lista de destino
        ArrayList<Categoria> lista = new ArrayList<>();
        // Se usa la funcion de listarRegistros de utilidades
        lista = utilidadeDAO.listarRegistros();
        //Se extraen los registros
        for(int i = 0 ; i < lista.size(); i++){
            System.out.println("Registros encontrados");
            Categoria categoria = lista.get(i);
            
            System.out.print("id " + categoria.getId_categoria());
            System.out.print(" Nombre " + categoria.getNom_categoria());
            System.out.println(" Estado " + categoria.getEstado_categoria());
            System.out.println("=========================");
        }
    }
    
    public static void actualizar() throws IOException, SQLException{
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Registro que desea actualizar");
        int busquedaid = Integer.parseInt(teclado.readLine());
        
        System.out.println("Nombre categoria");
        String nombre = teclado.readLine();
        
        System.out.println("Estado Categoria");
        int estado = Integer.parseInt(teclado.readLine());
        
        // Llamo utilidades para usar sus funciones de acceso de datos
        CategoriaDAO utilidades = new CategoriaDAO("tb_categoria");
        // Objeto a llenar
        Categoria categorianueva = new Categoria();
        categorianueva.setNom_categoria(nombre);
        categorianueva.setEstado_categoria(estado);
        
        // Guarda los registros
        //utilidades.actualizarRegistro(categorianueva, busquedaid);
    }
}

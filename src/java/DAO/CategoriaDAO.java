/*
 * Es necesario Agregar el nombre de la tabla para DAO
 */
package DAO;

import Factory.CRUDUntil;
import Modelos.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CategoriaDAO {
    
    private final String nombreTabla;
    CRUDUntil utilidades = new CRUDUntil();
    ResultSet miResultSet;
    
    public CategoriaDAO(String nombreTabla){
        this.nombreTabla = nombreTabla;
    }
    /**
     * Retona todos los datos en un ArrayList
     * @return ArraList de tipo categoria
     */
    public ArrayList<Categoria> listarRegistros(){
        // Preparo las lista
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            // Traigo los registros con el nombre de la tabla
            miResultSet = utilidades.buscarRegistro(this.nombreTabla);
            // Extrae los registros del ResulSet y los guarda en en ArrayList
            while (miResultSet.next()) {                
                Categoria categoria = new Categoria(miResultSet.getInt("id_categoria"),
                                                    miResultSet.getString("nom_categoria"),
                                                    miResultSet.getByte("estado_categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error listarRegistros " + e);
        }
        return categorias;
    }
    /**
     * Busca todos los registros con la condicion especificada
     * @param condicion Formato <code>nombre_campo = valor_campo</code> si el valor a utilizar en
     * el campo es VARCHAR colocarlo en tre comillas simple <code>'valor_campo'</code>
     * @return ArrayList de tipo Categoria
     */
    public ArrayList<Categoria> listarRegistros(String condicion){
        // Preparo las lista
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            // Traigo los registros con el nombre de la tabla
            miResultSet = utilidades.buscarRegistro(this.nombreTabla, condicion);
            // Extrae los registros del ResulSet y los guarda en en ArrayList
            while (miResultSet.next()) {                
                Categoria categoria = new Categoria(miResultSet.getInt("id_categoria"),
                                                    miResultSet.getString("nom_categoria"),
                                                    miResultSet.getByte("estado_categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error listarRegistros " + e);
        }
        return categorias;
    }
    
    /**
     * Toma los datos del objeto y los almacena
     * @param categoriaGuardar objeto con todos los parametros de categoria 
     */
    public void guardarRegistro(Categoria categoriaGuardar){
        //Campos a actualizar
        String camposInsertar = "nom_categoria, estado_categoria";
        // Nuevos valores en el mismo orden que los campos
        String valoresCampos = "'" + categoriaGuardar.getNom_categoria() + "', '" 
                                   + categoriaGuardar.getEstado_categoria() + "' ";
        utilidades.insertarRegistro(this.nombreTabla, camposInsertar, valoresCampos);
    }
    
    public boolean actualizarRegistro(Categoria categoriaActualizar, String condicion){
        
        String camposActualizar = " nom_categoria = '" + categoriaActualizar.getNom_categoria() + 
                                  "' , estado_categoria = '" + categoriaActualizar.getEstado_categoria() + "' ";
        boolean estado = utilidades.actualizarRegistros(this.nombreTabla, camposActualizar, condicion);
        return estado;
    }
}

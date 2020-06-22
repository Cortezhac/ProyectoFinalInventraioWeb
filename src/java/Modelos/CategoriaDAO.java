/*
 * Es necesario Agregar el nombre de la tabla para DAO
 */
package Modelos;

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
    
    public void guardarRegistro(Categoria categoriaGuardar){
        String camposInsertar = "nom_categoria, estado_categoria";
        String valoresCampos = "'" + categoriaGuardar.getNom_categoria() + "', '" 
                                   + categoriaGuardar.getEstado_categoria() + "' ";
        utilidades.insertarRegistro(this.nombreTabla, camposInsertar, valoresCampos);
    }
}

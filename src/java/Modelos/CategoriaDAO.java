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
    
    public CategoriaDAO(String nombreTabla){
        this.nombreTabla = nombreTabla;
    }
    /**
     * Retonar todos los datos en un ArrayList
     * @return ArraList de tipo categoria
     */
    public ArrayList<Categoria> listarRegistros(){
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            ResultSet Registros = utilidades.buscarRegistro(this.nombreTabla);
            while (Registros.next()) {                
                Categoria categoria = new Categoria(Registros.getInt("id_categoria"),
                                                    Registros.getString("nom_categoria"),
                                                    Registros.getByte("estado_categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("");
        }
        return categorias;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.CRUDUntil;
import Modelos.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author JCH
 */
public class ProductoDAO {
    private final String nomTabla;
    CRUDUntil util = new CRUDUntil();
    ResultSet rs;

    public ProductoDAO(String nomTabla) {
        this.nomTabla = nomTabla;
    }
    
    public ArrayList<Producto> listarRegistros(){
        ArrayList<Producto> producto = new ArrayList<>();
        try{
            rs = util.buscarRegistro(this.nomTabla);
            while(rs.next()){
                Producto prod = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nom_producto"),
                        rs.getString("des_producto"),
                        rs.getFloat("stock"),
                        rs.getFloat("precio"),
                        rs.getString("unidad_de_medida"),
                        rs.getInt("estado_producto"),
                        rs.getInt("categoria"),
                        rs.getDate("fecha_entrada")
                );
                producto.add(prod);
                
            }
        }catch(SQLException ex){
            System.out.println("Error listarRegistro: " + ex);
        }
        
        return producto;
    }
    
    public ArrayList<Producto> listarRegistros(String condicion){
        // Preparo las lista
        ArrayList<Producto> prod = new ArrayList<>();
        try {
            // Traigo los registros con el nombre de la tabla
            rs = util.buscarRegistro(this.nomTabla, condicion);
            // Extrae los registros del ResulSet y los guarda en en ArrayList
            while (rs.next()) {                
                Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nom_producto"),
                        rs.getString("des_producto"),
                        rs.getFloat("stock"),
                        rs.getFloat("precio"),
                        rs.getString("unidad_de_medida"),
                        rs.getInt("estado_producto"),
                        rs.getInt("categoria"),
                        rs.getDate("fecha_entrada")
                );
                prod.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error listarRegistros " + e);
        }
        return prod;
    }
    
    /**
     * Toma los datos del objeto y los almacena
     * @param productoGuardar objeto con todos los parametros de categoria 
     */
    public void guardarRegistro(Producto productoGuardar){
        //Campos a actualizar
        String camposInsertar = "nom_producto, des_producto, stock, precio, unidad_de_medida, estado_producto, categoria, fecha_entrada";
        // Nuevos valores en el mismo orden que los campos
        String valoresCampos = "'" + productoGuardar.getNom_producto() + "', '" 
                                   + productoGuardar.getDes_producto() + "', '"
                                   + productoGuardar.getStock() + "', '"
                                   + productoGuardar.getPrecio() + "', '"
                                   + productoGuardar.getUnidad_de_medida() + "', '"
                                   + productoGuardar.getEstado_producto() + "', '"
                                   + productoGuardar.getCategoria() + "', '"
                                   + productoGuardar.getFecha_entrada() + "' ";
        util.insertarRegistro(this.nomTabla, camposInsertar, valoresCampos);
    }
    
    public boolean actualizarRegistro(Producto productoActualizar, String condicion){
        
        String camposActualizar = " nom_producto = '" + productoActualizar.getNom_producto() + 
                                  "', des_producto = '" + productoActualizar.getDes_producto()  +
                                  "', stock = '" + productoActualizar.getStock()  +
                                  "', precio = '" + productoActualizar.getPrecio()  +
                                  "', unidad_de_medida = '" + productoActualizar.getUnidad_de_medida()  +
                                  "', estado_producto = '" + productoActualizar.getEstado_producto()  +
                                  "', categoria = '" + productoActualizar.getCategoria()  +
                                  "' , fecha_entrada = '" + productoActualizar.getFecha_entrada() + "' ";
        boolean estado = util.actualizarRegistros(this.nomTabla, camposActualizar, condicion);
        return estado;
    }
    
    public boolean eliminarRegistro(String condicion){
        String tabla = this.nomTabla;
        boolean estado = util.eliminarRegistro(tabla, condicion);
        return estado;
    }
}

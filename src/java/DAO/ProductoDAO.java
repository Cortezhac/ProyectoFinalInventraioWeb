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
    
}

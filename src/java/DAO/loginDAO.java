package DAO;

import Factory.CRUDUntil;
import java.sql.*;
import java.util.*;
import Modelos.usuario;

import Factory.Conexion;

public class loginDAO {

    Conexion db = new Conexion();
    CRUDUntil utilidades = new CRUDUntil();
    ResultSet miResultSet;
    
    public List<usuario> accesar(String usuario, String clave) {
        List<usuario> datos = new ArrayList<>();
        
        String campos = " nombre , tipo ";
        String condicion = " usuario = " + usuario + " AND clave = " + clave + " ";
        try {
            miResultSet = utilidades.buscarUsuario("tb_usuario", campos, condicion);
            miResultSet.next();
            usuario Usuario = new usuario();
            Usuario.setNombre(miResultSet.getString("nombre"));
            Usuario.setTipo(miResultSet.getInt("tipo"));
            
            datos.add(Usuario);
        } catch (Exception e) {
            System.out.println("Error accesar " + e);
        }
        return datos;
    }
}

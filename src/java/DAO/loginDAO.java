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
    
    public loginDAO(){
        
    }
    
    public List<usuario> accesar(String usuario, String clave) {
        List<usuario> datos = new ArrayList<>();
        
        String campos = "usuario , nombre , tipo ";
        String condicion = " usuario = '" + usuario + "' AND clave = '" + clave + "' ";
        try {
            miResultSet = utilidades.buscarUsuario("tb_usuario", campos, condicion);
            miResultSet.next();
            usuario Usuario = new usuario();
            Usuario.setUsuario(miResultSet.getString("usuario"));
            Usuario.setNombre(miResultSet.getString("nombre"));
            Usuario.setTipo(miResultSet.getInt("tipo"));
            
            datos.add(Usuario);
        } catch (Exception e) {
            System.out.println("Error accesar " + e);
        }
        return datos;
    }
    
    public List<usuario> recuperar(String respuesta){
        List<usuario> datos = new ArrayList<>();
        usuario dataUsuario = new usuario();
        String campos = " correo , usuario , clave , pregunta , respuesta ";
        String condicion = " correo = '" + respuesta + "' ";
        try{
            miResultSet = utilidades.buscarUsuario("tb_usuario", campos , condicion);
            miResultSet.next();
            dataUsuario.setCorreo(miResultSet.getString("correo"));
            dataUsuario.setUsuario(miResultSet.getString("usuario"));
            dataUsuario.setClave(miResultSet.getString("clave"));
            dataUsuario.setPregunta(miResultSet.getString("pregunta"));
            dataUsuario.setRespuesta(miResultSet.getString("respuesta"));
            datos.add(dataUsuario);
        }catch(SQLException e){
            System.out.println("Chale fallo la recuperacion " + e);
        }
        return datos;
    }
}

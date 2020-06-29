package DAO;

import Factory.CRUDUntil;
import Modelos.usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author isaac
 */
public class usuarioDAO{
    
    private final String nombreTabla;
    CRUDUntil utilidades = new CRUDUntil();
    ResultSet miResultSet;
    
    public usuarioDAO(String nombreTabla){
        this.nombreTabla = nombreTabla;
    }
    /**
     * Retona todos los datos en un ArrayList
     * @return ArraList de tipo categoria
     */
   
    public ArrayList<usuario> listarRegistros(){
        // Preparo las lista
        ArrayList<usuario> usuario = new ArrayList<>();
        try {
            // Traigo los registros con el nombre de la tabla
            miResultSet = utilidades.buscarRegistro(this.nombreTabla);
            // Extrae los registros del ResulSet y los guarda en en ArrayList
            while (miResultSet.next()) {                
                usuario us = new usuario(miResultSet.getInt("id"),
                                        miResultSet.getString("nombre"),
                                        miResultSet.getString("apellido"),
                                        miResultSet.getString("correo"),
                                        miResultSet.getString("usuario"),
                                        miResultSet.getString("clave"),
                                        miResultSet.getInt("tipo"),
                                        miResultSet.getString("estado"),
                                        miResultSet.getString("pregunta"),
                                        miResultSet.getString("respuesta"),
                                        miResultSet.getString("fecha_registro"));
                                                   
                 usuario.add(us);
            }
        } catch (SQLException e) {
            System.out.println("Error listarRegistros " + e);
        }
        return usuario;
    }
    /**
     * Busca todos los registros con la condicion especificada
     * @param condicion Formato <code>nombre_campo = valor_campo</code> si el valor a utilizar en
     * el campo es VARCHAR colocarlo en tre comillas simple <code>'valor_campo'</code>
     * @return ArrayList de tipo Categoria
     */
       public ArrayList<usuario> listarRegistros(String condicion){
        // Preparo las lista
        ArrayList<usuario> usuario = new ArrayList<>();
        try {
            // Traigo los registros con el nombre de la tabla
            miResultSet = utilidades.buscarRegistro(this.nombreTabla, condicion);
            // Extrae los registros del ResulSet y los guarda en en ArrayList
            while (miResultSet.next()) {                
                           usuario us = new usuario(miResultSet.getInt("id"),
                                                    miResultSet.getString("nombre"),
                                                    miResultSet.getString("apellido"),
                                                    miResultSet.getString("correo"),
                                                    miResultSet.getString("usuario"),
                                                    miResultSet.getString("clave"),
                                                    miResultSet.getInt("tipo"),
                                                    miResultSet.getString("estado"),
                                                    miResultSet.getString("pregunta"),
                                                    miResultSet.getString("respuesta"),
                                                    miResultSet.getString("fecha_registro"));
                                                   
                 usuario.add(us);
            }
        } catch (SQLException e) {
            System.out.println("Error listarRegistros " + e);
        }
        return usuario;
    }
    
       
       
       /**
     * Toma los datos del objeto y los almacena
     * @param UsuarioGuardar con todos los parametros de categoria 
     */
   public void guardarRegistros( usuario UsuarioGuardar ){
    //Campos a actualizar
    String camposInsertar = "nombre,apellido,correo,usuario,clave,tipo,estado,pregunta,respuesta";
    // Nuevos valores en el mismo orden que los campos
      String ValoresCampos = "'" + UsuarioGuardar.getNombre() + "','" + UsuarioGuardar.getApellido() + "','" + UsuarioGuardar.getCorreo() + "','" + UsuarioGuardar.getUsuario() + "','" +
                UsuarioGuardar.getClave() + "','" + UsuarioGuardar.getTipo() + "','" + UsuarioGuardar.getEstado() + "','" + UsuarioGuardar.getPregunta() + "','" + UsuarioGuardar.getRespuesta() + "'";
        utilidades.insertarRegistro(this.nombreTabla, camposInsertar, ValoresCampos);
    }
       
   
   public boolean actualizarRegistro(usuario UsuarioActualizar, String condicion ){
        String Condicion = " id = " + String.valueOf(condicion);
       //campos a actualizar
         String camposActualizar = "nombre  = '"+UsuarioActualizar.getNombre()+"',apellido = '"+UsuarioActualizar.getApellido()+"',correo = '"+
  UsuarioActualizar.getCorreo()+"', usuario = '" + UsuarioActualizar.getUsuario() +"', clave = '"+ UsuarioActualizar.getClave()+"', tipo = '" + UsuarioActualizar.getTipo() + "',estado = '" + UsuarioActualizar.getEstado()
          + "', pregunta = '" + UsuarioActualizar.getPregunta()+ "', respuesta = '" + UsuarioActualizar.getRespuesta()+ "'";
        boolean estado = utilidades.actualizarRegistros(this.nombreTabla, camposActualizar, condicion);
        return estado;
    }

   
  public boolean eliminarRegistro(String condicion){
        String tabla = this.nombreTabla;
        boolean estado;
        estado = utilidades.eliminarRegistro(tabla, condicion);
        return estado;
    }
    
 }


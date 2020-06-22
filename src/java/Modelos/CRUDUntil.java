/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class CRUDUntil {
    Statement sqlStatement;
    Connection COM;
    Conexion SQLConexion = new Conexion();
    
    public CRUDUntil(){
        
    }
    /**
     * Inserta los nuevos registros en la base de datos
     * @param nombreTabla Nombre de la tabla que se va a utilizar
     * @param camposInsertar Campos de la tabla escogida (toma en cuenta el orden a la hora de insertar los valores)
     * @param valoresCampos Valores de los campos (se deben colocar en el mismo orden de los campos)
     * @return boolean false | true 
     */
    public boolean insertarRegistro(String nombreTabla, String camposInsertar, String valoresCampos){
        String QuerySQL = "INSERT INTO " + nombreTabla + "( " + camposInsertar + ") VALUES(" + valoresCampos + ");";
        int resultado = 0;
        try {
            COM = SQLConexion.openConnection();
            sqlStatement = COM.createStatement();
            resultado = sqlStatement.executeUpdate(QuerySQL);
        } catch (SQLException e) {
            System.out.println("Error de insercion " + e);
        }
            
        boolean estado = resultado != 0;
        return estado;
    }
    
    /**
     * Actualiza los valore de la base de datos definido por <code>condicion</code>
     * @param nombreTabla Tabla de labase de datos que se va a utilizar
     * @param valoresActualizar Formato a utilizar : nombre_campo = nuevo_valor , nombre_campo2 = nuevo_valor
     * @param condicion nombre_campo = campo_buscado generalmente el primary key
     * @return boolean false | true 
     */
    public boolean actualizarRegistros(String nombreTabla, String valoresActualizar, String condicion){
        String QuerySQL = "UPDATE " + nombreTabla + " SET " + valoresActualizar + " WHERE " + condicion + " ;";
        int resultado = 0;
        try {
            COM = SQLConexion.openConnection();
            sqlStatement = COM.createStatement();
            resultado = sqlStatement.executeUpdate(QuerySQL);
        } catch (SQLException e) {
            System.out.println("Error en la actualizacion " + e + "\n " + QuerySQL);
        }
        boolean estado = resultado != 0;
        return estado;
    }
    /**
     * Se debe haber buscado el registro a elliminar previamente antes de usar esta funcion
     * @param nombreTabla Tabla que se va utilizar
     * @param condicion Condicion de eliminacion Formato: nombre_campo = valores_campo 
     * @return boolean false | true
     */
    public boolean eliminarRegistro(String nombreTabla , String condicion){
        String QuerySQL = "DELETE FROM " + nombreTabla + " WHERE " + condicion + " ;";
        int resultado = 0;
        try {
            COM = SQLConexion.openConnection();
            sqlStatement = COM.createStatement();
            resultado = sqlStatement.executeUpdate(QuerySQL);
        } catch (SQLException e) {
            System.out.println("Error en la eliminacionn " + e);
        }
        boolean estado = resultado != 0;
        return estado;
    }
    /**
     * Devuelve un conjunto de datos de la tabla especificada
     * @param nombreTabla Tabla de la que se traera la informacion
     * @return datosEncontrados Informacion encontrada
     */
    public ResultSet buscarRegistro(String nombreTabla){
        String QuerySQL = "SELECT * FROM " + nombreTabla + " ;";
        ResultSet datosEncontrados = null;
        try {
            COM = SQLConexion.openConnection();
            sqlStatement = COM.createStatement();
            datosEncontrados = sqlStatement.executeQuery(QuerySQL);
        } catch (SQLException e) {
            System.out.println("Error en la busqueda " + e );
        }
        return datosEncontrados;
    }
    /**
     * Retorna un conjunto de valores de la base de datos
     * @param nombreTabla Tabla de la cual se traera la informacion
     * @param condicion Condicion de busqueda Formato: nombre_campo = valor_campo
     * @return datosEncontrados 
     */
    public ResultSet buscarRegistro(String nombreTabla, int condicion){
        String QuerySQL = "SELECT * FROM " + nombreTabla + " WHERE " + condicion + " ;";
        ResultSet datosEncontrados = null;
        try {
            COM = SQLConexion.openConnection();
            sqlStatement = COM.createStatement();
            datosEncontrados = sqlStatement.executeQuery(QuerySQL);
        } catch (SQLException e) {
            System.out.println("Error en la busqueda por condicion " + e);
        }
        return datosEncontrados;
    }
}

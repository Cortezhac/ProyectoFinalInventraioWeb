/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
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
     * @return 
     */
    public boolean actualizarRegistros(String nombreTabla, String valoresActualizar, String condicion){
        String QuerySQL = "UPDATE " + nombreTabla + " SET " + valoresActualizar + " WHERE " + condicion;
        int resultado = 0;
        try {
            COM = SQLConexion.openConnection();
            sqlStatement = COM.createStatement();
            resultado = sqlStatement.executeUpdate(QuerySQL);
        } catch (SQLException e) {
            System.out.println("Error en la actualizacion " + e);
        }
        boolean estado = resultado != 0;
        return estado;
    }
}

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
    
}

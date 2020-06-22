/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Conexion {
    // Direccion del servidor Mysql
    private final String SERVIDOR;
    // Nombre Usuario
    private final String USUARIO;
    // Clave
    private final String CLAVE;
    // Objeto Connection de SQL permite usar sus fuciones e interactuar con la bd
    Connection COM;
    // Class proporcionadas por la libreria JDBC
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    /**
     * Constructor asigna los valores de la conexion necesarios para abrir Connection
     */
    public Conexion(){
        this.SERVIDOR = "";
        this.USUARIO = "root";
        this.CLAVE = "";
    }
    
    /**
     * Abre la conexion con la base de datos
     * @return COM 
     */
    public Connection openConnection(){
        try {
            Class.forName(DRIVER);
            COM = DriverManager.getConnection(SERVIDOR, USUARIO, CLAVE);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error Conexion " + ex);
        }
        return this.COM;
    }
}

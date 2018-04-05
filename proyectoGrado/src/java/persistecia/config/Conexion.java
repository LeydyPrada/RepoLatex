/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {

public static Conexion instance;
     private  Connection conn;
     
     
    /**
     * @author jeimmy Nieto
     * Metodo que comprueba si la instancia ya existe
     */
    private Conexion(){        
            try {
                
                Properties props = new ConfigProperties().getProperties();
                Class.forName(props.getProperty("className"));
                conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
            } catch (SQLException ex) {
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }       
    }
    /**@author jeimmy Nieto
     * Metodo que comprueba si la instancia ya existe
     */
    public static Conexion obtener(){
        if(instance == null){
           instance = new Conexion();
           System.out.println("Conexion Exitosa");
        }   
        System.out.println("Conexion Fallida");
        return instance;
    }

    public Connection getConn() {
        return conn;
    }     
    /**@author jeimmy Nieto
     * Metodo que permite cerrar la conexion
     */
    public void cerrar(){
        if (instance != null) {
            instance = null;
        }
    }    
}

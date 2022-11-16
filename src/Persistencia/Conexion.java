/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
 
    private final String bd = "bdpractica2022";   // Constante 
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String user ="root";
    private final String password = "Pablito123";
    private final String driver ="com.mysql.cj.jdbc.Driver";
    
    Connection cnn= null;

    public Conexion() {
        
    }
    
    public Connection conectar () {
        try {
            Class.forName(driver); // cargamos el driver MySQL
            
            cnn= (Connection)DriverManager.getConnection(url+bd, user, password);
            System.out.println("Se conecto a Bd "+bd);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se conecto a Bd"+bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         return cnn;
       
        
        
    }
    
    public void desconectar (){
        try {
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
    
    }
     
}


package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMySQL {
    public static final String URL = "jdbc:mysql://localhost:3306/centralAutobuses";
    public static final String USER = "root";
    public static final String PASSWORD ="";
    
    public Connection getConexion(){
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        
        return con;
    }
}

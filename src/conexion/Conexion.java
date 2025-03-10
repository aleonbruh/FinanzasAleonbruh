
package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion {
    
    //Conexion Local
    public static Connection conectar(){   
        try {
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/databasename", "root", "password");
           return cn;
            
        } catch (SQLException e){
            System.out.println("Erro en la conexion local: " + e);
        } 
        return null;
    }
}

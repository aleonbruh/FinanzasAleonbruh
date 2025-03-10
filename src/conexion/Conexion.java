
package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexion {
    
    //Conexion Local
    public static Connection conectar(){   
        try {
           Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/finanzasaleonbruh", "root", "aleonbruh-12212580");
           return cn;
            
        } catch (SQLException e){
            System.out.println("Erro en la conexion local: " + e);
        } 
        return null;
    }
}

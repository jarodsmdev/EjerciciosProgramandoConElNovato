/**
 * Ejercicio 30 JAVA - Acceso y lectura de BASE DE DATOS
 */
package ejerciciosVarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Ejercicio6 {
    public static void main(String[] args){
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicios", "root", "12345");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM persona;");
            
            while(rs.next()){
                System.out.println("Nombre: " + rs.getString("nombre") + " | Edad: " + rs.getInt("edad") + " | País: " + rs.getString("paisNacimiento"));
            }
            
            rs.close();
            st.close();
            conn.close();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

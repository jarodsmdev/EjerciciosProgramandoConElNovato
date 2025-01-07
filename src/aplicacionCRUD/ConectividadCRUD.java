/*
 * Ejercicio 56 JAVA - CRUD | REGISTRO VIDEOJUEGOS 2/4
 * URL: https://youtu.be/G7zwmJNZCxg?list=PL0OKXi7iFPGqMMU78vaCvtSAOjS1ZNxbK
 */

package aplicacionCRUD;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 * @version 07/01/2025
 * @author Jarod Smith
 */
public class ConectividadCRUD {
    private static Connection miCon;
    private static Statement miSt;
    
    public static void conectar(){
        try {
            miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicios_novato","root","");
            miSt = miCon.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void desconectar(){
        try {
            miSt.close();
            miCon.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void mostrarDatos(DefaultTableModel modelo){
        conectar();
        try {
            ResultSet miRs = miSt.executeQuery("SELECT * FROM VIDEOJUEGOS");
            
            Object[] registro = new Object[4];
            
            while(miRs.next()){
                registro[0] = miRs.getString(1);
                registro[1] = miRs.getString(2);
                registro[2] = miRs.getInt(3);
                registro[3] = miRs.getBoolean(4);
                modelo.addRow(registro);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        desconectar();
    }
}

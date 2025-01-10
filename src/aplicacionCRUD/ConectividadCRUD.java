/*
 * Ejercicio 56 JAVA - CRUD | REGISTRO VIDEOJUEGOS 2/4
 * URL: https://youtu.be/G7zwmJNZCxg?si=uDWlzqXPJH2aRn7M
 */
package aplicacionCRUD;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @version 07/01/2025
 * @author Jarod Smith
 */
public class ConectividadCRUD {

    private static Connection miCon;
    private static Statement miSt;
    private static Object nuevoValor;

    public static void conectar() {
        try {
            miCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejercicios_novato", "root", "");
            miSt = miCon.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void desconectar() {
        try {
            miSt.close();
            miCon.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void mostrarDatos(DefaultTableModel modelo) {

        conectar();

        try {
            ResultSet miRs = miSt.executeQuery("SELECT * FROM VIDEOJUEGOS ORDER BY nombre");

            modelo.setRowCount(0);//Limpiar las filas de las tablas

            Object[] registro = new Object[4];

            while (miRs.next()) {
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

    public static void agregarRegistro(DefaultTableModel modelo) {

        Object[] registro = new Object[4];
        String[] valores = {"Nombre", "Plataforma", "Duración", "Recomendable (boolean)"};

        for (int i = 0; i < registro.length; i++) {
            registro[i] = JOptionPane.showInputDialog("Introduce " + valores[i] + ": ");
        }

        if (registro[3].equals("true")) {
            registro[3] = 1;
        } else {
            registro[3] = 0;
        }

        conectar();

        String insertarSQL = "INSERT INTO videojuegos VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = miCon.prepareStatement(insertarSQL);

            ps.setString(1, (String) registro[0]);
            ps.setString(2, (String) registro[1]);
            ps.setString(3, (String) registro[2]);
            ps.setInt(4, (int) registro[3]);

            ps.execute();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Error al Insertar",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        desconectar();

        mostrarDatos(modelo);

    }

    public static void borrarRegistro(JTable tabla, DefaultTableModel modelo) {

        int fila = tabla.getSelectedRow();

        if (fila != -1) {
            String nombre = modelo.getValueAt(fila, 0).toString();

            conectar();

            String borrarSQL = "DELETE FROM videojuegos WHERE nombre = ?";

            try {
                PreparedStatement ps = miCon.prepareStatement(borrarSQL);

                ps.setString(1, nombre);

                ps.execute();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Error al Eliminar",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            desconectar();

            mostrarDatos(modelo);
        }
    }

    public static void actualizarRegistro(JTable tabla, DefaultTableModel modelo, Object valor) {

        int fila = tabla.getSelectedRow();
        int columna = tabla.getSelectedColumn();

        if (fila != -1) {
            String nombre = modelo.getValueAt(fila, 0).toString();
            if (valor == null) {
                nuevoValor = JOptionPane.showInputDialog("Introduce nuevo valor: ");
            }else{
                nuevoValor = valor;
            }

            if (nuevoValor != null && !nuevoValor.equals("")) {

                if (columna == 3) {
                    if (nuevoValor.equals("true")) {
                        nuevoValor = 1;
                    } else {
                        nuevoValor = 0;
                    }
                }

                conectar();

                String SQL = "UPDATE videojuegos SET " + tabla.getColumnName(columna) + " = '" + nuevoValor + "' WHERE NOMBRE = '" + nombre + "'";
                try {
                    miSt.execute(SQL);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            ex.getMessage(),
                            "Error al Actualizar",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

                desconectar();

                mostrarDatos(modelo);

            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un registro primero",
                    "Error al Actualizar",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public static void actualizarConListener(JTable tabla, DefaultTableModel modelo){
        int fila = tabla.getSelectedRow();
        int columna = tabla.getSelectedColumn();
        
        Object valor = modelo.getValueAt(fila, columna);
        
        actualizarRegistro(tabla, modelo, valor);
    }
}

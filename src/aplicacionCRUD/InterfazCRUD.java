/*
 * Ejercicio 56 JAVA - CRUD | REGISTRO VIDEOJUEGOS 1/4
 * URL: https://youtu.be/rcVUYasLBxs?si=5uDVK1WXqJg7ygwd
 */
package aplicacionCRUD;

import java.awt.BorderLayout;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @version 07/01/2025
 * @author Jarod Smith
 */
public class InterfazCRUD extends JFrame {

    private JButton btnCreate, btnUpdate, btnDelete;
    private JPanel panelPrincipal, panelBotones;
    private JScrollPane panelTabla;

    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public InterfazCRUD() {

        tabla = new JTable(modeloTabla);

        panelTabla = new JScrollPane(tabla);
        panelBotones = new JPanel();
        panelPrincipal = new JPanel(new BorderLayout());

        btnCreate = new JButton("Agregar");
        btnUpdate = new JButton("Actualizar");
        btnDelete = new JButton("Borrar");
    }

    public void abrirCRUD() {
        montarInterfaz();
        setVisible(true);
    }

    private void montarInterfaz() {
        prepararTabla();
        
        // Agregar ActionListener a los botones
        btnCreate.addActionListener(e -> ConectividadCRUD.agregarRegistro(modeloTabla));
        btnDelete.addActionListener(e -> ConectividadCRUD.borrarRegistro(tabla, modeloTabla));
        
        setHandCursor(btnCreate);
        setHandCursor(btnUpdate);
        setHandCursor(btnDelete);

        panelBotones.add(btnCreate);
        panelBotones.add(btnUpdate);
        panelBotones.add(btnDelete);

        panelPrincipal.add(panelTabla, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        setSize(600, 500);
        setResizable(false);
        setTitle("Registro de Videojuegos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void prepararTabla() {

        String[] columnas = {"Nombre", "Plataforma", "Duración", "Recomendable"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla.setModel(modeloTabla);
        
        ConectividadCRUD.mostrarDatos(modeloTabla);
    }
    
    private void setHandCursor(JButton boton){
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}

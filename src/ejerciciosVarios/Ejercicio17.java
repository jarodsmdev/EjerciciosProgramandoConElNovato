/*
 * Ejercicio 52 JAVA - PROPÓSITOS 2024
 * URL: https://youtu.be/FrPmfBOS7TM?list=PL0OKXi7iFPGqMMU78vaCvtSAOjS1ZNxbK
 */
package ejerciciosVarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 * @version 06/01/2025
 * @author Jarod Smith
 */
public class Ejercicio17 {

    public static void main(String[] args) {
        InterfazProposito interfaz = new InterfazProposito();
        interfaz.abrir();
    }
}

class InterfazProposito extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JList<String> lista;
    private DefaultListModel<String> modelo;
    private JScrollPane scroll;
    private JButton btnAdd;
    private JButton btnRemove;

    public InterfazProposito() {
        panelPrincipal = new JPanel(new BorderLayout());
        panelBotones = new JPanel();

        modelo = new DefaultListModel<String>();
        lista = new JList<String>(modelo);
        lista.setCellRenderer(new cellPersonalizada());

        scroll = new JScrollPane(lista);
        scroll.setBorder(new EmptyBorder(10, 10, 10, 10));

        btnAdd = new JButton("Nuevo Propósito");
        btnRemove = new JButton("Olvidar Propósito");

        montarEscena();

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                LogicaProposito.cargarElementos(modelo);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                LogicaProposito.guardarElementos(modelo);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    private void configBoton(JButton boton) {
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void montarEscena() {
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        //Botones en el panel secundario
        configBoton(btnAdd);
        configBoton(btnRemove);

        btnAdd.addActionListener(e -> LogicaProposito.nuevoProposito(modelo));
        btnRemove.addActionListener(e -> LogicaProposito.eliminarProposito(modelo, lista));

        panelBotones.add(btnAdd);
        panelBotones.add(btnRemove);

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        //Configurar el JFrame
        setTitle("Propósitos para este año");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(panelPrincipal);
    }

    public void abrir() {
        setVisible(true);
    }
}

class LogicaProposito {

    private static String ruta = "./resources/propositos/propositos.txt";

    public static void nuevoProposito(DefaultListModel<String> modelo) {
        String proposito = JOptionPane.showInputDialog(
                null,
                "Escribe un nuevo propósito:",
                "Nuevo Propósito",
                JOptionPane.QUESTION_MESSAGE
        );

        if (proposito != null && !proposito.equals("")) {
            modelo.addElement(proposito);
        }
    }

    public static void eliminarProposito(DefaultListModel<String> modelo, JList<String> lista) {

        if (!lista.isSelectionEmpty()) {
            modelo.remove(lista.getSelectedIndex());
        }
    }

    public static void cargarElementos(DefaultListModel<String> modelo) {
        try {
            FileReader archivoTxt = new FileReader(ruta);
            BufferedReader leyendo = new BufferedReader(archivoTxt);

            String linea = leyendo.readLine();

            while (linea != null) {
                modelo.addElement(linea);
                linea = leyendo.readLine();
            }

            leyendo.close();
            archivoTxt.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Cargando Propósitos",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void guardarElementos(DefaultListModel<String> modelo) {
        try {
            FileWriter archivoTxt = new FileWriter(ruta);
            BufferedWriter escribiendo = new BufferedWriter(archivoTxt);

            for (int i = 0; i < modelo.size(); i++) {
                escribiendo.write(modelo.get(i));
                escribiendo.newLine();
            }

            escribiendo.close();
            archivoTxt.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Guardar Propósitos",
                    JOptionPane.ERROR_MESSAGE);

        }
    }
}

class cellPersonalizada extends DefaultListCellRenderer {

    private Border miBorde = new MatteBorder(0, 0, 1, 0, Color.BLUE);

    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        setBorder(miBorde);

        return c;

    }
}

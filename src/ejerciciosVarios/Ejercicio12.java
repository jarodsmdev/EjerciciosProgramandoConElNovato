/**
 *
 * Ejercicio 43 JAVA - CASCADA DE VENTANAS
 */
package ejerciciosVarios;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejercicio12 {

    public static void main(String[] args) {
        VentanaPrincipal programa = new VentanaPrincipal();
    }
}

class VentanaPrincipal {

    private int x = 0;
    private int y = 0;
    private JFrame marco;
    private ArrayList<JDialog> arrayVentanas = new ArrayList<JDialog>();

    public VentanaPrincipal() {

        marco = new JFrame();

        marco.setSize(350, 250);
        marco.setLocationRelativeTo(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setTitle("Ventanas en Cascada");

        JPanel panel = new JPanel();
        JButton boton = new JButton("Crear Ventana");

        boton.addActionListener(e -> crearVentana());

        panel.add(boton);

        marco.add(panel);
        marco.setVisible(true);
    }

    @SuppressWarnings("empty-statement")
    private void crearVentana() {
        JDialog ventanaSecundaria;

        if (arrayVentanas.isEmpty()) {
            ventanaSecundaria = new JDialog(marco);
        } else {
            ventanaSecundaria = new JDialog(arrayVentanas.get(arrayVentanas.size() - 1));
        }

        ventanaSecundaria.setBounds(x, y, 150, 150);

        //Talvez seria mejor usar la clase WindowAdapter?
        ventanaSecundaria.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                x = ventanaSecundaria.getX();
                y = ventanaSecundaria.getY();
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
        
        arrayVentanas.add(ventanaSecundaria);

        ventanaSecundaria.setVisible(true);

        x += 50;
        y += 50;
    }

}

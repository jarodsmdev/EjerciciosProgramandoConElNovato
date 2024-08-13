/**
 *
 * Ejercicio 42 JAVA - FURIOSO CLIC (2/2)
 */
package furiosoClic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import marcoPanelPersonalizado.FramePersonalizado;
import marcoPanelPersonalizado.PanelPersonalizado;

public class FuriosoClic {

    //Creando Marco Principal
    private FramePersonalizado marcoPrincipal = new FramePersonalizado(300, 300, "Furioso Clic", true);

    //Creando Panel principal y panel inferior.
    private PanelPersonalizado panelPrincipal = new PanelPersonalizado(PanelPersonalizado.BORDERLAYOUT);
    private PanelPersonalizado panelInferior = new PanelPersonalizado(PanelPersonalizado.FLOWLAYOUT);
    private PanelPersonalizado panelSuperior = new PanelPersonalizado(PanelPersonalizado.FLOWLAYOUT);

    //Creando Etiquetas y botón
    private JButton boton = new JButton("Empezar");
    private JLabel etiqClics = new JLabel("0");
    private JLabel etiqSeg = new JLabel("10");

    //Creando contadores de clics y de segundos
    private int clics = 0;
    private int segundos = 10;

    //Creando un Thread
    private Thread hiloJuego;

    //Creando constructor
    public FuriosoClic() {
        montandoPanelSuperior();
        montandoPanelInferior();
        montandoMarco();

        boton.addActionListener(comienzo);
    }

    //Creando ActionListener (Interfaz) -> Clase Interna Anónima
    ActionListener comienzo = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            boton.setText("Click!!!");
            //Desactivar ActionListener comienzo
            boton.removeActionListener(comienzo);

            hiloJuego = new Thread(new LogicaJuego());
            hiloJuego.start();

            //Activar ActionListener jugando
            boton.addActionListener(jugando);
        }
    };

    //Creando ActionListener (Interfaz) -> Clase interna Anónima
    ActionListener jugando = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            clics++;
            etiqClics.setText(String.valueOf(clics));
        }
    };

    private void montandoPanelSuperior() {

        etiqClics.setFont(new Font("Roboto", Font.BOLD, 90));
        panelSuperior.add(etiqClics);
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
    }

    private void montandoPanelInferior() {

        panelInferior.add(boton);
        panelInferior.add(etiqSeg);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
    }

    private void montandoMarco() {

        marcoPrincipal.add(panelPrincipal);
        marcoPrincipal.setVisible(true);
    }

    private void finalizarJuego() {
        boton.setEnabled(false);
        hiloJuego.interrupt();

        ventanaPuntuacion();

        //Resetea el comportamiento del botón
        boton.removeActionListener(jugando);
        boton.addActionListener(comienzo);
        boton.setText("Comenzar");

        etiqClics.setText("0");
        etiqSeg.setText("10");

        segundos = 10;
        clics = 0;

        boton.setEnabled(true);
    }

    private void ventanaPuntuacion() {
        //Ventana de tipo Modal
        JDialog ventanaPuntuacion = new JDialog(marcoPrincipal, "Puntuación", true);
        ventanaPuntuacion.setSize(400, 100);
        ventanaPuntuacion.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());

        StringBuilder sb = new StringBuilder("Has conseguido " + clics + " clics.");

        if (clics < 50) {
            sb.append(" muy Lento.");
        } else if (clics < 100) {
            sb.append(" lo has hecho bastante bien. Qué velocidad.");
        } else {
            sb.append(" felicidades eres muy veloz.");
        }

        JLabel etiqueta = new JLabel();
        
        etiqueta.setText(sb.toString());

        panel.add(etiqueta);
        ventanaPuntuacion.add(panel);

        ventanaPuntuacion.setVisible(true);
    }

    //Clase Interna Anidada privada
    private class LogicaJuego implements Runnable {

        @Override
        public void run() {
            while (segundos > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                segundos--;
                etiqSeg.setText(String.valueOf(segundos));
            }
            finalizarJuego();
        }
    }
}

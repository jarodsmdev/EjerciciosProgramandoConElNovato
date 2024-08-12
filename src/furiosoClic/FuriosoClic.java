/**
 *
 * Ejercicio 42 JAVA - FURIOSO CLIC (1/2)
 */
package furiosoClic;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
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
            
            //Activar ActionListener jugando
            boton.addActionListener(jugando);
        }
    };

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
}

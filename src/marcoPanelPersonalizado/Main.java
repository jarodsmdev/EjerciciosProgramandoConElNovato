/**
 *
 * Ejercicio 41 JAVA - VENTANAS PERSONALIZADAS 
 */
package marcoPanelPersonalizado;

import javax.swing.JButton;

public class Main {

    public static void main(String[] args){
        FramePersonalizado marco = new FramePersonalizado(400, 250, "Ventana", true);
        PanelPersonalizado panel = new PanelPersonalizado(PanelPersonalizado.FLOWLAYOUT);
        
        JButton boton = new JButton("Esto es un botón");
        
        panel.add(boton);
        marco.add(panel);
        
        marco.setVisible(true);
    }
}

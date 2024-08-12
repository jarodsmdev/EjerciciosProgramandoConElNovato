/**
 *
 * Ejercicio 41 JAVA - VENTANAS PERSONALIZADAS 
 */
package marcoPanelPersonalizado;

import javax.swing.JFrame;

public class FramePersonalizado extends JFrame{

    public FramePersonalizado(int ancho, int alto, String titulo, boolean esPrincipal){
        
        setSize(ancho, alto);
        setTitle(titulo);
        setLocationRelativeTo(null);
        
        if(esPrincipal){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}

/**
 *
 * Ejercicio 41 JAVA - VENTANAS PERSONALIZADAS 
 */
package marcoPanelPersonalizado;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;


public class PanelPersonalizado extends JPanel {

    public static final int FLOWLAYOUT = 0;
    public static final int BORDERLAYOUT = 1;
    public static final int GRIDLAOUT = 2;
    
    public PanelPersonalizado(int layoutPorDefecto){
        if(layoutPorDefecto == 1){
            setLayout(new BorderLayout());
        }
        
        if(layoutPorDefecto == 2){
            setLayout(new GridLayout());
        }
    }
    
}

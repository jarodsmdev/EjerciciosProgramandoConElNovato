/**
 *
 * Ejercicio 46 JAVA - CALCULADORA (1/2 Interfaz)
 */

package calculadora;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import marcoPanelPersonalizado.FramePersonalizado;


public class Interfaz {

    private FramePersonalizado marco;
    private JPanel panel;
    private JTextField pantalla;
    private JPanel panelBotones;
    
    public Interfaz(){
        marco = new FramePersonalizado(300, 400, "Calculadora", true);
        panel = new JPanel(new BorderLayout());
        
        colocarPantalla();
        colocarBotones();
        
        marco.add(panel);
        marco.setVisible(true);
    }

    private void colocarPantalla() {
        pantalla = new JTextField("0");
        pantalla.setEditable(false);
        pantalla.setFont(new Font("Arial", Font.BOLD, 50));
        
        panel.add(pantalla, BorderLayout.NORTH);
    }

    private void colocarBotones() {
        panelBotones = new JPanel(new GridLayout(4, 4, 2, 2));
        addBoton("7", "8", "9", "-");
        addBoton("4", "5", "6", "+");
        addBoton("1", "2", "3", "*");
        addBoton(".", "0", "/", "=");
        
        panel.add(panelBotones, BorderLayout.CENTER);
    }
    
    private void addBoton(String... nombre){
        for(int i = 0; i < nombre.length; i++){
            JButton boton = new JButton(nombre[i]);
            boton.setFont(new Font("Arial", Font.BOLD, 20));
            panelBotones.add(boton);
        }
    }
}

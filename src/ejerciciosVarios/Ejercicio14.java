/**
 *
 * Ejercicio 45 JAVA - CREAR JAR por IDE y CONSOLA
 */

package ejerciciosVarios;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Ejercicio14 {

    public static void main(String[] args){
        JFrame marco = new JFrame();
        
        marco.setSize(800, 100);
        marco.setTitle("Ventana Ejecutable");
        marco.setLocationRelativeTo(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        String url = Ejercicio14.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        
        JLabel etiqueta = new JLabel("Ubicación: " + url);
        
        panel.add(etiqueta);
        
        marco.add(panel);
        marco.setVisible(true);
        
    }
}

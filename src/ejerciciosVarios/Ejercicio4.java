/**
 * Ejercicio 27 JAVA - TEMPORIZADOR con sonido.
 */
package ejerciciosVarios;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Ejercicio4 {
    
    static int segundos;
    
    public static void main(String[] args){
        String mensaje = "¿Cuántos segundos deseas poner el temporizador?: ";
        
        segundos = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        
        Timer reloj = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[!] Segundos restantes: " + segundos);
                if(segundos == 0){
                    Toolkit.getDefaultToolkit().beep();
                }
                segundos--;
            }

        });
        
        while(segundos >= 0){
            reloj.start();
        }
        reloj.stop();
    }
}

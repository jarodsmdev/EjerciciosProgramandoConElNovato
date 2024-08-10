/**
 * Ejercicio 34 JAVA - ¡Detén el RELOJ!
 */
package ejerciciosVarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.Timer;

public class Ejercicio9 {
    public static void main(String[] args){
        JuegoContador juego = new JuegoContador();
        juego.comenzar();
    }
}

class JuegoContador{
    private int segundosNecesarios;
    private static int segundos = 0;
    private final Scanner sc = new Scanner(System.in);
    private final Timer reloj = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundos++;
        }
    });
    
    public void getInfo(){
        System.out.println("Te diré una cantidad de segundos.");
        System.out.println("El contador comenzará, pero no lo verás.");
        System.out.println("Deberás pulsar ENTER para deternerlo.");
        System.out.println("Si lo haces en el momento exacto ganarás la partida.");
        
        System.out.println("\nPULSA ENTER PARA COMENZAR");
        sc.nextLine();
    }
    
    public void comenzar(){
        getInfo();
        partida();
        comprobarVictoria();
    }
    
    private void partida(){
        segundosNecesarios = (int) (Math.random() * 5 + 5); //Entre 5 y 10
        
        System.out.println("Detén el reloj en el segundo ¡" + segundosNecesarios + "!");
        reloj.start();
        
        sc.nextLine();
        reloj.stop();
    }
    
    private void comprobarVictoria(){
        if(segundosNecesarios == segundos){
            System.out.println("¡Has Ganado! lo has detenido en el momento exacto.");
        }else{
            System.out.println("¡Has Perdido!  Lo has detenido en el segundo " + segundos);
        }
    }
}

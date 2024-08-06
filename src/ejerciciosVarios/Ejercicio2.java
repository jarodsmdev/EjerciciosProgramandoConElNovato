/**
 * Ejercicio 25 JAVA - BARRIL con AGUA
 */
package ejerciciosVarios;

import java.util.Random;
import javax.swing.JOptionPane;

public class Ejercicio2 {
    public static void main(String[] args){
        
        int capacidad = 0, agua;
        final int ANCHO = 10;
        Random rnd = new Random();
        
        do{
            try{
                capacidad = Integer.parseInt(JOptionPane.showInputDialog("Indica la cantidad del barril"));
            }catch(NumberFormatException e){
                System.out.println("[!] Ingresa un valor numérico");
                e.printStackTrace();
            }
        }while(capacidad == 0);
        
        agua = rnd.nextInt(capacidad + 1);
        
        System.out.println("Capacidad: " + capacidad + " Agua: " + agua);
        
        for(int i = capacidad; i >= 0; i--){
            for(int j = ANCHO; j > 0; j--){
                if(i == 0){
                    System.out.print("*");
                }else{
                    if(j == ANCHO || j == 1){
                        System.out.print("*");
                    }else{
                        if(i <= agua){
                            System.out.print("=");
                        }else{
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}

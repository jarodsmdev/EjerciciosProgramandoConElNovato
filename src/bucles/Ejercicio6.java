/**
 * Ejercicio 15 JAVA - Voltear número
 */
package bucles;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce un número:\n[Contador de cifras e inversión del número]");
        
        long num = sc.nextLong();
        long numReves = 0;
        int contador = 0;
        
        while(num != 0){
            numReves = (numReves * 10) + (num % 10);
            num /= 10;
            
            contador++;
        }
        
        System.out.println("El número al revés es: " + numReves + "\nTiene " + contador + " cifras.");
    }
}

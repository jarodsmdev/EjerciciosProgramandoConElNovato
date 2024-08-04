/**
 * Ejercicio 10 JAVA - Tabla con BUCLES
 */

package bucles;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce un número para visualizar su tabla de multiplicar: ");
        
        int num = sc.nextInt();
        
        for (int i = 1; i <= 10; i++){
            System.out.println(num + " x " + i + " = " + num * i);
        }
    }
}

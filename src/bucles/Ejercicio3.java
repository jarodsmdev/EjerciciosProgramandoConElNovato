/**
 * Ejercicio 12 JAVA - Adivina el NUMERITO
 */

package bucles;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int num, numInt, intentos;
        
        num = (int) Math.round((Math.random() * 99) + 1);
        
        intentos = 0;
        
        System.out.println("Se ha generado un número aleatorio entre 1 y 100");
        System.out.println("Tienes 10 intentos para adivinar");
        
        do{
            System.out.println("Introduce un número: ");
            numInt = sc.nextInt();
            
            if(numInt < num) System.out.println("El número es mayor" );
            if(numInt > num) System.out.println("el número es menor");
            
            intentos++;
        }while(numInt != num && intentos < 10);
        if(numInt != num) System.out.println("No has conseguido adivinar.  El número era: " + num);
        else{
            System.out.println("Has ganado!! En " + intentos + " intentos.");
            System.out.println("░░░░░░░░░░░░░░░░░░░░");
        }
    }
}

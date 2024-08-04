/**
 * Ejercicio 13 JAVA - Media de X números con DO WHILE
 */

package bucles;

import java.util.Scanner;


public class Ejercicio4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int contador = 0;
        double sumaTotal = 0;
        int num;
        
        do{
            System.out.println("█ Introduce un número:\n░ Para salir ingresa -1");
            
            num = sc.nextInt();
            
            if(num >=0){
                contador++;
                sumaTotal += num;
            }
        }while(num >= 0);
        System.out.println("Has introducido " +  contador + " números. La media es: " + sumaTotal/contador);
    }
}

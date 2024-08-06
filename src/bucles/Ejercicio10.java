/**
 * Ejercicio 19 JAVA - ¿Es CAPICÚA?
 */
package bucles;

import java.util.Scanner;


public class Ejercicio10 {
    public static void main(String[] arg){
        
        Scanner sc = new Scanner(System.in);
        
        long num, aux, numReves = 0;
        boolean esCapicua = true;
        
        System.out.println("[+] Introduce un número para validar si es capicúa: ");
        
        num = sc.nextLong();
        aux = num;
        
        while(aux != 0){
            numReves = (numReves * 10) + aux % 10;
            aux /= 10;
        }
        
        while(num != 0){
            if(num % 10 != numReves % 10){
                esCapicua = false;
            }
            num /= 10;
            numReves /= 10;
        }
        
        if(esCapicua){
            System.out.println("[!] El número es capicúa");
        }else{
            System.out.println("[!] El número no es capicúa");
        }
    }
}

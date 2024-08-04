/**
 * Ejercicio 8 JAVA - CALCULAR PRECIO entradas CINE
 */
package condicionales;

import java.util.Scanner;


public class Ejercicio4 {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("¿Cuántas entradas quieres?");
        int nEntradas = sc.nextInt();
        sc.nextLine();
        
        System.out.println("¿Qué dia quieres ir?:");
        String dia = sc.nextLine();
        
        System.out.println("¿Tienes la tarjeta de socio? (S/N)");
        String tarjeta = sc.nextLine();
        
        double precioTotal;
        
        switch (dia.toLowerCase()) {
            case "miercoles":
                precioTotal = nEntradas * 5; //5 ES EL VALOR DE LA ENTRADA
                break;
            case "jueves":
                if (nEntradas % 2 == 0){
                    precioTotal = (nEntradas / 2) * 11; //11 ES EL VALOR 2X1
                }else{
                    precioTotal = (nEntradas / 2) * 11;
                    precioTotal += 8;
                }
                break;
            default:
                precioTotal = nEntradas * 8;
                break;
        }
        
        if(tarjeta.toUpperCase().equals("S")){
            precioTotal -= (precioTotal * 0.10);
        }
        
        System.out.println("Has comprado un total de: " + nEntradas + " entradas. El precio total es de: $" + precioTotal);
    }
}

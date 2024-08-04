/*
 * Ejercicio 5 JAVA - Calcular nota MEDIA alumno
 */
package condicionales;

import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce la primera nota: ");
        double nota1 = sc.nextDouble();
        
        System.out.println("Introduce la segunda nota: ");
        double nota2 = sc.nextDouble();
        
        System.out.println("Introduce la tercera nota: ");
        double nota3 = sc.nextDouble();
        
        double media = (nota1 + nota2 + nota3) / 3;
        
        System.out.println("Tu media es: " + media);
        
        if(media < 5){
            System.out.println("Has suspendido.  Esfuérzate más la próxmima vez");
        }else if(media < 6){
            System.out.println("Has sacado un suficiente.  Almenos no repites");
        }else if(media < 7){
            System.out.println("Bueno.  Tienes un bien.  No está mal.");
        }else if(media < 9){
            System.out.println("Un notable.  Excelente");
        }else if(media < 10){
            System.out.println("Un sobresaliente.  Que orgullo");
        }else if(media == 10){
            System.out.println("Vas a ir a la universidad que te da la gana");
        }else{
            System.out.println("Existe un error.  Escribe bien las notas");
        }
    }
}

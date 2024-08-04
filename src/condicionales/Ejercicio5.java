/**
 * Ejercicio 9 JAVA - Piedra - Papel - Tijeras - Lagarto - Spock
 */
package condicionales;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("¿Qué eliges?\n(Piedra, Papel, Tijera, Lagarto, Spock)");
        
        String eleccion = sc.nextLine();
        
        int num = (int) ((Math.random() * 5) + 1);
        
        String eleccionVS;
        
        switch (num){
            case 1:
                eleccionVS = "Piedra";
                break;
            case 2:
                eleccionVS = "Papel";
                break;
            case 3:
                eleccionVS = "Tijeras";
                break;
            case 4:
                eleccionVS = "Lagarto";
                break;
            default:
                eleccionVS = "Spock";
                break;
        }
        
        if (eleccion.toLowerCase().equals("piedra") && eleccionVS.equals("Tijeras")){
            System.out.println("Has ganado.  Piedra gana a Tijeras");
        }else if (eleccion.toLowerCase().equals("piedra") && eleccionVS.equals("Lagarto")){
            System.out.println("Has ganado.  Piedra gana a Lagarto");
        }else if (eleccion.toLowerCase().equals("papel") && eleccionVS.equals("Piedra")){
            System.out.println("Has ganado.  papel gana a Piedra");
        }else if (eleccion.toLowerCase().equals("tijeras") && eleccionVS.equals("Papel")){
            System.out.println("Has ganado.  Tijeras gana a Papel");
        }else if (eleccion.toLowerCase().equals("tijeras") && eleccionVS.equals("Lagarto")){
            System.out.println("Has ganado.  Tijeras gana a Lagarto");
        }else if (eleccion.toLowerCase().equals("lagarto") && eleccionVS.equals("Papel")){
            System.out.println("Has ganado.  Lagarto gana a Papel");
        }else if (eleccion.toLowerCase().equals("lagarto") && eleccionVS.equals("Spock")){
            System.out.println("Has ganado.  Tijeras gana a Spock");
        }else if (eleccion.toLowerCase().equals("spock") && eleccionVS.equals("Tijeras")){
            System.out.println("Has ganado.  Spock gana a Tijeras");
        }else if (eleccion.toLowerCase().equals("spock") && eleccionVS.equals("Piedra")){
            System.out.println("Has ganado.  Spock gana a Piedra");
        }else if(eleccion.toLowerCase().equals(eleccionVS.toLowerCase())){
            System.out.println("Empate.  Elige mejor la próxima vez.");
        }else{
            System.out.println("Has perdido.  Elegiste: " + eleccion + " y tu contrincante eligió: " + eleccionVS);
        }
    }
}

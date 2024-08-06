/**
 * Ejercicio 21 JAVA - ¿Te tocará la LOTERÍA?
 */
package bucles;

import java.util.Scanner;


public class Ejercicio12 {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int numElegido, diasElegidos;
        
        System.out.println("Elige un número entre 0 y 99999");
        
        numElegido = sc.nextInt();
        
        if(numElegido < 0 || numElegido > 99999){
            System.out.println("Valor ingresado no es válido");
            System.exit(0);
        }
        
        System.out.println("¿Cuántos días quieres jugar?");
        diasElegidos = sc.nextInt();
        
        if(diasElegidos < 1){
            System.out.println("Pues no juegues...");
            System.exit(0);
        }
        
        compruebaNumeros(numElegido, diasElegidos);
    }

    private static void compruebaNumeros(int numElegido, int diasElegidos) {
        
        int numGanador, numSerie, dia = 0;
        double dineroGastado = 0, dineroGanado = 0;
        double valorBoleto = 3.5;
        
        for(int i = 0; i < diasElegidos; i++){
            dia++;
            dineroGastado += valorBoleto;
            
            numSerie = (int) (Math.random() * 20 + 1);
            
            numGanador = (int) (Math.random() * 100000);
            
            if(numElegido == numGanador){
                if(numSerie == 1){
                    System.out.println("Te ha tocado la loteria.  En el día: " + dia);
                    dineroGanado += 1000000;
                }else{
                    System.out.println("Ha salido tu número pero no la serie");
                    dineroGanado += 30000;
                }
            }else if(numElegido % 10 == numGanador % 10){
                dineroGanado += valorBoleto;
            }
            

        }
            System.out.println("Te has gastado: $" + dineroGastado);
            System.out.println("Has ganado: $" +  dineroGanado);
            System.out.println("Balance: $" + (dineroGanado - dineroGastado));
    }
}

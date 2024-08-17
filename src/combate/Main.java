/**
 *
 * Ejercicio 40 JAVA - ¡HÉROE VS VILLANO!
 */
package combate;

public class Main {

    public static void main(String[] args){
        
        Heroe miHeroe = new Heroe("Gokú", 120, 20);
        Villano miVillano = new Villano("Freezer", 150, 14);
        
        System.out.println("Comienza el combate!!!");
        
        while(miHeroe.estaVivo() && miVillano.estaVivo()){
            miHeroe.atacar(miVillano);
            
            if(miVillano.estaVivo()){
                miVillano.atacar(miHeroe);
            }
        }
        
        if(miHeroe.estaVivo()){
            System.out.println(miHeroe.getNombre() + " ha ganado la batalla!!");
        }else{
            System.out.println(miVillano.getNombre() + " ha ganado la batalla");
        }
    }
}

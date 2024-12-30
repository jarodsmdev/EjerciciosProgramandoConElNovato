/**
 *
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 3/10
 */
package miniRPG;

public class Main {

    public static void main(String[] args){
        Personaje heroe = new Personaje("Atreyu", 6, 2, 80);
        VentanaPrincipal juego = new VentanaPrincipal(heroe);
        
        juego.ComenzarJuego();
    }
}

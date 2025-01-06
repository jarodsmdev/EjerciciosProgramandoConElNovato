/**
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 3/10
 * URL: https://www.youtube.com/watch?v=lJtopQrixtA
 */
package miniRPG;

/**
 * @version 05/01/2025
 * @author Jarod Smith
 */
public class Main {

    public static void main(String[] args) {
        Personaje heroe = new Personaje("Atreyu", 6, 2, 80);
        VentanaPrincipal juego = new VentanaPrincipal(heroe);

        juego.ComenzarJuego();
    }
}

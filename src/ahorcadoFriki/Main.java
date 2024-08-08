/**
 * Ejercicio 29 JAVA - El AHORCADO FRIKI 1/3
 */
package ahorcadoFriki;

public class Main {
    public static void main(String[] arg){
        
        Juego juego = new Juego("./src/ahorcadoFriki/palabras.txt");
        
        //juego.mostrarPalabras();
        juego.comenzarPartida();
    }
}

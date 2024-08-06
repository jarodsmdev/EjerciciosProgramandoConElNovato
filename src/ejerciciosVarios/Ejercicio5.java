/**
 * Ejercicio 28 JAVA - JUEGO de AZAR
 */
package ejerciciosVarios;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Juego juego = new Juego();
        
        juego.empezarPartida();
    }
}

class Juego {

    private int puntos, ronda, num, numTemp;
    private Scanner sc = new Scanner(System.in);
    private String respuesta;

    public Juego() {

        puntos = 0;
        ronda = 1;
        num = (int) (Math.random() * 100) + 1;
    }

    public void empezarPartida() {
        System.out.println("[+] ¿Sabes jugar?: (Sí/No)");
        respuesta = sc.next().toLowerCase();

        if (respuesta.equals("no")) {
            mostrarInstrucciones();
        }
        while (rondaActual());

        finalPartida();
    }

    private void mostrarInstrucciones() {
        String mensaje = "Voy a mostrar un número entre 1 y 100."
                + "\nDeberás decir si el siguiente será menor o mayor o igual (Este último tiene mayor puntaje)."
                + "\nSi aciertas ganarás puntos.  Si fallas acabará la partida."
                + "\nLos puntos serán igual a la ronda actual (Por ejemplo en la 4ta ronda obtendrás 4 puntos).";
        System.out.println(mensaje);
    }

    private boolean rondaActual() {
        System.out.println("El número actual es el: " + num
                + "\n¿El siguiente será menor o mayor o igual?: ");

        respuesta = sc.next().toLowerCase();

        if (comprobar()) {

            if (numTemp == num) {
                puntos += (ronda * 50);
            }

            puntos += ronda;
            ronda++;
            num = numTemp;

            System.out.println("Has acertado.  El nuevo número es el: " + num
                    + "\nLlevas " + puntos + " puntos.\n");
            return true;

        } else {
            System.out.println("Has perdido.  El nuevo número era el: " + numTemp);
            return false;
        }

    }

    private boolean comprobar() {
        numTemp = (int) (Math.random() * 100) + 1;

        while (true) {
            if (respuesta.equals("menor")) {
                if (numTemp < num) {
                    return true;
                } else {
                    return false;
                }
            }

            if (respuesta.equals("mayor")) {
                if (numTemp > num) {
                    return true;
                } else {
                    return false;
                }
            }

            if (respuesta.equals("igual")) {
                if (numTemp == num) {
                    return true;
                } else {
                    return false;
                }
            }

            System.out.println("[!] Escribe bien si es Menor o Mayor");
            respuesta = sc.next().toLowerCase();
        }

    }

    private void finalPartida() {
        System.out.println("Has llegado hasta la ronda " + ronda
                + "\nTu puntuación final es de: " + puntos + " puntos.");

        if (puntos < 10) {
            System.out.println("Mala suerte!!");
        } else if (puntos < 50) {
            System.out.println("Éxito que buen puntaje!!");
        } else {
            System.out.println("Felicidades");
        }
    }
}

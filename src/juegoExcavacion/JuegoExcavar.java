/**
 *
 * Ejercicio 37 JAVA - JUEGO de EXCAVACIÓN
 */
package juegoExcavacion;

import java.util.Scanner;

public class JuegoExcavar {

    private static int derrumbe = 1;
    private static int diamante = 1;

    private int carbon = 0, oro = 0, diamantes = 0;

    private static boolean derrumbado = false;
    private static boolean jugando = true;

    private final Scanner sc = new Scanner(System.in);

    public void jugar() {
        while (derrumbado == false && jugando == true) {
            menuEleccion();
        }

        finalPartida();
    }

    private void menuEleccion() {
        mostrarMateriales();

        System.out.println("Elige una opción: ");
        System.out.println("1. Seguir cavando");
        System.out.println("2. Retirarme");

        int eleccion = sc.nextInt();

        switch (eleccion) {
            case 1:
                cavar();
                break;
            case 2:
                jugando = false;
                break;
            default:
                System.out.println("Valor ingresado no es válido");
                break;
        }
    }

    private void cavar() {
        int d = (int) (Math.random() * 100 + 1);

        if (d <= derrumbe) {
            derrumbado = true;
            System.out.println("¡Se ha derrumbado el túnel!");
        } else {
            int material = (int) (Math.random() * 100 + 1);

            if (material <= diamante) {
                diamantes++;
                System.out.println("¡Has encontrado un diamante!");
            } else if (material <= (20 + diamante)) {
                oro++;
                System.out.println("¡Has encontrado oro!");
            } else {
                carbon++;
                System.out.println("¡Has encontrado carbón!");
            }

            derrumbe++;
            diamante++;
        }
    }

    private void finalPartida() {
        if (derrumbado) {
            System.out.println("Se ha derrumbado todo.  Fin de la partida");
        } else {
            System.out.println("Has logrado salir sin que se haya derrumbado todo");
            System.out.println("Has conseguido: " + carbon + " kilos de carbón. [" + carbon + "] puntos");
            System.out.println("Has conseguido: " + oro + " kilos de oro. [" + oro * 10 + "] puntos");
            System.out.println("Has conseguido: " + diamantes + " kilos de diamantes. [" + diamantes * 50 + "] puntos");
            int total = carbon + (oro * 10) + (diamantes * 50);

            tablaPuntuacion(total);
        }
    }

    private void tablaPuntuacion(int total) {
        System.out.println("Tu puntuación total es de " + total + " puntos");

        if (total < 100) {
            System.out.println("Tu esfuerzo ha rendido frutos, pero apenas has arañado la superficie. ¡Sigue excavando, la verdadera riqueza aún está enterrada más profundo!");
        } else if (total < 500) {
            System.out.println("¡Buen trabajo! Has descubierto un tesoro decente, pero hay mucho más esperando por ti bajo la tierra. ¡No te detengas ahora!");
        } else {
            System.out.println("¡Felicidades, maestro excavador! Has encontrado un tesoro legendario digno de las historias más grandiosas. ¡Eres un verdadero cazador de tesoros!");
        }
    }

    private void mostrarMateriales() {
        System.out.println("Carbón: " + carbon + " - Oro: " + oro + " - Diamante: " + diamantes);
    }
}

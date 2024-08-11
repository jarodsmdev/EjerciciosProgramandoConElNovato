/**
 *
 * Ejercicio 39 JAVA - INVOCACIÓN MONSTRUOSA
 */
package monstruosHalloween;

public class Invocador {

    private int energia;

    public Invocador(int energia) {
        this.energia = energia;
    }

    public Monstruo invocar(Monstruo m) {
        if (m.getCosteInvocacion() <= energia) {

            energia -= m.getCosteInvocacion();
            System.out.println("Invocación exitosa!! quedan " + energia + " puntos de energía");
            return m;
        } else {
            System.out.println("No es posible invocar un monstruo sin energia");
            System.out.println("Has sido derrotado!!!");
            return null;
        }
    }
}

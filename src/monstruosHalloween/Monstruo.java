/**
 *
 * Ejercicio 39 JAVA - INVOCACIÓN MONSTRUOSA
 */
package monstruosHalloween;

public class Monstruo {

    private String nombre;
    private int costeInvocacion;
    private boolean vivo = true;

    public Monstruo(String nombre, int costeInvocacion) {
        this.nombre = nombre;
        this.costeInvocacion = costeInvocacion;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosteInvocacion() {
        return costeInvocacion;
    }

}

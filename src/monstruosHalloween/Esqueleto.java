/**
 *
 * Ejercicio 39 JAVA - INVOCACIÓN MONSTRUOSA
 */
package monstruosHalloween;

public class Esqueleto extends Monstruo{

    private int huesosActuales = 206;
    
    public Esqueleto(String nombre, int costeInvocacion) {
        super(nombre, costeInvocacion);
    }
    
    public void lanzarHuesos(int cantidad){
        if(isVivo()){
            if(cantidad > huesosActuales){
                cantidad = huesosActuales;
            }
            huesosActuales -= cantidad;
            System.out.println("\n" + getNombre() + " ha lanzado " + cantidad + " de huesos");
            System.out.println("Le quedan " + huesosActuales + " huesos.");
            
            if(huesosActuales == 0){
                setVivo(false);
                System.out.println(getNombre() + " ha sido derrotado");
            }
        }else{
            System.out.println(getNombre() + " está derrotado.");
        }
    }
}

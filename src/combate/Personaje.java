/**
 *
 * Ejercicio 40 JAVA - ¡HÉROE VS VILLANO!
 */
package combate;

public interface Personaje {

    public void atacar(Personaje objetivo);
    
    public void recibirDamage(int cantidad);
    
    public boolean estaVivo();
    
    public String getNombre();
}

/**
 *
 * Ejercicio 40 JAVA - ¡HÉROE VS VILLANO!
 */
package combate;

import java.util.Random;

public class PersonajeBase implements Personaje {

    protected String nombre;
    protected int vida, ataque;
    protected Random aleatorio = new Random();

    public PersonajeBase(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    @Override
    public void atacar(Personaje objetivo) {
        
    }

    @Override
    public void recibirDamage(int cantidad) {
        vida -= cantidad;
        if(vida < 0){
            vida = 0;
        }
        System.out.println(nombre + " recibe " + cantidad + " de daño. Le quedan " + vida + " puntos de vida");
    }

    @Override
    public boolean estaVivo() {
        return vida != 0; // return vida > 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

}

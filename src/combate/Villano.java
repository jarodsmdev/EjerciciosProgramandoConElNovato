/**
 *
 * Ejercicio 40 JAVA - ¡HÉROE VS VILLANO!
 */
package combate;

public class Villano extends PersonajeBase {

    public Villano(String nombre, int vida, int ataque) {
        super(nombre, vida, ataque);
    }

    public void atacar(Personaje objetivo) {
        int damage;

        if (aleatorio.nextInt(10) != 0) {
            damage = aleatorio.nextInt(ataque);
            System.out.println("\n" + nombre + " ataca a " + objetivo.getNombre() + " causando " + damage + " puntos de daños");
            objetivo.recibirDamage(damage);
        }else{
            vida += 25;
            System.out.println("\n" + nombre + " se ha regenerado 25 puntos de vida gracias a su habilidad especial");
        }
    }

}

/**
 *
 * Ejercicio 40 JAVA - ¡HÉROE VS VILLANO!
 */
package combate;

public class Heroe extends PersonajeBase{

    public Heroe(String nombre, int vida, int ataque) {
        super(nombre, vida, ataque);
    }

    @Override
    public void atacar(Personaje objetivo){
        int damage;
        
        if(aleatorio.nextInt(10) != 0){
            damage = aleatorio.nextInt(ataque);
        }else{
            damage = aleatorio.nextInt(ataque) * 3;
        }
        
        System.out.println("\n" + nombre + " ataca a " + objetivo.getNombre() + " causando " + damage + " puntos de daños");
        objetivo.recibirDamage(damage);
    }
}

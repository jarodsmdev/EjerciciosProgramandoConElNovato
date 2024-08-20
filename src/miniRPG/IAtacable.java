/**
 *
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 1
 */
package miniRPG;

public interface IAtacable {

    public void atacar(IAtacable enemigo);
    public void recibirHerida(int cantidad);
}

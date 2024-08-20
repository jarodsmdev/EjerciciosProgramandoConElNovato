/**
 *
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 2/10
 */
package miniRPG;

public interface IAtacable {

    public void atacar(IAtacable enemigo);
    public void recibirHerida(int cantidad);
}

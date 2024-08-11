/**
 *
 * Ejercicio 39 JAVA - INVOCACIÓN MONSTRUOSA
 */
package monstruosHalloween;

public class Main {

    public static void main(String[] args){
        
        Invocador invocador = new Invocador(100);
        
        Esqueleto miEsqueleto = (Esqueleto) invocador.invocar(new Esqueleto("Huesitos", 50));
        
        miEsqueleto.lanzarHuesos(100);
        miEsqueleto.lanzarHuesos(200);
        miEsqueleto.lanzarHuesos(1);
        
        Zombie miZombie = (Zombie) invocador.invocar(new Zombie("Cerebrito", 50));
        
        miZombie.comerCerebros();
        
        Zombie miZombie2 = (Zombie) invocador.invocar(new Zombie("Cerebrito 2", 50));
        
    }
}

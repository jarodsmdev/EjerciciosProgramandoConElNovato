/**
 *
 * Ejercicio 39 JAVA - INVOCACIÓN MONSTRUOSA
 */
package monstruosHalloween;


public class Zombie extends Monstruo{
    
    private int cerebrosComidos = 0;

    public Zombie(String nombre, int costeInvocacion) {
        super(nombre, costeInvocacion);
    }
    
    public void comerCerebros(){
        
        while(isVivo()){
            int n = (int) Math.round(Math.random() * 10);
            
            if(n != 10){
                cerebrosComidos++;
            }else{
                setVivo(false);
            }
        }
        
        System.out.println("\nZombie derrotado!! " + getNombre() + " ha logrado comer " + cerebrosComidos + " cerebros");
    }

}

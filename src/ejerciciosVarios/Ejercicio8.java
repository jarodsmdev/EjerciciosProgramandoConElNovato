/**
 * Ejercicio 33 JAVA - CARRERA DE VEHICULOS
 */
package ejerciciosVarios;

public class Ejercicio8 {
    
    public static void main(String[] args){
        
        Vehiculo uno = new Vehiculo("Coche");
        Vehiculo dos = new Vehiculo("Moto");
        Vehiculo tres = new Vehiculo("Caracol de carreras");
        
        uno.start();
        dos.start();
        tres.start();
    }
}

class Vehiculo extends Thread{
    
    private int dRecorrida = 0;
    
    public Vehiculo(String nombre){
        setName(nombre); //setName: Le da un nombre al 'Hilo'
    }
    
    @Override
    public void run(){
        
        while(true){
            try {
                Thread.sleep((long) (Math.random() * 400) + 100);
                dRecorrida += 10;
                System.out.println(getName() + " ha recorrido " + dRecorrida + " metros.");

                if(dRecorrida >= 100){
                    System.out.println(getName() + " ha alcanzado la meta. !Es el ganador!");
                    System.exit(0);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
}
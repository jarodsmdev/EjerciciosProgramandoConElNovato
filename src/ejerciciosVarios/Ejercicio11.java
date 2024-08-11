/**
 *
 * Ejercicio 38 JAVA - MONEDERO VIRTUAL
 */
package ejerciciosVarios;

import java.util.ArrayList;

public class Ejercicio11 {
    
    public static void main(String[] args) {
        Monedero monedero = new Monedero();
        monedero.agregarMoneda("1 Euro");
        monedero.agregarMoneda("100 Pesos");
        monedero.agregarMoneda("2 Soles");
        monedero.agregarMoneda("50 Yenes");
        monedero.agregarMoneda("10 Centavos");
        
        monedero.verMonedas();
        System.out.println();
        
        monedero.vaciarMonedero();
        
        System.out.println();
        monedero.verMonedas();
    }
}

class Monedero {
    
    ArrayList<Monedas> monedero = new ArrayList<Monedas>();
    
    public void agregarMoneda(String nombre) {
        monedero.add(new Monedas(nombre));
    }
    
    public void verMonedas() {
        
        if (monedero.size() == 0) {
            System.out.println("No tienes monedas en el monedero!!");
        } else {
            for (Monedas m : monedero) {
                System.out.println(m);
            }
        }
    }
    
    public void vaciarMonedero() {
        int n = monedero.size();
        for (int i = 0; i < n; i++) {
            monedero.get(0).lanzar();
            monedero.remove(0);
        }
    }
}

class Monedas {
    
    String nombre;
    
    public Monedas(String nombre) {
        this.nombre = nombre;
    }
    
    public void lanzar() {
        int n = (int) Math.round(Math.random());
        
        if (n == 1) {
            System.out.println(nombre + " - Cara");
        } else {
            System.out.println(nombre + " - Cruz");
        }
    }
    
    @Override
    public String toString() {
        return "Tienes una moneda de " + nombre;
    }
}

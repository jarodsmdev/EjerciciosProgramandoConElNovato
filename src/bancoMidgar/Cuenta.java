/**
 * Ejercicio 31 JAVA - Banco de MIDGAR
 */
package bancoMidgar;

import java.util.Random;

public class Cuenta {
    private String nombreUsuario;
    private int numCuenta;
    private double saldo;
            
    public Cuenta(String nombreUsuario, double saldo){
        this.nombreUsuario = nombreUsuario;
        this.saldo = saldo;
        
        Random random = new Random();
        numCuenta = random.nextInt();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "Nombre: " + nombreUsuario + ", Numero Cuenta: " + numCuenta + ", Saldo: " + saldo + '}';
    }
}

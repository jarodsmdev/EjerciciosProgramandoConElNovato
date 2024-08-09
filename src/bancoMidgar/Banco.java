/**
 * Ejercicio 31 JAVA - Banco de MIDGAR
 */
package bancoMidgar;

import java.util.ArrayList;

public class Banco {
    private String nombre;
    private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
    
    public Banco(String nombre){
        this.nombre = nombre;
    }
    
    public Cuenta abrirCuenta(String nombreUsuario, double saldoInicial){
        Cuenta cuenta = new Cuenta(nombreUsuario, saldoInicial);
        cuentas.add(cuenta);
        
        return cuenta;
    }
    
    public void trasferencia(Cuenta origen, Cuenta destino, double cantidad){
        if(origen.getSaldo() >= cantidad){
            origen.setSaldo(origen.getSaldo() - cantidad);
            destino.setSaldo(destino.getSaldo() + cantidad);
            
            System.out.println("Se han transferido " + cantidad + " guiles de la cuenta " + origen.getNumCuenta() + " a " + destino.getNumCuenta());
        }else{
            System.out.println("No se ha podido trasferir la cantidad indicada por falta de fondos");
        }
    }
    
    public void mostrarCuentas(){
        for(Cuenta c: cuentas){
            System.out.println(c);
        }
    }
}

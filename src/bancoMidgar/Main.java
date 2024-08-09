/**
 * Ejercicio 31 JAVA - Banco de MIDGAR
 */
package bancoMidgar;


public class Main {
    public static void main(String[] args){
        Banco bMidgar = new Banco("Caja Shinra");
        Cuenta c1 = bMidgar.abrirCuenta("Víctor", 25000);
        Cuenta c2 = bMidgar.abrirCuenta("Aerith", 2700);
        
        bMidgar.trasferencia(c1, c2, 5000);
        
        System.out.println();
        
        bMidgar.trasferencia(c2, c1, 100000);
        
        System.out.println("\n\n");
        
        bMidgar.mostrarCuentas();
    }

    
}

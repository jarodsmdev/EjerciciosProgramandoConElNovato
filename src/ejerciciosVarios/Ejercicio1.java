/**
 * Ejercicio 24 JAVA - Escribir/leer archivo TXT
 */
package ejerciciosVarios;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args){
        
        try {
            FileWriter archivo = new FileWriter("./src/ejerciciosVarios/primerTexto.txt");
            
            archivo.write("Primera línea\n");
            archivo.write("Segunda línea\n");
            
            archivo.close();
            
            FileReader archivoLectura = new FileReader("./src/ejerciciosVarios/primerTexto.txt");
            BufferedReader leyendo = new BufferedReader(archivoLectura);
            
            String linea = leyendo.readLine();
            
            while(linea != null){
                System.out.println(linea);
                linea = leyendo.readLine();
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

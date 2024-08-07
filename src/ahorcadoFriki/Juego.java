/**
 * Ejercicio 29 JAVA - El AHORCADO FRIKI 1/3
 */
package ahorcadoFriki;

import java.io.*;

public class Juego {
    FileReader archivo;
    BufferedReader archivoLeido;
    String[] palabras;
    
    public Juego(String rutaArchivo){
        try {
            archivo = new FileReader(rutaArchivo);
            archivoLeido = new BufferedReader(archivo);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        rellenaPalabras();
    }

    private void rellenaPalabras() {
        try {
            palabras = archivoLeido.readLine().split(",");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void mostrarPalabras(){
        for(int i = 0; i < palabras.length; i++){
            System.out.println(palabras[i]);
        }
    }
}



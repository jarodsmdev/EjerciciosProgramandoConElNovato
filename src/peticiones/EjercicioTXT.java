/**
 *
 * Ejercicio 48 JAVA - Uniendo Archivos TXT
 */
package peticiones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class EjercicioTXT {

    public static void main(String[] args){
        Leyendo txt1 = new Leyendo("./src/peticiones/archivos/datos.txt");
        Leyendo txt2 = new Leyendo("./src/peticiones/archivos/trabajo.txt");
        
        String texto1 = txt1.obteniendoTexto();
        String texto2 = txt2.obteniendoTexto();
        
        Escribiendo nuevoTXT = new Escribiendo("./src/peticiones/archivos/", "datosCompletos", texto1, texto2);
        nuevoTXT.escribirTXT();
    }
}

class Leyendo{
    
    private String rutaConNombre;
    
    public Leyendo(String ruta){
        this.rutaConNombre = ruta;
    }
    
    public String obteniendoTexto(){
        try{
            FileReader archivo = new FileReader(rutaConNombre);
            BufferedReader leyendo = new BufferedReader(archivo);
            
            String linea = leyendo.readLine();
            
            String[] datos = linea.split(";");
            
            String datosSeparados = separarDatos(datos);
            
            leyendo.close();
            archivo.close();
            
            System.out.println("[!] Datos del archivo leídos correctamente!");
            return datosSeparados;
        }catch(IOException e){
            System.out.println("[!] Error al leer el archivo. Descripción: " + e.getMessage());
            return null;
        }
        
    }

    private String separarDatos(String[] datos) {
        String texto = "";
        
        for(String s: datos){
            texto += s + "\n";
        }
        
        return texto;
    }
}

class Escribiendo{
    private String ruta;
    private String nombre;
    private String[] textos;
    
    public Escribiendo(String ruta, String nombre, String... textos){ //Recibe entre 0 a más "textos" se transforma en un array
        this.ruta = ruta;
        this.nombre = nombre;
        this.textos = textos;
    }
    
    public void escribirTXT(){
        try{
            FileWriter escribir = new FileWriter(ruta + nombre + ".txt");
            
            for(String dato: textos){
                escribir.write(dato);
            }
            
            escribir.close();
            
            System.out.println("[!] Escritura realizada correctamente!");
        }catch(IOException e){
            System.out.println("[!] Ha ocurrido un error.  Descripción: " + e.getMessage());
        }
    }
}

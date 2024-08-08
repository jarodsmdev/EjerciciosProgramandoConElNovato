/**
 * Ejercicio 29 JAVA - El AHORCADO FRIKI 2/3
 */
package ahorcadoFriki;

import java.io.*;
import java.util.Scanner;

public class Juego {
    Scanner sc = new Scanner(System.in);
    FileReader archivo;
    BufferedReader archivoLeido;
    String[] palabras;
    String palabraActual;
    char[] palabraOculta;
    int fallos = 0;
    char letra;
    boolean letraEncontrada, hasGanado;
    
    public Juego(String rutaArchivo){
        try {
            archivo = new FileReader(rutaArchivo);
            archivoLeido = new BufferedReader(archivo);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        rellenaPalabras();
        eligePalabra();
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

    private void eligePalabra() {
        int num = (int) (Math.random() * palabras.length);
        
        palabraActual = palabras[num];
        
        ocultaPalabra();
    }

    private void ocultaPalabra() {
        palabraOculta = new char[palabraActual.length()];
        
        for(int i = 0; i < palabraOculta.length; i++){
            palabraOculta[i] = '_';
        }
    }
    
    public void comenzarPartida(){
        while(fallos <= 5){
            mostrarPalabra();
            eligeLetra();
            comprobarGanar();
        }
        hasPerdido();
    }

    private void mostrarPalabra() {
        
        System.out.println();
        
        for(char c: palabraOculta){
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private void eligeLetra() {
        System.out.print("[+]¿Qué letra eliges?: ");
        letra = sc.next().charAt(0); //Sólo lee o guarda la primera letra escrita por el usuario
        
        compruebaLetra();
        if(letraEncontrada == false){
            hasFallado();
        }
    }

    private void compruebaLetra() {
        
        letraEncontrada = false;
        
        for(int i = 0; i < palabraOculta.length; i++){
            if(palabraActual.charAt(i) == letra && palabraOculta[i] == '_'){
                palabraOculta[i] = letra;
                letraEncontrada = true;
            }
        }
    }

    private void hasFallado() {
        System.out.println("Has fallado!");
        fallos++;
    }

    private void comprobarGanar() {
        hasGanado = true;
        
        for(int i = 0; i < palabraOculta.length; i++){
            if(palabraOculta[i] == '_'){
                hasGanado = false;
            }
        }
        
        if(hasGanado){
            System.out.println("[!] Felicidades has ganado: " + palabraActual);
            System.out.println("Has tenidos " +  fallos + " fallos.");
        }
    }

    private void hasPerdido() {
        System.out.println("[!] Has perdido!!. La palabra era: " + palabraActual);
    }
}



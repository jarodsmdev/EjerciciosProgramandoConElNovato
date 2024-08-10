/**
 *
 * Ejercicio 35 JAVA - Agenda de SUPERHÉROES (Parte 1/2)
 */
package agendaHeroes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Agenda {
    private ArrayList<Superheroe> agenda = new ArrayList<Superheroe>();
    private final Scanner sc = new Scanner(System.in);
    
    public void iniciarAgenda(){
        leerDatosGuardados();
        menu();
    }

    private void leerDatosGuardados() {
        try {
            FileReader leerArchivo = new FileReader("./src/agendaHeroes/agenda.txt");
            
            BufferedReader leyendo = new BufferedReader(leerArchivo);
            
            String linea = leyendo.readLine();
            
            while(linea != null){
                String[] lineaSeparada = linea.split(";");
                agenda.add(new Superheroe(lineaSeparada[0], lineaSeparada[1], lineaSeparada[2]));
                linea = leyendo.readLine();
            }
            
            leyendo.close();
            leerArchivo.close();
       
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void menu() {
        System.out.println("Elige una opción: ");
        System.out.println("1. Añadir un nuevo héroe.");
        System.out.println("2. Ver héroes guardados.");
        System.out.println("3. Salir.");
        
        int n = sc.nextInt();
        
        switch(n){
            case 1:
                addHeroe();
                break;
            case 2:
                verHeroes();
                break;
            case 3:
                guardarHeroes();
                break;
            default:
                System.out.println("El valor ingresado no es correcto");
                menu(); //Recursividad
                break;
        }
    }

    private void addHeroe() {
    }

    private void verHeroes() {
    }

    private void guardarHeroes() {
    }
}

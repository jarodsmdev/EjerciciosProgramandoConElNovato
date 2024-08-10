/**
 *
 * Ejercicio 35 JAVA - Agenda de SUPERHÉROES (Parte 2/2)
 */
package agendaHeroes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    private final String RUTA_ARCHIVO = "./src/agendaHeroes/agenda.txt";
    private ArrayList<Superheroe> agenda = new ArrayList<Superheroe>();
    private final Scanner sc = new Scanner(System.in);

    public void iniciarAgenda() {
        leerDatosGuardados();
        menu();
    }

    private void leerDatosGuardados() {
        try {
            FileReader leerArchivo = new FileReader(RUTA_ARCHIVO);

            BufferedReader leyendo = new BufferedReader(leerArchivo);

            String linea = leyendo.readLine();

            while (linea != null) {
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
        System.out.println("    1. Añadir un nuevo héroe.");
        System.out.println("    2. Ver héroes guardados.");
        System.out.println("    3. Salir.");

        int n = sc.nextInt();

        switch (n) {
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
        sc.nextLine();
        String nombre, descripcion, direccion;

        System.out.println("Introduce nombre: ");
        nombre = sc.nextLine();

        System.out.println("Introduce descripción: ");
        descripcion = sc.nextLine();

        System.out.println("Introduce dirección: ");
        direccion = sc.nextLine();

        agenda.add(new Superheroe(nombre, descripcion, direccion));

        menu();
    }

    private void verHeroes() {
        if (agenda.size() == 0) {
            System.out.println("[!] No hay héroes actualmente.\n");
            menu();
        } else {
            for (Superheroe sh : agenda) {
                System.out.println(sh);
            }
            System.out.println();
        }
        
        menu();
    }

    private void guardarHeroes() {
        
        try {
            FileWriter escribiendoArchivo = new FileWriter(RUTA_ARCHIVO);
            
            System.out.println("Héroes a guardar: " + agenda.size());
            
            for(Superheroe sh: agenda){
                escribiendoArchivo.write(sh.getNombre() + ";" + sh.getDescripcion() + ";" + sh.getDireccion() + "\n");
            }
            
            escribiendoArchivo.close();
            
            System.out.println("Datos guardados correctamente!");
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

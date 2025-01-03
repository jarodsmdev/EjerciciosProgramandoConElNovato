/**
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 5/10
 * URL: https://youtu.be/1BPGccr-UZE?si=U6kPkqh_fQ4thX0m
 */
package miniRPG;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @version 03/01/2025
 * @author Jarod Smith
 */
public class Monstruo extends Entidad {

    private int premioOro;
    private int premioExp;

    private JLabel etNombre;
    private JLabel imagen;

    private static String[] nombresFacil = {"Lobo", "Esqueleto", "Zombie"};
    private static String[] nombresMedio = {"Troll", "Golem", "Gargola"};
    private static String[] nombresDificil = {"Brujo", "Momia", "Demonio"};

    public Monstruo(String nombre, int ataque, int defensa, double vidaMax, String dificultad) {
        super(nombre, ataque, defensa, vidaMax);

        etNombre = new JLabel(nombre);
        etNombre.setFont(new Font("Roboto", Font.BOLD, 20));
        String rutaImagen = "./resources/miniRPG/imagenes/" + nombre.toLowerCase() + ".jpg";
        imagen = new JLabel();
        //imagen.setIcon(new ImageIcon(rutaImagen));
        int ancho = 200;
        int alto = 200;
        
        ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
        
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(alto, ancho, Image.SCALE_SMOOTH);
        
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        imagen.setIcon(iconoEscalado);

        switch (dificultad) {
            case "facil":
                premioExp = (int) (Math.random() * 2 + 1);
                premioOro = (int) (Math.random() * 5 + 1);
                etNombre.setForeground(Color.GREEN);
                break;
            case "medio":
                premioExp = (int) (Math.random() * 6 + 2);
                premioOro = (int) (Math.random() * 20 + 1);
                etNombre.setForeground(Color.GREEN);
                break;
            case "dificil":
                premioExp = (int) (Math.random() * 16 + 5);
                premioOro = (int) (Math.random() * 50 + 1);
                etNombre.setForeground(Color.GREEN);
                break;
            default:
                premioExp = (int) (Math.random() * 500 + 1);
                premioOro = (int) (Math.random() * 1000 + 1);
                etNombre.setForeground(Color.GREEN);
        }
    }

    public static Monstruo generaMonstruo(int numExploracion) {
        Monstruo monstruo;

        int nMonstruo = (int) (Math.random() * 3); //Entre 0 y 2
        int nVida = (int) (Math.random() * 30); //Entre 0 y 30;
        int vAtaque = (int) (Math.random() * 5);
        int nDefensa = (int) (Math.random() * 2);

        if (numExploracion < 80) {
            monstruo = new Monstruo(nombresFacil[nMonstruo], vAtaque + 1, nDefensa, nVida + 15, "facil");
        } else if (numExploracion < 140) {
            monstruo = new Monstruo(nombresMedio[nMonstruo], vAtaque + 4, nDefensa + 2, nVida + 30, "medio");
        } else if (numExploracion < 200) {
            monstruo = new Monstruo(nombresDificil[nMonstruo], vAtaque + 8, nDefensa + 5, nVida + 80, "dificil");
        }else{
            monstruo = new Monstruo("jefe", vAtaque + 10, nDefensa + 10, nVida + 150, "jefe");
        }
        
        return monstruo;
    }

    public int getPremioOro() {
        return premioOro;
    }

    public int getPremioExp() {
        return premioExp;
    }

    public JLabel getEtNombre() {
        return etNombre;
    }

    public JLabel getImagen() {
        return imagen;
    }

}

/*
 * Ejercicio 53 JAVA - ¡JUEGO DE MEMORIA!
 * URL: https://youtu.be/01CcGdYjR2w?list=PL0OKXi7iFPGqMMU78vaCvtSAOjS1ZNxbK
 */
package ejerciciosVarios;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @version 07/01/2025
 * @author Jarod Smith
 */
public class Ejercicio18 {

    public static void main(String[] args) {
        InterfazJuegoMemory juegoMemory = new InterfazJuegoMemory();
    }
}

class InterfazJuegoMemory extends JFrame {

    public InterfazJuegoMemory() {
        // Aca agregaremos en panel
        add(new PanelJuegoMemory());

        //Configura el JFrame
        setTitle("Juego Memory");
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class PanelJuegoMemory extends JPanel {

    private ArrayList<CuadradoMemory> cuadrados;

    public PanelJuegoMemory() {
        setLayout(new GridLayout(4, 4));

        // Acá agregaremos los botones
        cuadrados = CuadradoMemory.generaCuadrados();

        // Agregar los elementos al JPanel
        for (CuadradoMemory c : cuadrados) {
            add(c);
        }
    }
}

class CuadradoMemory extends JButton {

    private Color[] colores = {
        Color.GREEN, Color.GREEN,
        Color.BLUE, Color.BLUE,
        Color.RED, Color.RED,
        Color.BLACK, Color.BLACK,
        Color.YELLOW, Color.YELLOW,
        Color.MAGENTA, Color.MAGENTA,
        Color.PINK, Color.PINK,
        Color.GRAY, Color.GRAY
    };
    private int numBoton;
    private static int numStatic = 0;

    public CuadradoMemory() {
        numBoton = numStatic;
        numStatic++;
        setBackground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addActionListener(e -> compruebaPareja());
    }

    public static ArrayList<CuadradoMemory> generaCuadrados() {
        ArrayList<CuadradoMemory> lista = new ArrayList();

        for (int i = 0; i < 16; i++) {
            lista.add(new CuadradoMemory());
        }

        Collections.shuffle(lista);

        return lista;
    }

    private void compruebaPareja() {
        setBackground(colores[numBoton]);
    }

}

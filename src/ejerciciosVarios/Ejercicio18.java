/*
 * Ejercicio 53 JAVA - ¡JUEGO DE MEMORIA!
 * URL: https://youtu.be/01CcGdYjR2w?list=PL0OKXi7iFPGqMMU78vaCvtSAOjS1ZNxbK
 */
package ejerciciosVarios;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

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
        cuadrados = CuadradoMemory.generaCuadrados(this);

        // Agregar los elementos al JPanel
        for (CuadradoMemory c : cuadrados) {
            add(c);
        }
    }

    public void botonesEncendidos(boolean opcion) {
        for (CuadradoMemory c : cuadrados) {
            if (c.getBackground() == Color.WHITE) {
                c.setEnabled(opcion);
            }
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
    private static int numClics = 0;
    private static int numStatic = 0;
    private static int parejas = 0;
    private static CuadradoMemory boton1;
    private static CuadradoMemory boton2;
    private PanelJuegoMemory panel;

    public CuadradoMemory(PanelJuegoMemory panel) {
        this.panel = panel;
        numBoton = numStatic;
        numStatic++;
        setBackground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addActionListener(e -> compruebaPareja());
    }

    public static ArrayList<CuadradoMemory> generaCuadrados(PanelJuegoMemory panel) {
        ArrayList<CuadradoMemory> lista = new ArrayList();

        for (int i = 0; i < 16; i++) {
            lista.add(new CuadradoMemory(panel));
        }

        Collections.shuffle(lista);

        return lista;
    }

    private void compruebaPareja() {
        setBackground(colores[numBoton]);
        numClics++;

        if (boton1 == null) {
            boton1 = this;
        } else {
            boton2 = this;
            panel.botonesEncendidos(false);

            Timer temporizador = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (boton1.getBackground() == boton2.getBackground()) {
                        boton1.setEnabled(false);
                        boton2.setEnabled(false);
                        parejas++;
                        if (parejas == 8) {
                            ganarPartida();
                        }
                    } else {
                        boton1.setBackground(Color.WHITE);
                        boton2.setBackground(Color.WHITE);
                    }
                    boton1 = null;
                    boton2 = null;
                    panel.botonesEncendidos(true);
                }

                private void ganarPartida() {
                    JOptionPane.showMessageDialog(
                            null,
                            "Lo has conseguido en " + numClics + " clics",
                            "Fin de Partida",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    System.exit(0);
                }
            });

            temporizador.setRepeats(false);
            temporizador.start();
        }
    }

}

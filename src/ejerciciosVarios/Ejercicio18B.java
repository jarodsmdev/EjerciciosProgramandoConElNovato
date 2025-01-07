/*
 * Ejercicio 55 JAVA - TRABAJANDO EN EL CODIGO AJENO
 * URL: https://youtu.be/zJgnHnQtGTU?list=PL0OKXi7iFPGqMMU78vaCvtSAOjS1ZNxbK
 */
package ejerciciosVarios;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @version 07/01/2025
 * @author Jarod Smith
 */
public class Ejercicio18B {

    public static void main(String[] args) {
        InterfazJuegoMemory juegoMemory = new InterfazJuegoMemory();
    }
}

class InterfazJuegoMemory extends JFrame {

    public InterfazJuegoMemory() {
        // Aca agregaremos en panel
        add(new PanelJuegoMemory());

        //Configura el JFrame
        setTitle("Juego Memory con Logos");
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

    private int numBoton;
    private static int numClics = 0;
    private static int numStatic = 0;
    private static int parejas = 0;
    private static CuadradoMemory boton1;
    private static CuadradoMemory boton2;

    private ImageIcon imagen;

    public CuadradoMemory() {

        numBoton = numStatic;
        numStatic++;

        if (numStatic == 8) {
            numStatic = 0;
        }
        setBackground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addActionListener(e -> compruebaPareja());

        imagen = new ImageIcon("./resources/memory/logos/" + numBoton + ".png");
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

        if (boton1 == null) {
            boton1 = this;
            setIcon(imagen);
            numClics++;
            return;
        }

        if (boton2 == null) {
            boton2 = this;
            setIcon(imagen);
            numClics++;

            Timer temporizador = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (esParejaCorrecta()) {
                        procesarParejaCorrecta();
                    } else {
                        reiniciarBotones();
                    }
                    limpiarSeleccion();
                }

                private boolean esParejaCorrecta() {
                    ImageIcon logo1 = toImageIcon(boton1);
                    ImageIcon logo2 = toImageIcon(boton2);
                    return logo1.getDescription().equals(logo2.getDescription()) && boton1 != boton2;
                }

                private ImageIcon toImageIcon(JButton boton) {
                    return (ImageIcon) boton.getIcon();
                }

                private void procesarParejaCorrecta() {
                    removerActionListeners(boton1);
                    removerActionListeners(boton2);
                    parejas++;
                    if (parejas == 8) {
                        ganarPartida();
                    }
                }

                private void removerActionListeners(AbstractButton boton) {
                    for (ActionListener al : boton.getActionListeners()) {
                        boton.removeActionListener(al);
                    }
                }

                private void reiniciarBotones() {
                    boton1.setIcon(null);
                    boton2.setIcon(null);
                }

                private void limpiarSeleccion() {
                    boton1 = null;
                    boton2 = null;
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

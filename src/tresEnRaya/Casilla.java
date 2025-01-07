/*
 * Ejercicio 53 JAVA - TRES EN RAYA / TIC TAC TOE
 * URL: https://www.youtube.com/watch?v=D8KVNeRPNlY
 */
package tresEnRaya;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * @version 06/01/2025
 * @author Jarod Smith
 */
public class Casilla extends JButton {

    private static boolean turnoJugadorUno = true;
    private static boolean ganar;
    private static boolean lleno = false;
    private static String simbolo;

    public Casilla() {
        setFont(new Font("Roboto", Font.BOLD, 80));
        setBackground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void logicaJuego(Casilla[][] casillas, Casilla c) {
        pintarCasilla(c);
        compruebaLinea(casillas);
        compruebaColumnas(casillas);
        compruebaDiagonal(casillas);
        compruebaLleno(casillas);
    }

    private static void pintarCasilla(Casilla c) {
        if (turnoJugadorUno) {
            c.setText("X");
            turnoJugadorUno = false;
        } else {
            c.setText("O");
            turnoJugadorUno = true;
        }
        c.setEnabled(false);
    }

    private static void compruebaLinea(Casilla[][] casillas) {
        for (int i = 0; i < casillas.length; i++) {
            ganar = true;
            simbolo = casillas[i][0].getText();

            if (!simbolo.equals("")) {
                for (int j = 0; j < casillas[0].length; j++) {
                    if (!simbolo.equals(casillas[i][j].getText())) {
                        ganar = false;
                    }
                }
                if (ganar) {
                    ganarPartida("Ha ganado el jugador " + simbolo);
                }
            }
        }
    }

    private static void compruebaColumnas(Casilla[][] casillas) {
        for (int j = 0; j < casillas.length; j++) {
            ganar = true;
            simbolo = casillas[0][j].getText();

            if (!simbolo.equals("")) {
                for (int i = 0; i < casillas[0].length; i++) {
                    if (!simbolo.equals(casillas[i][j].getText())) {
                        ganar = false;
                    }
                }
                if (ganar) {
                    ganarPartida("Ha ganado el jugador " + simbolo);
                }
            }
        }
    }

    private static void compruebaDiagonal(Casilla[][] casillas) {
        // Verificar la diagonal 1
        ganar = true;
        simbolo = casillas[0][0].getText();

        if (!simbolo.equals("")) {
            for (int i = 1; i < casillas.length; i++) {
                if (!simbolo.equals(casillas[i][i].getText())) {
                    ganar = false;
                }
            }
            if (ganar) {
                ganarPartida("Ha ganado el jugador " + simbolo);
            }
        }

        // Verificar la diagonal 2
        ganar = true;
        simbolo = casillas[0][2].getText();

        if (!simbolo.equals("")) {
            for (int i = 1, j = 1; i < casillas.length; i++, j--) {
                if (!simbolo.equals(casillas[i][j].getText())) {
                    ganar = false;
                }
            }
            if (ganar) {
                ganarPartida("Ha ganado el jugador " + simbolo);
            }
        }

    }

    private static void compruebaLleno(Casilla[][] casillas) {
        lleno = true;

        for (Casilla[] arrayCasillas : casillas) {
            for (Casilla c : arrayCasillas) {
                if (c.getText().equals("")) {
                    lleno = false;
                }
            }
        }

        if (lleno) {
            ganarPartida("No hay ganador, se declara un empate.");
        }
    }

    private static void ganarPartida(String mensaje) {
        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Fin de la partida",
                JOptionPane.INFORMATION_MESSAGE
        );
        System.exit(0);
    }
}

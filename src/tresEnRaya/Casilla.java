/*
 * Ejercicio 53 JAVA - TRES EN RAYA / TIC TAC TOE
 * URL: https://www.youtube.com/watch?v=D8KVNeRPNlY
 */
package tresEnRaya;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;

/**
 * @version 06/01/2025
 * @author Jarod Smith
 */
public class Casilla extends JButton {

    private static boolean turnoJugadorUno = true;
    
    public Casilla(){
        setFont(new Font("Roboto", Font.BOLD, 40));
        setBackground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}

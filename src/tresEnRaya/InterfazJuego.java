/*
 * Ejercicio 53 JAVA - TRES EN RAYA / TIC TAC TOE
 * URL: https://www.youtube.com/watch?v=D8KVNeRPNlY
 */
package tresEnRaya;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @version 06/01/2025
 * @author Jarod Smith
 */
public class InterfazJuego {
    private JFrame marco;
    private JPanel panel;
    
    private Casilla[][] casillas;
    
    public InterfazJuego(){
        marco = new JFrame();
        panel = new JPanel(new GridLayout(3, 3));
        
        casillas = new Casilla[3][3];
        
        rellenaCasillas();
        montarInterfaz();
    }

    private void rellenaCasillas() {
        for(int i = 0; i < casillas.length; i++){
            for(int j = 0; j < casillas[0].length; j++){
                casillas[i][j] = new Casilla();
            }
        }
    }

    private void montarInterfaz() {
        insertarCasillasAlPanel();
        
        marco.add(panel);
        marco.setTitle("Tres en Raya - Tic Tac Toe");
        marco.setSize(500,500);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setResizable(false);
        marco.setLocationRelativeTo(null);
    }

    private void insertarCasillasAlPanel() {
        for(Casilla[] arrayCasillas: casillas){
            for(Casilla c: arrayCasillas){
                panel.add(c);
            }
        }
    }
    
    public void abrir(){
        marco.setVisible(true);
    }
}

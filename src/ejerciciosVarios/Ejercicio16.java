/*
 * Ejercicio 51 JAVA - ¡MUEVE AL MONSTRUO!
 * URL: https://www.youtube.com/watch?v=1H_6icCtAqM
 */
package ejerciciosVarios;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @version 06/01/2025
 * @author Jarod Smith
 */
public class Ejercicio16 {

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.abrir();
    }
}

class Ventana extends JFrame {

    private int coordX = 0;
    private int coordY = 0;

    private Image imagen;

    public Ventana() {
        try {
            imagen = ImageIO.read(new File("./resources/monstruo/monster.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        setTitle("Moviendo al monstruo");
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void abrir() {
        add(new PanelMonstruo());
        setVisible(true);
        addKeyListener(new KeyListener() {
            
            @Override
            public void keyPressed(KeyEvent e) {

                // Tamaño de la imagen
                int imagenWidth = imagen.getWidth(null);
                int imagenHeight = imagen.getHeight(null);

                // Límites dinámicos basados en el tamaño de la ventana y la imagen
                int limiteX = getWidth() - imagenWidth - 20; // Limite derecho
                int limiteY = getHeight() - imagenHeight - 50; // Limite inferior

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (coordY > 0) coordY -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        // Asegurarse de que la imagen no se salga hacia abajo
                        if (coordY < limiteY) coordY += 10;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (coordX > 0) coordX -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        // Asegurarse de que la imagen no se salga hacia la derecha
                        if (coordX < limiteX) coordX += 10;
                        break;
                }

                // Imprimir las posiciones X, Y de la imagen (para ver la posición)
                System.out.println("Posición X: " + coordX + " | Posición Y: " + coordY);

                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //Sin Uso
            }
            
            @Override
            public void keyTyped(KeyEvent e) {
                //Sin uso
            }

        });
    }

    private class PanelMonstruo extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagen, coordX, coordY, this);
        }
    }
}

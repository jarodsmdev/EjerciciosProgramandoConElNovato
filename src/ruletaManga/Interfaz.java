/**
 *
 * Ejercicio 47 JAVA - RULETA
 */
package ruletaManga;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import marcoPanelPersonalizado.FramePersonalizado;

public class Interfaz {

    private FramePersonalizado marco;
    private JPanel panelPrincipal, panelCentral, panelInferior, panelVertical;
    private JLabel imagen, titulo;
    private JButton boton;

    public Interfaz() {
        marco = new FramePersonalizado(400, 600, "Ruleta de Anime!", true);
        panelPrincipal = new JPanel(new BorderLayout());
        panelCentral = new JPanel();
        panelInferior = new JPanel();
        panelVertical = new JPanel();
        imagen = new JLabel();
        titulo = new JLabel();
        boton = new JButton("Genera Animé!");

        montarComponentes();
    }

    private void montarComponentes() {
        panelVertical.setLayout(new BoxLayout(panelVertical, BoxLayout.Y_AXIS));

        panelVertical.add(imagen);
        panelVertical.add(titulo);
        panelCentral.add(panelVertical);

        boton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread hilo = new Thread(new Funcionamiento());
                hilo.start();
            }
        });
        
        panelInferior.add(boton);

        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        marco.add(panelPrincipal);
        marco.setVisible(true);
    }

    private class Funcionamiento implements Runnable {

        private String rutaCarpeta = "./src/ruletaManga/imagenes/";
        private File carpeta;
        private File[] imagenes;

        public Funcionamiento() {
            carpeta = new File(rutaCarpeta);
            imagenes = carpeta.listFiles();
        }

        @Override
        public void run() {
            int contador = 0;
            int numAleatorio = (int) (Math.random() * 25) + 10;

            try {
                while (numAleatorio >= 0) {
                    Thread.sleep(30);
                    
                    ImageIcon imagenActual = new ImageIcon(imagenes[contador].getPath());
                    imagen.setIcon(imagenActual);
                    titulo.setText(generaNombre(imagenes[contador].getName()));
                    
                    contador++;
                    
                    if(contador == imagenes.length - 1){
                        contador = 0;
                    }
                    
                    numAleatorio--;
                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

        private String generaNombre(String name) {
            return name.substring(0, name.length() - 4);
        }
    }
}

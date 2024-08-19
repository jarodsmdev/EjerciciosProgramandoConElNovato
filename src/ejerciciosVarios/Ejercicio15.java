/**
 *
 * Ejercicio 49 JAVA - Reproductor musica WAV
 */
package ejerciciosVarios;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import marcoPanelPersonalizado.FramePersonalizado;

public class Ejercicio15 {

    public static void main(String[] args) {
        Interfaz reproductor = new Interfaz();
        reproductor.comenzar();
    }
}

class Interfaz {

    // Inicialización de variables
    private final FramePersonalizado marco;
    private final JPanel principal;
    private final JPanel central;
    private final JPanel inferior;
    private final JTextField campoTexto;
    private final JButton selector;
    private final JButton play;
    private final JButton stop;
    private File archivo;
    private Clip miClip;
    private AudioInputStream puente;

    // Constructor
    public Interfaz() {
        // Crear la interfaz pero no configurar ni montar componentes todavía
        marco = new FramePersonalizado(400, 150, "Reproductor WAV", true);
        principal = new JPanel(new BorderLayout());
        central = new JPanel();
        inferior = new JPanel();
        campoTexto = new JTextField(20);

        selector = new JButton("Abrir");
        play = new JButton("Play");
        stop = new JButton("Stop");

        archivo = null;
    }

    public void comenzar() {
        montarEscena(); // Configura la escena una vez en el constructor
        abrir(); // Muestra la ventana
    }

    private void montarEscena() {
        // Configuración de paneles y listeners
        campoTexto.setEditable(false);
        selector.addActionListener(e -> abrirSelector());

        central.add(campoTexto);
        central.add(selector);

        play.addActionListener(e -> reproducir());
        stop.addActionListener(e -> detener());

        inferior.add(play);
        inferior.add(stop);

        principal.add(central, BorderLayout.CENTER);
        principal.add(inferior, BorderLayout.SOUTH);

        marco.add(principal);
    }

    private void abrir() {
        marco.setVisible(true); // Muestra el marco sólo una vez
    }

    private void abrirSelector() {
        // Abrir el selector de archivos solo cuando se hace clic en el botón
        JFileChooser ventanaSeleccion = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos WAV", "wav");

        ventanaSeleccion.setFileFilter(filtro);

        int resultado = ventanaSeleccion.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            archivo = ventanaSeleccion.getSelectedFile();

            String nombreArchivo = archivo.getName();

            if (comprobarFormato(nombreArchivo)) {
                campoTexto.setText(nombreArchivo);
            } else {
                campoTexto.setText("Archivo no válido");
            }
        }
    }

    private boolean comprobarFormato(String nombre) {
        return nombre.toLowerCase().endsWith(".wav");
    }

    private void reproducir() {
        if (archivo != null) {
            try {

                puente = AudioSystem.getAudioInputStream(archivo);
                miClip = AudioSystem.getClip();

                miClip.open(puente);
                miClip.start();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                ex.printStackTrace();
            }
        } else {
            campoTexto.setText("Ningún archivo seleccionado");
        }
    }

    private void detener() {
        if (miClip != null) {
            if (miClip.isRunning()) {
                miClip.stop();
            }
            miClip.close();
        }
        if (puente != null) {
            try {
                puente.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

/*
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 7/10
 * URL: https://www.youtube.com/watch?v=XJmbVmfrWvc
 */
package miniRPG;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * @version 04/01/2025
 * @author Jarod Smith
 */
public class VentanaFinal {

    private JTextArea areaTexto;
    private JLabel imagen;
    private JButton btnSalir;
    private ImageIcon rutaImagen;

    private JDialog marco;
    private JPanel panelPrincipal;

    private int condicion;
    private Personaje pj;

    public static final int VICTORIA = 0;
    public static final int DERROTA = 1;

    public VentanaFinal(int condicion, Personaje pj) {
        this.condicion = condicion;
        this.pj = pj;
        marco = new JDialog();
        panelPrincipal = new JPanel(new BorderLayout());
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollTexto = new JScrollPane(areaTexto);
        btnSalir = new JButton("Finalizar");

        if (condicion == VICTORIA) {
            rutaImagen = new ImageIcon("./resources/miniRPG/imagenes/victoria.jpg");
        } else {
            rutaImagen = new ImageIcon("./resources/miniRPG/imagenes/derrota.jpg");
        }

        // Crear un JLabel con una imagen redimensionada
        imagen = new JLabel();
        ajustarImagen();

        marco.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ajustarImagen();
            }
        });
    }

    public void abrir() {
        prepararMensaje();
        montarEscena();
        marco.setUndecorated(true);
        marco.setVisible(true);
    }

    private void montarEscena() {
        // Añadimos imagen a la parte norte
        panelPrincipal.add(imagen, BorderLayout.NORTH);

        // Añadimos área texto al centro de la pantalla
        panelPrincipal.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Añadimos botón a la parte sur
        btnSalir.addActionListener(e -> System.exit(0));
        btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panelPrincipal.add(btnSalir, BorderLayout.SOUTH);

        marco.add(panelPrincipal);
        marco.setSize(650, 600);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
    }

    private void ajustarImagen() {
        int width = marco.getWidth();
        if (width == 0) {
            width = 600; // Ancho predeterminado si la ventana no está inicializada
        }
        int height = 300; // Fijar altura de la imagen a 300px

        // Redimensionar la imagen
        Image img = rutaImagen.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(img));
    }

    private void prepararMensaje() {
        String mensajeFinal;

        if (condicion == VICTORIA) {
            mensajeFinal = "Has conseguido derrotar a todos, Vuelves a tu hogar con una victoria.\n"
                    + "Tienes heridas que nunca podrás borrar, Has vencido , pero a qué precio.\n"
                    + pj.getNombre() + " Nivel: " + pj.getNivel() + " Has logrado traer contigo " + pj.getOro() + " monedas de oro.";
        } else {
            mensajeFinal = "Fuiste aniquilado en el castillo, tus restos quedaron esparcidos por todo el lugar\n"
                    + "Todos se olvidaron de ti, vuelve a intentarlo si te atreves";
        }

        areaTexto.setText(mensajeFinal);
    }
}

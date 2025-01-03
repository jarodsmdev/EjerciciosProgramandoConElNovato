/**
 *
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 3/10
 */
package miniRPG;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import marcoPanelPersonalizado.FramePersonalizado;

public class VentanaPrincipal {

    private final int ANCHO = 800;
    private final int ALTO = 600;
    private FramePersonalizado marco;
    private JPanel panelPrincipal, panelSuperior, panelInferior;

    private JLabel etNombre, etNivel, etExp, etOro, etAtributos;
    private JLabel etImagen;

    private JButton botExplorar;

    private Personaje pj;

    public VentanaPrincipal(Personaje pj) {
        this.pj = pj;

        marco = new FramePersonalizado(ANCHO, ALTO, "Mini RPG", true);

        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = new JPanel();
        panelInferior = new JPanel();

        etNombre = new JLabel(pj.getNombre() + "    ");
        etNivel = new JLabel(" Lv1: " + pj.getNivel());
        etExp = new JLabel(" Exp: " + pj.getExp() + "/" + pj.getExpNecesaria());
        etOro = new JLabel(" Oro: " + pj.getOro());
        etAtributos = new JLabel(" Ataque: " + pj.getAtaque() + " | Defensa: " + pj.getDefensa() + "  Vida: ");

        etImagen = new JLabel();

        botExplorar = new JButton("Explorar");
        botExplorar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void ComenzarJuego() {
        montarEscena();
        marco.setVisible(true);
    }

    private void cargarImagenCastillo(JLabel label, String rutaImagen) {
        try {
            // Cargar la imagen desde el archivo
            ImageIcon iconoOriginal = new ImageIcon(rutaImagen);

            // Escalar la imagen al tamaño del marco
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_SMOOTH);

            // Crear un nuevo ImageIcon con la imagen escalada
            ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

            // Establecer el icono escalado en el JLabel
            label.setIcon(iconoEscalado);
        } catch (Exception e) {
            e.printStackTrace();
            // Mostrar un mensaje si la imagen no se pudo cargar
            label.setText("No se pudo cargar la imagen.");
        }
    }

    private void montarEscena() {
        //Elaboramos panel superior con datos del personaje
        modificarFuente();
        panelSuperior.add(etNombre);
        panelSuperior.add(etNivel);
        panelSuperior.add(etExp);
        panelSuperior.add(etOro);
        panelSuperior.add(etAtributos);
        panelSuperior.add(pj.getBarraVida());

        // Cargar la imagen de castillo y ajustarla al tamaño de la ventana
        cargarImagenCastillo(etImagen, "./resources/miniRPG/imagenes/castillo.jpg");

        // Añadir la imagen escalada al panel principal
        panelPrincipal.add(etImagen, BorderLayout.CENTER);

        //Añadimos nuestros botones al panel inferior
        botExplorar.addActionListener(e -> nuevaExploracion());
        panelInferior.add(botExplorar);

        //Añadimos paneles secundarios al panel principal
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        //Añadimos panel principal al marco
        marco.add(panelPrincipal);
    }

    private void nuevaExploracion() {
        Exploracion exploracion = new Exploracion(this);
        exploracion.comenzarExploracion();
    }

    private void modificarFuente() {
        Font miFuente = new Font("Roboto", Font.BOLD, 20);
        etNombre.setFont(miFuente);
    }

    public Personaje getPj() {
        return pj;
    }

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }
}

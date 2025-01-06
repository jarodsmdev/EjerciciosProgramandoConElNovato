/*
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 8/10
 * URL: https://www.youtube.com/watch?v=R-NaXDXnfYU
 */
package miniRPG;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @version 05/01/2025
 * @author Jarod Smith
 */
public class Tienda {

    private static final int IMAGE_WIDTH = 100;  // Ancho deseado para las imágenes
    private static final int IMAGE_HEIGHT = 100; // Alto deseado para las imágenes

    private JDialog marco;

    private JPanel panelPrincipal;
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private JPanel panelTienda;

    private JPanel panelEspada;
    private JPanel panelEscudo;
    private JPanel panelPocion;
    private JPanel panelMapa;

    private JLabel imagenEspada;
    private JLabel imagenEscudo;
    private JLabel imagenPocion;
    private JLabel imagenMapa;

    private JLabel desEspada;
    private JLabel desEscudo;
    private JLabel desPocion;
    private JLabel desMapa;

    private static JButton btnEspada;
    private static JButton btnEscudo;
    private static JButton btnPocion;
    private static JButton btnMapa;

    private static boolean agoEspada = false;
    private static boolean agoEscudo = false;
    private static boolean agoPocion = false;
    private static boolean agoMapa = false;

    private JButton btnSalir;

    private VentanaPrincipal ventana;
    private Personaje pj;

    public Tienda(VentanaPrincipal ventana) {
        this.ventana = ventana;
        pj = ventana.getPj();

        marco = new JDialog();
        marco.setUndecorated(true);
        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = ventana.getPanelSuperior();
        panelInferior = new JPanel();
        panelTienda = new JPanel(new GridLayout(2, 2, 10, 10)); // Añadido espaciado entre celdas

        panelEspada = new JPanel();
        panelEscudo = new JPanel();
        panelPocion = new JPanel();
        panelMapa = new JPanel();

        // Redimensionar las imágenes al crearlas
        imagenEspada = new JLabel(resizeImageIcon("./resources/miniRPG/imagenes/espada.png"));
        imagenEscudo = new JLabel(resizeImageIcon("./resources/miniRPG/imagenes/escudo.png"));
        imagenPocion = new JLabel(resizeImageIcon("./resources/miniRPG/imagenes/pocion.png"));
        imagenMapa = new JLabel(resizeImageIcon("./resources/miniRPG/imagenes/mapa.png"));

        desEspada = new JLabel("Espada - 200 Oro.");
        desEscudo = new JLabel("Escudo - 200 Oro.");
        desPocion = new JLabel("Poción - 100 Oro.");
        desMapa = new JLabel("Mapa - 10 Oro.");

        btnEspada = new JButton("Comprar");
        btnEscudo = new JButton("Comprar");
        btnPocion = new JButton("Comprar");
        btnMapa = new JButton("Comprar");

        btnSalir = new JButton("Salir");
        btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // Método para redimensionar ImageIcon
    private ImageIcon resizeImageIcon(String path) {
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public void abrirTienda() {
        montarInterfaz();
        marco.setVisible(true);
    }

    private void montarInterfaz() {
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        // Preparamos zona central
        addObjeto(panelEspada, imagenEspada, desEspada, btnEspada, "Espada", agoEspada);
        addObjeto(panelEscudo, imagenEscudo, desEscudo, btnEscudo, "Escudo", agoEscudo);
        addObjeto(panelPocion, imagenPocion, desPocion, btnPocion, "Poción", agoPocion);
        addObjeto(panelMapa, imagenMapa, desMapa, btnMapa, "Mapa", agoMapa);

        panelTienda.add(panelEspada);
        panelTienda.add(panelEscudo);
        panelTienda.add(panelPocion);
        panelTienda.add(panelMapa);

        panelPrincipal.add(panelTienda, BorderLayout.CENTER);

        // Preparando panel inferior
        btnSalir.addActionListener(e -> marco.dispose()); //Salir
        panelInferior.add(btnSalir);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        marco.setSize(600, 600);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
        marco.add(panelPrincipal);
    }

    private void addObjeto(JPanel panelObjeto, JLabel imagen, JLabel descripcion, JButton boton, String nombre, boolean agotado) {
        panelObjeto.setLayout(new BoxLayout(panelObjeto, BoxLayout.Y_AXIS));

        // Añadir padding al panel
        panelObjeto.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        imagen.setAlignmentX(Component.CENTER_ALIGNMENT);
        descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);

        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //if(agotado) boton.setEnabled(agotado);
        boton.setEnabled(!agotado);
        boton.addActionListener(e -> comprarObjeto(boton, nombre));

        panelObjeto.add(imagen);
        panelObjeto.add(javax.swing.Box.createVerticalStrut(5)); // Espacio entre imagen y descripción
        panelObjeto.add(descripcion);
        panelObjeto.add(javax.swing.Box.createVerticalStrut(5)); // Espacio entre descripción y botón
        panelObjeto.add(boton);
    }

    private void comprarObjeto(JButton boton, String nombre) {
        switch (nombre) {
            case "Espada":
                if (pj.getOro() >= 200) {
                    pj.setAtaque(pj.getAtaque() + 5);
                    ventana.getEtAtributos().setText(" Atq: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + "  Vida: ");
                    pj.setOro(pj.getOro() - 200);
                    ventana.getEtOro().setText(" Oro: " + pj.getOro());
                    boton.setEnabled(false);
                    agoEspada = true;
                }
                break;
            case "Escudo":
                if (pj.getOro() >= 200) {
                    pj.setAtaque(pj.getDefensa() + 3);
                    ventana.getEtAtributos().setText(" Atq: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + "  Vida: ");
                    pj.setOro(pj.getOro() - 200);
                    ventana.getEtOro().setText(" Oro: " + pj.getOro());
                    boton.setEnabled(false);
                    agoEscudo = true;
                }
                break;
            case "Poción":
                if (pj.getOro() >= 100) {
                    pj.setVidaActual((int) pj.getVidaMax());
                    pj.establecerVida(pj.getVidaActual());
                    pj.setOro(pj.getOro() - 100);
                    ventana.getEtOro().setText(" Oro: " + pj.getOro());
                    //boton.setEnabled(false);
                    //agoPocion = true;
                }
                break;
            case "Mapa":
                if (pj.getOro() >= 10) {
                    Exploracion.setNumExploracion(250);
                    pj.setOro(pj.getOro() - 10);
                    ventana.getEtOro().setText(" Oro: " + pj.getOro());
                    boton.setEnabled(false);
                    agoMapa = true;
                }
                break;
        }
    }
}

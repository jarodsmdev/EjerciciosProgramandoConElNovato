/**
 *
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 4/10
 */
package miniRPG;

import java.awt.BorderLayout;
import java.awt.Cursor;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @version 30/12/2024
 * @author Jarod Smith
 */
public class Exploracion {

    private JDialog marco;

    private JPanel panelPrincipal;
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private JPanel panelMonstruo;
    private JPanel panelMonstruoSec;

    private JButton btnAtacar;
    private JButton btnHuir;

    private JTextArea infoExproracion;
    private JScrollPane barraDesplazamiento;

    private Personaje pj;
    private Monstruo enemigo;

    private VentanaPrincipal ventana;

    private static int numExploracion = 0;

    public Exploracion(VentanaPrincipal ventana) {
        this.ventana = ventana;
        pj = ventana.getPj();
        marco = new JDialog();
        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = ventana.getPanelSuperior();
        panelInferior = new JPanel();
        panelMonstruo = new JPanel();
        panelMonstruoSec = new JPanel();

        infoExproracion = new JTextArea();
        infoExproracion.setEditable(false);
        barraDesplazamiento = new JScrollPane(infoExproracion);
        barraDesplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        btnAtacar = new JButton("Atacar");
        btnHuir = new JButton("Huir");
    }

    public void comenzarExploracion() {
        decidirDificultad();
        montarInterfaz();
    }

    private void decidirDificultad() {
        int numAleatorio = (int) (Math.random() * 100) + numExploracion;

        numExploracion++;

        //Ahora aquí instanciariamos un objeto de la clase monstruo
        enemigo = Monstruo.generaMonstruo(numExploracion);

    }

    private void montarInterfaz() {
        // Panel superior listo

        // Añadimos el área de texto al panel principal
        panelPrincipal.add(barraDesplazamiento, BorderLayout.CENTER);

        // Tenemos que añadir todo lo del monstruo
        panelMonstruoSec.add(enemigo.getEtNombre());
        panelMonstruoSec.add(enemigo.getBarraVida());

        panelMonstruo.setLayout(new BoxLayout(panelMonstruo, BoxLayout.Y_AXIS));
        panelMonstruo.add(enemigo.getImagen());
        panelMonstruo.add(panelMonstruoSec);

        // Elaboramos panel inferior con sus botones
        btnAtacar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAtacar.addActionListener(e -> atacar());
        btnHuir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnHuir.addActionListener(e -> marco.dispose());

        panelInferior.add(btnAtacar);
        panelInferior.add(new JLabel("   "));
        panelInferior.add(btnHuir);

        // Añadimos los paneles secundarios al principal
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        // Nos queda añadir el panel del monstruo
        panelPrincipal.add(panelMonstruo, BorderLayout.EAST);

        marco.add(panelPrincipal);
        marco.setSize(650, 500);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
        marco.setVisible(true);
    }

    private void atacar() {
        int damage;

        pj.atacar(enemigo);
        infoExproracion.setText(infoExproracion.getText() + pj.getNombre() + " ataca con una fuerza de " + pj.getAtaque() + ".\n");

        damage = pj.getAtaque() - enemigo.getDefensa();
        if (damage <= 0) {
            damage = 1;
        }

        infoExproracion.setText(infoExproracion.getText() + enemigo.getNombre() + " ha recibido " + damage + " de daño.\n\n");

        enemigo.establecerVida(enemigo.getVidaActual());

        if (!enemigo.isEstaVivo()) {
            enemigoDerrotado();
        } else {
            enemigo.atacar(pj);
            infoExproracion.setText(infoExproracion.getText() + enemigo.getNombre() + " ataca con una fuerza de " + enemigo.getAtaque() + ".\n");

            damage = enemigo.getAtaque() - pj.getDefensa();
            if (damage <= 0) {
                damage = 1;
            }

            infoExproracion.setText(infoExproracion.getText() + pj.getNombre() + " ha recibido " + damage + " de daño.\n\n");
            pj.establecerVida(pj.getVidaActual());

            if (!pj.isEstaVivo()) {
                derrota();
            }
        }
    }

    private void enemigoDerrotado() {
        btnAtacar.setEnabled(false);
        btnHuir.setText("Salir");

        infoExproracion.setText(infoExproracion.getText() + enemigo.getNombre() + " ha sido derrotado.\nHas obtenido " + enemigo.getPremioOro() + " oro.\nGanas " + enemigo.getPremioExp() + " puntos de experiencia.\n");

        pj.subirExp(enemigo.getPremioExp());
        ventana.getEtExp().setText(" Exp: " + pj.getExp() + "/" + pj.getExpNecesaria());
        ventana.getEtNivel().setText(" Lvl: " + pj.getNivel());
        ventana.getEtAtributos().setText(" Atq: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + "  vida: ");

        pj.setOro(enemigo.getPremioOro());
        ventana.getEtOro().setText(" Oro: " + pj.getOro());
    }

    private void derrota() {
        VentanaFinal v = new VentanaFinal(VentanaFinal.DERROTA, pj);
        v.abrir();
    }

}

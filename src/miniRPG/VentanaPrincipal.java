/**
 *
 * Ejercicio 50 JAVA - Mini-RPG | PARTE 2/10
 */

package miniRPG;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import marcoPanelPersonalizado.FramePersonalizado;

public class VentanaPrincipal {

    private FramePersonalizado marco;
    private JPanel panelPrincipal, panelSuperior, panelInferior;
    
    private JLabel etNombre, etNivel, etExp, etOro, etAtributos;
    private JLabel eqImagen;
    
    private JButton botExplorar;
    
    private Personaje pj;
    
    public VentanaPrincipal(Personaje pj){
        this.pj = pj;
        
        marco = new FramePersonalizado(500, 600, "Mini RPG", true);
        
        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = new JPanel();
        panelInferior = new JPanel();
        
        etNombre = new JLabel(pj.getNombre());
        etNivel = new JLabel(" Lv1: " + pj.getNivel());
        etExp = new JLabel(" Exp: " + pj.getExp() + "/" + pj.getExpNecesaria());
        etOro = new JLabel(" Oro: " + pj.getOro());
        etAtributos = new JLabel(" Ataque: " + pj.getAtaque() + "| Defensa: " + pj.getDefensa());
        
        eqImagen = new JLabel();
        
        botExplorar = new JButton("Explorar");
    }
}

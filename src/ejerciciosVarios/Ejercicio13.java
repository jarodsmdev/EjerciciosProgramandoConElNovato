/**
 *
 * Ejercicio 44 JAVA - INVERTIDOR DE TEXTO
 */

package ejerciciosVarios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import marcoPanelPersonalizado.FramePersonalizado;


public class Ejercicio13 {

    public static void main(String[] args){
        InvertirFrase app = new InvertirFrase();
    }
}  

class InvertirFrase{
    private FramePersonalizado marco;
    private JTextField fraseNormal, fraseDelReves;
    private JPanel panel;
    private JButton boton;
    
    public InvertirFrase(){
        montarInterfaz();
    }
    
    private void montarInterfaz(){
        fraseNormal = new JTextField(20);
        fraseDelReves = new JTextField(20);
        //fraseDelReves.setEditable(false); //Está bloqueado pero cambia su apariencia
        fraseDelReves.setEditable(false); //Mantiene la apariencia pero está bloqueado
        
        boton = new JButton("Invertir Texto");
        
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fraseNormal.getText() != null){
                    String frase = fraseNormal.getText();
                    
                    fraseNormal.setText("");
                    fraseDelReves.setText(invierteFrase(frase));
                }
                
            }

            private String invierteFrase(String frase) {
                String fraseInvertida = "";
                
                for(int i = frase.length() - 1; i >= 0; i--){
                    fraseInvertida += frase.charAt(i);
                }
                return fraseInvertida;
            }
        });
        
        panel = new JPanel(new GridLayout(3,1));
        
        panel.add(fraseNormal);
        panel.add(fraseDelReves);
        panel.add(boton);
        
        marco = new FramePersonalizado(350, 250, "Invertir Texto", true);
        marco.add(panel);
        marco.setVisible(true);
    }
}

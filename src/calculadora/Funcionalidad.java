/**
 *
 * Ejercicio 46 JAVA - CALCULADORA (2/2 Lógica)
 */
package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funcionalidad implements ActionListener {

    private String txtBoton;
    private static double numViejo = 0;
    private static double numNuevo;
    private static boolean borrar = true;
    private static boolean primerNumero = true;
    private static String ultimoSimbolo;

    public Funcionalidad(String txtBoton) {
        this.txtBoton = txtBoton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num = Double.parseDouble(txtBoton);
            addNumPantalla();
        } catch (Exception ex) {
            if (txtBoton.equals(".")) {
                addNumPantalla();
            } else {
                calcularOperacion();
            }
        }
    }

    private void addNumPantalla() {
        String numeroPantalla = Interfaz.getTextoPantalla();
        if (txtBoton.equals(".")) {
            if (numeroPantalla.contains(".")) {
                return;
            }
        }

        if (numeroPantalla.equals("0") || borrar) {
            numeroPantalla = "";
            borrar = false;
        }

        numeroPantalla += txtBoton;
        Interfaz.setTextoPantalla(numeroPantalla);
    }

    private void calcularOperacion() {
        switch (txtBoton) {
            case "+":
                sumar();
                break;
            case "-":
                restar();
                break;
            case "*":
                multiplicar();
                break;
            case "/":
                dividir();
                break;
            case "=":
                if (ultimoSimbolo != null) {
                    if (ultimoSimbolo.equals("+")) {
                        sumar();
                    }
                    if (ultimoSimbolo.equals("-")) {
                        restar();
                    }
                    if (ultimoSimbolo.equals("*")) {
                        multiplicar();
                    }
                    if (ultimoSimbolo.equals("/")) {
                        dividir();
                    }

                    Interfaz.setTextoPantalla(String.valueOf(numViejo));
                    borrar = true;
                    numViejo = 0;
                    primerNumero = true;
                }
                break;
        }
    }

    private void sumar() {
        numNuevo = Double.parseDouble(Interfaz.getTextoPantalla());
        numViejo += numNuevo;
        ultimoSimbolo = "+";
        borrar = true;
    }

    private void restar() {
        numNuevo = Double.parseDouble(Interfaz.getTextoPantalla());
        if (primerNumero) {
            numViejo += numNuevo;
            primerNumero = false;
        } else {
            numViejo -= numNuevo;
        }
        ultimoSimbolo = "-";
        borrar = true;
    }

    private void multiplicar() {
        numNuevo = Double.parseDouble(Interfaz.getTextoPantalla());
        if (primerNumero) {
            numViejo += numNuevo;
            primerNumero = false;
        } else {
            numViejo *= numNuevo;
        }
        ultimoSimbolo = "*";
        borrar = true;
    }

    private void dividir() {
        numNuevo = Double.parseDouble(Interfaz.getTextoPantalla());
        if (primerNumero) {
            numViejo += numNuevo;
            primerNumero = false;
        } else {
            numViejo /= numNuevo;
        }
        ultimoSimbolo = "/";
        borrar = true;
    }

}

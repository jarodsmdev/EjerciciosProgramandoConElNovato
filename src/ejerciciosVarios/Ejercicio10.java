/**
 *
 * Ejercicio 36 JAVA - GENERADOR DE CONTRASEÑAS
 */
package ejerciciosVarios;

public class Ejercicio10 {

    public static void main(String[] args) {
        PassGenerator contrasenia = new PassGenerator(25, 8);

    }
}

class PassGenerator {

    String[] pass;

    public PassGenerator(int numPass, int longitud) {
        pass = new String[numPass];

        generarPass(longitud);
        mostrarPass();
    }

    private void generarPass(int longitud) {

        for (int i = 0; i < pass.length; i++) {
            String passActual = "";

            for (int j = 0; j < longitud; j++) {
                passActual += generarChar();
            }

            pass[i] = passActual;
        }
    }

    private char generarChar() {
        boolean esValido = false;
        int n = 0;

        while (esValido == false) {
            n = (int) (Math.random() * 123);

            if (n == 45) {
                esValido = true;
            }
            if (n == 95) {
                esValido = true;
            }
            if (n >= 48 && n <= 57) {
                esValido = true;
            }
            if (n >= 65 && n <= 90) {
                esValido = true;
            }
            if (n >= 97 && n <= 122) {
                esValido = true;
            }
        }
        return (char) n;
    }

    private void mostrarPass() {

        for (String s : pass) {
            System.out.println("Contraseña generada: " + s);
        }
    }
}

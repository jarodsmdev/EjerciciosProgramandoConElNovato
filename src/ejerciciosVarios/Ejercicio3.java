/**
 * Ejercicio 26 JAVA - SERPIENTE INFINITA
 */
package ejerciciosVarios;

public class Ejercicio3 {

    public static void main(String[] args) {

        int posActual = 15;
        int anchoMaximo = 30;
        boolean primeraVez = true;

        while (true) {

            try {
                Thread.sleep(300);

                for (int i = 0; i <= anchoMaximo; i++) {
                    if (i == posActual) {
                        if (primeraVez) {
                            System.out.print("@");
                            primeraVez = false;
                        } else {
                            System.out.print("|^|");
                        }
                    } else {
                        System.out.print(" ");
                    }
                    
                }

                System.out.println();
                
                posActual += (int) (Math.random() * 3) - 1;

                if (posActual == -1) {
                    posActual = 0;
                }
                if (posActual == 31) {
                    posActual = 30;
                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }
}

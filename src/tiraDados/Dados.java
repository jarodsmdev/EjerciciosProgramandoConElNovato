/**
 * Ejercicio 22 JAVA - Tira DADOS
 */
package tiraDados;

public class Dados {
    int numCaras;
    int tiradas[];
    
    public Dados(int numCaras, int numDados){
        this.numCaras = numCaras;
        tiradas = new int[numDados];
    }
    
    public void tirarDados(){
        int contador = 0;
        while(true){
            contador++;
            for(int i = 0; i < tiradas.length; i++){
            tiradas[i] = (int) (Math.random() * numCaras + 1);
                
        }
        System.out.print(contador + ": ");
        comprobarIguales();
        }
    }

    private void comprobarIguales() {
        boolean iguales = true;
        int numAComprobar = tiradas[0];
        
        for(int i = 0; i < tiradas.length; i++){
            System.out.print("[" + tiradas[i] + "] ");
            if(numAComprobar != tiradas[i]){
                iguales = false;
            }
        }
        
        System.out.println();
        
        if(iguales){
            System.out.println("Todos los números son iguales");
            System.exit(0);
        }else{
            System.out.println("No son iguales");
        }
    }
}

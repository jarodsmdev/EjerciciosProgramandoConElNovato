/**
 * Ejercicio 20 JAVA - Sacar carta de POKER al AZAR
 */
package bucles;

public class Ejercicio11 {
    public static void main(String[] args){
        String palo, carta;
        
        palo = getPalo();
        carta = getCarta();
        
        dimeCarta(carta, palo);
        
    }
    
    private static String getPalo(){
        int num = (int) (Math.random() * 4 + 1);
        
        switch (num){
            case 1:
                return "Picas";
            case 2:
                return "Diamantes";
            case 3:
                return "Trébol";
            default:
                return "Corazón";
        }
    }
    
    private static String getCarta(){
        int num = (int) (Math.random() * 13 + 1);
        
        if(num == 1){
            return "As";
        }else if(num > 1 && num < 11){
            return Integer.toString(num);
        }else if(num == 11){
            return "J";
        }else if(num == 12){
            return "Q";
        }else{
            return "K";
        }
    }
    
    private static void dimeCarta(String carta, String palo){
        System.out.println("Tu carta es: " + carta + " de " + palo);
    }
}

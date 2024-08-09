/**
 * Ejercicio 32 JAVA - VALIDADOR de EMAIL
 */
package ejerciciosVarios;

public class Ejercicio7 {
    
    private static int arrobas;
    private static int puntos;
    
    public static void main(String[] args){

        System.out.println(validaEmail("programandoconelnovato@gmail.com"));
        System.out.println(validaEmail("homer.j@gmail.com"));
        System.out.println(validaEmail("shin@chan@gmail.com"));
        System.out.println(validaEmail("novato@gmail.c.om"));
        System.out.println(validaEmail("notato@gmailcom."));
        
    }
    
    public static String validaEmail(String email){
        arrobas = 0;
        puntos = 0;
        
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '@'){
                arrobas++;
                if(arrobas > 1){
                    return "El email no puede contener más de un arroba";
                }
            }
            
            if(email.charAt(i) == '.' && arrobas == 1){
                puntos++;
                if(puntos > 1){
                    if(i == email.length() - 1){
                        return "El email " + email + " no puede acabar en un punto";
                    }
                    return "El email " + email + " no puede contener más de un punto en el dominio";
                }
            }
        }
        
        return "El email " + email + " es válido";
    }
}

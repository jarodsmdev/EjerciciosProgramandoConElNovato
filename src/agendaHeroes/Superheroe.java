/**
 *
 * Ejercicio 35 JAVA - Agenda de SUPERHÉROES (Parte 1/2)
 */
package agendaHeroes;

class Superheroe {
    private String nombre, descripcion, direccion;
    
    public Superheroe(String nombre, String descripcion, String direccion){
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Superheroe{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", direccion=" + direccion + '}';
    }
    
}

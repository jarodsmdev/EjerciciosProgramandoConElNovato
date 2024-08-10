/**
 *
 * Ejercicio 35 JAVA - Agenda de SUPERHÉROES (Parte 2/2)
 */
package agendaHeroes;

class Superheroe {
    private String nombre, descripcion, direccion;
    
    public Superheroe(String nombre, String descripcion, String direccion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
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

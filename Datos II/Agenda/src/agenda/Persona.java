/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author sebastiancaicedo
 */
public class Persona {
    
    private String Nombre;
    private String Apellido;
    private int Edad;
    private boolean mayoredad;
    
    public static int MAYORIAEDAD=18;

    public Persona(String Nombre, String Apellido, int Edad) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        actualizarMayorEdad();
    }

    public Persona(String Nombre, String Apellido) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }
    
    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
        actualizarMayorEdad();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public boolean isMayoredad() {
        return mayoredad;
    }

    public void setMayoredad(boolean mayoredad) {
        this.mayoredad = mayoredad;
    }
    
    private void actualizarMayorEdad(){
        if (Edad > MAYORIAEDAD){
            mayoredad= true;
        }
        else
        {
            mayoredad= false;
        }
    }
    
    
    
}

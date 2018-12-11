/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 *
 * @author sebastiancaicedo
 */
public class Empleado extends Persona{
    
    private int ID;
    private int Celular;

    public Empleado(int ID, String Nombre, String Apellido, int Edad) {
        super(Nombre, Apellido, Edad);
        this.ID = ID;
    }

    public Empleado(int ID, String Nombre, String Apellido) {
        super(Nombre, Apellido);
        this.ID = ID;
    }

    public int getCelular() {
        return Celular;
    }

    public void setCelular(int Celular) {
        this.Celular = Celular;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
    
    
    
    
    
}

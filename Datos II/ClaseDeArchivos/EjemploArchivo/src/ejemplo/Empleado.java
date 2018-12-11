/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

/**
 *
 * @author sebastiancaicedo
 */
public class Empleado {
    
    private String nombre;
    private String apellido;
    private int edad;
    private String nombreYApellido;

    public Empleado(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nombreYApellido= nombre+" "+apellido;//Si el string es muy largo, esto es muy lento, en java no debe concatenarse usando el +
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }
    
    @Override
    public String toString(){
        StringBuilder stringbuilder= new StringBuilder();
        stringbuilder.append("Mi nombre es ");
        stringbuilder.append(nombre);
        stringbuilder.append(" ");
        stringbuilder.append(apellido);
        stringbuilder.append(" ");
        stringbuilder.append("\nY mi edad es ");
        stringbuilder.append(edad);
        return stringbuilder.toString();
        //return "Mi nombre es "+ nombreYApellido+"\nY mi edad es "+edad;//esta concatenacion es muy lenta en java
    }
    
}

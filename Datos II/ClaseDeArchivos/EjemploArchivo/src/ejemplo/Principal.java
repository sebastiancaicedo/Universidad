/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.util.ArrayList;

/**
 *
 * @author sebastiancaicedo
 */
public class Principal {
    
    public static void main(String[] args) {
        LectorEscritor le= new LectorEscritor("empleados.txt");
        try {
            ArrayList<Empleado> empleados= le.getFastEmpleado();
            for (Empleado empleado : empleados) {//Recorre la lista empleados que es de tipo Empleados, creando instancias llamadas empleado
                System.out.println(empleado.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        LectorEscritor le2= new LectorEscritor("ejemplo.txt");
        try {
            le2.ecribir("Hola mundo");
            le2.ecribir("Hola mundo 2");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

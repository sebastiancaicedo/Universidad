/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaticnumber;

/**
 *
 * @author lusec
 */
public class Vertice {
    String nombre;
    int coordX;
    int coordY;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.coordX= (int) (Math.random()*(Ventana.tamCanvasX-Ventana.posCanvasX));//Desde la posicion del canvas hasta el tamaño menos la posicion
        this.coordY= (int) (Math.random()*(Ventana.tamCanvasY-Ventana.posCanvasY));
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX() {
        this.coordX = (int) (Math.random()*(Ventana.tamCanvasX-Ventana.posCanvasX));
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY() {
        this.coordY = (int) (Math.random()*(Ventana.tamCanvasY-Ventana.posCanvasY));
    }
    
    
    
}

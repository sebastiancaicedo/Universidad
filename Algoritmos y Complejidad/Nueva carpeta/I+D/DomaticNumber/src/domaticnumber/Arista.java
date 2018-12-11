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
public class Arista {
    String nombre;
    Vertice v1;
    Vertice v2;

    public Arista(String nombre, Vertice v1, Vertice v2) {
        this.nombre = nombre;
        this.v1 = v1;
        this.v2 = v2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Vertice getV1() {
        return v1;
    }

    public void setV1(Vertice v1) {
        this.v1 = v1;
    }

    public Vertice getV2() {
        return v2;
    }

    public void setV2(Vertice v2) {
        this.v2 = v2;
    }
    
    
    
}

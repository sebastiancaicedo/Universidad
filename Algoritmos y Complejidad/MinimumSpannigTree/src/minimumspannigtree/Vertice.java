/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimumspannigtree;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Vertice extends Arbol{
    private String etiqueta;
    private int x;
    private int y;
    private ArrayList<Vertice> adyacentes= new ArrayList();
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public ArrayList<Vertice> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(ArrayList<Vertice> adyacentes) {
        this.adyacentes = adyacentes;
    }
}

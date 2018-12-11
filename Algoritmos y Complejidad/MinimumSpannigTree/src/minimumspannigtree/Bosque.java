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
public class Bosque extends Grafo{
    ArrayList<Arbol> arboles= new ArrayList();

    public ArrayList<Arbol> getArboles() {
        return arboles;
    }

    public void setArboles(ArrayList<Arbol> arboles) {
        this.arboles = arboles;
    }
    public void add(Arbol ar){
        arboles.add(ar);
    }
    
    public void set(int i, Arbol ar){
        arboles.set(i, ar);
    }
    
    public Arbol get(int i){
        return arboles.get(i);
    }
    public void remove(int i){
        arboles.remove(i);
    }
    
    @Override
    public void clear(){
        arboles.clear();
    }
    
    public int getPos(Vertice ver){
        boolean sw= false;
        int i=0;
        int pos=-1;
        while(sw==false && i<arboles.size()){
        if(arboles.get(i).getVertices().contains(ver)){
            pos=i;
            sw=true;
        }
        i++;
        }
        return pos;
    }
}

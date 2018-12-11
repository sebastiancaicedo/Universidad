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
public class Grafo {
    private ArrayList<Vertice> vertices=new ArrayList();
    private ArrayList<Arista> aristas=new ArrayList();
    
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }
    
    public void addVertice(Vertice ver){
        vertices.add(ver);
    }
    public void addVertice(ArrayList<Vertice> ver){
        vertices.addAll(ver);
    }
    public void addArista(Arista aris){
        aristas.add(aris);
    }
    public void addArista(ArrayList<Arista> aris){
        aristas.addAll(aris);
    }
    public void clear(){
        vertices.clear();
        aristas.clear();
    }
    
    public int index(String et){
        int in=-1;
        boolean sw=false;
        int i=0;
        while( i<vertices.size() && sw==false){
            if(et.equals(vertices.get(i).getEtiqueta())){
                in=i;
                sw=true;
            }
            i++;
        }
        return in;
    }
    public void ordenarVer(){
        Arista temp;
        for(int i=0; i<aristas.size()-1;i++){
            for(int j=i+1;j<aristas.size();j++){
                if(aristas.get(i).getPeso()>aristas.get(j).getPeso()){
                    temp=aristas.get(i);
                    aristas.set(i, aristas.get(j));
                    aristas.set(j, temp);
                }
            }
        }
    }
}

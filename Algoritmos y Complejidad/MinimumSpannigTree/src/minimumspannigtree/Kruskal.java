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
public class Kruskal {
    
    private Bosque bosque= new Bosque();

    public Bosque getBosque() {
        return bosque;
    }
//    private Grafo grafo;
    private Vertice v1;
    private Vertice v2;
    ArrayList<Vertice> vertices=new ArrayList();
    ArrayList<Arista> aristas=new ArrayList();
//    ArrayList<Arbol> bosque=new ArrayList();
    public void kruskal(Grafo g){
        bosque.clear();
        vertices=g.getVertices();
        aristas=g.getAristas();
        for(int i=0;i<vertices.size();i++){
//            arbol.clear();
//            arbol.addVertice(vertices.get(i));
//            arbol=vertices.get(i);
//            bosque.add(arbol);
            vertices.get(i).addVertice(vertices.get(i));
            bosque.add(vertices.get(i));
        }
        
        for(int i=0;i<aristas.size();i++){
            v1=aristas.get(i).getV1();
            v2=aristas.get(i).getV2();
            int p=bosque.getPos(v1);
            int q=bosque.getPos(v2);
            if(p!=q && p>=0 && q>=0){
                Arbol arbol= new Arbol();
                arbol.addArista(bosque.get(p).getAristas());
                arbol.addVertice(bosque.get(p).getVertices());
                arbol.addArista(bosque.get(q).getAristas());
//                arbol.setAristas(bosque.get(p).getAristas());
//                arbol.setVertices(bosque.get(p).getVertices());
                
//                if(arbol.getAristas().size()>0){
//                    arbol.addArista(bosque.get(q).getAristas());
//                }else{
//                    arbol.setAristas(bosque.get(q).getAristas());
//                }
                arbol.addVertice(bosque.get(q).getVertices());
                
                arbol.addArista(aristas.get(i));

                bosque.set(p, arbol);
                bosque.remove(q);
            }
            
        }
        asignarElement();
    }
    public int getPeso(){
        int peso=0;
        for(int i=0; i<aristas.size();i++){
            if(bosque.getAristas().contains(aristas.get(i))){
                peso=peso+aristas.get(i).getPeso();
            }
        }
        return peso;
    }
    public void asignarElement(){
         bosque.setAristas(bosque.getArboles().get(0).getAristas());
        bosque.setVertices(bosque.getArboles().get(0).getVertices());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tourminimal;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sebastiancaicedo
 */
public class TourMinimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double dist=0;
        double distMin=1000000000; 
        ArrayList<Punto> list= new ArrayList<Punto>();
        ArrayList<Punto> puntosRecorridos = new ArrayList<Punto>();
        ArrayList<Punto> puntosMinimal= new ArrayList<Punto>();
        Scanner sc= new Scanner(System.in);
        System.out.println("Numero de puntos: ");
        int numPuntos= sc.nextInt();
        for (int i = 0; i < numPuntos; i++) {
            System.out.println("Punto "+(i+1));
            System.out.println("Etiqueta o Nombre: ");
            String nombre= sc.next();
            System.out.println("x: ");
            int x= sc.nextInt();
            System.out.println("y: ");
            int y= sc.nextInt();
            Punto p= new Punto(nombre,x, y);
            list.add(p);
        }
        
        for (int i = 0; i < 1; i++) {
            puntosRecorridos.add(list.get(i));
            for (int j = i+1; j < list.size(); j++) {
                dist+= distancia(list.get(i), list.get(j));
                puntosRecorridos.add(list.get(j));
                if(j == list.size()-1){
                    dist+= distancia(list.get(j), list.get(i));
                }
            }
            if (dist < distMin) {
                distMin= dist;
                puntosMinimal= puntosRecorridos;
            }
            else
            {
                puntosRecorridos= new ArrayList<Punto>();
            }
        }
        System.out.println(distMin);
        for (int i = 0; i < puntosMinimal.size(); i++) {
            System.out.println(puntosMinimal.get(i).getLabel());
        }
        
    }
    
    static double distancia(Punto p,Punto q){
        return Math.sqrt(Math.pow(p.getX()-q.getX(), 2)+Math.pow(p.getY()-q.getY(), 2));
    }
}

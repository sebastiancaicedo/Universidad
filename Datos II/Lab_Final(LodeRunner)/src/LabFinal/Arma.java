/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author COMPUTER
 */
public class Arma extends Rectangle{

    public static int puntosPorCogerEspada=100;
    
    public Image imagen;
    public int tiempoAparicion;
    public boolean aparecio;

    public static int tamPixelsX=32;
    public static int tamPixelsY=32;
    
    
    public Arma(int x, int y, int width, int height) {
        super(x, y, width, height);
        
        this.tiempoAparicion=tiempoAparecerAleatorio();
        this.aparecio=false;
        
        if (Ventana.juego.tipoDeJuego == 0) {
            this.imagen= new ImageIcon(getClass().getResource("/Imagenes/diamond_sword.png")).getImage();
        }
        else
            if (Ventana.juego.tipoDeJuego == 1){
                this.imagen= new ImageIcon(getClass().getResource("/Imagenes/EspadaHero.png")).getImage();
            }
    }

    
    
    private int tiempoAparecerAleatorio(){
        return (int)(Math.random()*1400);
    }
    
    public void caer(){
        this.y+= 8;
    }
}

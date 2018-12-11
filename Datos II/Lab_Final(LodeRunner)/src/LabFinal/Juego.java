/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author COMPUTER
 */
public class Juego {
    
    public int nivel=1;
    public int tipoDeJuego=1;
    public int puntaje=0;
    public int enemigosAsesinados=0;
    public static int totalNiveles=3;

    
    public Juego(int nivel, int tipoDeJuego) {
        this.nivel = nivel;
        this.tipoDeJuego = tipoDeJuego;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

/**
 *
 * @author COMPUTER
 */
public class Mundo {
    public int filas;
    public int columnas;

    public Mundo(int filas, int col) {
        this.filas = filas;
        this.columnas = col;
    }
    
    public static String[][] generarMatriz(Mundo m){
        String[][] matriz= new String[m.filas][m.columnas];
        return matriz;
    }
}

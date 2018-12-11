/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author COMPUTER
 */
public class Sprite {
    
    public ArrayList<ImageIcon> sprites=/*sprites =*/ new ArrayList<ImageIcon>();;
    public int size;
    public int actual;

    public Sprite(String[] imagenes) {
        
        for (String direcciones : imagenes) {
            sprites.add(new ImageIcon(direcciones));            
        }
        this.size = imagenes.length;
        this.actual = -1;
    }

    public ArrayList<ImageIcon> getSprites() {
        return sprites;
    }
    
    public ImageIcon getimagenSprite(int num){
        return this.sprites.get(num);
    }
    
    public Image next(){
        return sprites.get(++actual%this.size).getImage();
    }
}

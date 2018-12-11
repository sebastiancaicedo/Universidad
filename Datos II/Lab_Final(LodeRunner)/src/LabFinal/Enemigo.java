/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.awt.Image;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author COMPUTER
 */
public class Enemigo extends Rectangle{

    public static int tamPixelesX/*= 32*/;
    public static int tamPixelesY/*= 64*/;
    public static final int puntosPorMuerte=20;
   
    private final int pixelesDezplMovimiento=4;
    
    public static final int tiempoAparicion=80;
    
    public Image imagen;
    public Sprite spriteDer;
    public Sprite spriteIzq;
    public Sprite spriteSubir;
    public Sprite spriteQuieto;
    
    public boolean seMueve=false;
    public int direccion;

    public Enemigo(int x, int y, int width, int height) {
        super(x, y, width, height);
        setSprites();
    }

    public static void setTamPixelesX(int tamPixelesX) {
        Enemigo.tamPixelesX = tamPixelesX;
    }

    public static void setTamPixelesY(int tamPixelesY) {
        Enemigo.tamPixelesY = tamPixelesY;
    }
    
    private void setSprites(){
        this.spriteQuieto= new Sprite(obtenerDirecciones(0));
        this.spriteIzq= new Sprite(obtenerDirecciones(1));
        this.spriteSubir= new Sprite(obtenerDirecciones(2));
        this.spriteDer= new Sprite(obtenerDirecciones(3));
    }
    
    private String[] obtenerDirecciones(int i){
        if (Ventana.juego.tipoDeJuego == 0) {  
            if (i==0) {
                String dir[]= {"src/Imagenes/Zombiedefrente.png"};
                return dir;
            }
            if (i == 1) {
                String dir[]= {"src/Imagenes/Zombie1izq.png","src/Imagenes/Zombie2izq.png","src/Imagenes/Zombie3izq.png",
                            "src/Imagenes/Zombie4izq.png","src/Imagenes/Zombie5izq.png","src/Imagenes/Zombie6izq.png",
                            "src/Imagenes/Zombie7izq.png","src/Imagenes/Zombie8izq.png"};
                        return dir;
            }
            else
                if (i == 2 || i == 4) {
                String dir[]= {"src/Imagenes/Zombiedeespalda.png"};
                return dir;
            }
            else
                    if (i == 3) {
                        String dir[]= {"src/Imagenes/Zombie1der.png","src/Imagenes/Zombie2der.png","src/Imagenes/Zombie3der.png",
                            "src/Imagenes/Zombie4der.png","src/Imagenes/Zombie5der.png","src/Imagenes/Zombie6der.png",
                            "src/Imagenes/Zombie7der.png","src/Imagenes/Zombie8der.png"};
                        return dir;
            }
        }
        else
            if (Ventana.juego.tipoDeJuego == 1){
                if (i == 0) {
                    String dir[]= {"src/Imagenes/Lobodefrente.png"};
                    return dir;
                }
                else
                    if (i == 1) {
                        String dir[]= {"src/Imagenes/Lobo1izq.png","src/Imagenes/Lobo2izq.png","src/Imagenes/Lobo3izq.png"};
                        return dir;
                }
                else 
                        if (i == 2 || i == 4) {
                            String dir[]= {"src/Imagenes/Lobodeespalda.png"};
                            return dir;
                }
                else
                            if (i == 3) {
                                String dir[]= {"src/Imagenes/Lobo1der.png","src/Imagenes/Lobo2der.png","src/Imagenes/Lobo3der.png"};
                                return dir;
                }
            }
        return null;
    }
    
    public void Perseguir(int direccion, Personaje personaje){
        if (direccion == 1) {
            if (this.x > personaje.x) {
                this.mover(direccion);
                this.seMueve=true;
                this.direccion= 1;
            }  
        }
        else
            if (direccion == 2) {
                if (this.y > personaje.y) {
                    this.mover(direccion);
                    this.seMueve=true;
                    this.direccion= 2;
                }  
        }
        else
                if (direccion == 3) {
                    if (this.x < personaje.x) {
                        this.mover(direccion);
                        this.seMueve=true;
                        this.direccion=3;
                    }
        }
        else
                    if (direccion == 4) {
                        if (this.y < personaje.y) {
                            this.mover(direccion);
                            this.seMueve=true;
                            this.direccion=4;
                        }
        }
        else
                    {
                        this.seMueve=false;
                    }
    }
    
    private void mover(int direccion){
        if (direccion == 1) {
            this.x=this.x-pixelesDezplMovimiento;
        }
        else
            if (direccion == 2) {
                this.y= this.y-pixelesDezplMovimiento;
            }
        else
                if (direccion == 3) {
                    this.x= this.x+pixelesDezplMovimiento;
                }
        else
                    if (direccion == 4) {
                        this.y= this.y+pixelesDezplMovimiento;
                    }
    }
    
    public void caer(){
        this.mover(4);
    }
}

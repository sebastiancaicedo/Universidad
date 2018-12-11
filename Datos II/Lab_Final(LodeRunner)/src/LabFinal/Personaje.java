/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author sebastiancaicedo
 */
public class Personaje extends Rectangle{
    
    public static int tamPixelesX/*= 32*/;
    public static int tamPixelesY/*= 64*/;
    
    public static final int pixelesDezplMovimiento=8;//pixeles que se dezplaza cuando se mueve es como la velocidad
    
    public static int puntosPorMuerte=1000;
    
    public Sprite spriteDer;
    public Sprite spriteIzq;
    public Sprite spriteBarraIzq;
    public Sprite spriteBarraDer;
    public Sprite spriteSubir;
    public Sprite spriteQuieto;
    public Sprite spriteAtacarIzq;
    public Sprite spriteAtacarDer;
    public Sprite spriteMinandoIzq;
    public Sprite spriteMinandoDer;
    
    
    public boolean seMueve=false;
    public int direccion;
    public boolean isGrounded;
    public boolean tieneArma=false;
    public boolean atacar=false;
    public int destruirBloque;


    public Personaje(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.spriteQuieto= new Sprite(obtenerDirecciones(0));
        this.spriteIzq= new Sprite(obtenerDirecciones(1));
        this.spriteSubir= new Sprite(obtenerDirecciones(2));
        this.spriteDer= new Sprite(obtenerDirecciones(3));
        this.spriteBarraIzq= new Sprite(obtenerDirecciones(5));
        this.spriteBarraDer= new Sprite(obtenerDirecciones(6));
        this.spriteAtacarIzq= new Sprite(obtenerDirecciones(7));
        this.spriteAtacarDer= new Sprite(obtenerDirecciones(8));
        this.spriteMinandoIzq= new Sprite(obtenerDirecciones(9));
        this.spriteMinandoDer= new Sprite(obtenerDirecciones(10));
    }

    public static void setTamPixelesX(int tamPixelesX) {
        Personaje.tamPixelesX = tamPixelesX;
    }

    public static void setTamPixelesY(int tamPixelesY) {
        Personaje.tamPixelesY = tamPixelesY;
    }
    
    
    
    private String[] obtenerDirecciones(int i){
        if (Ventana.juego.tipoDeJuego == 0) {
            if (i==0) {
                String dir[]= {"src/Imagenes/Stevedefrente.png"};
                return dir;
            }
            if (i == 1) {
                String dir[]= {"src/Imagenes/Caminando1izq.png","src/Imagenes/Caminando2izq.png","src/Imagenes/Caminando3izq.png",
                            "src/Imagenes/Caminando4izq.png","src/Imagenes/Caminando5izq.png","src/Imagenes/Caminando6izq.png",
                            "src/Imagenes/Caminando7izq.png","src/Imagenes/Caminando8izq.png","src/Imagenes/Caminando9izq.png",
                            "src/Imagenes/Caminando10izq.png","src/Imagenes/Caminando11izq.png","src/Imagenes/Caminando12izq.png",};
                        return dir;
            }
            else
                if (i == 2 || i == 4) {
                String dir[]= {"src/Imagenes/Stevedeespalda.png"};
                return dir;
            }
            else
                    if (i == 3) {
                        String dir[]= {"src/Imagenes/Caminando1der.png","src/Imagenes/Caminando2der.png","src/Imagenes/Caminando3der.png",
                            "src/Imagenes/Caminando4der.png","src/Imagenes/Caminando5der.png","src/Imagenes/Caminando6der.png",
                            "src/Imagenes/Caminando7der.png","src/Imagenes/Caminando8der.png","src/Imagenes/Caminando9der.png",
                            "src/Imagenes/Caminando10der.png","src/Imagenes/Caminando11der.png","src/Imagenes/Caminando12der.png",};
                        return dir;
            }
            else
                        if (i == 5) {
                            String dir[]={"src/Imagenes/Cuerda1izq.png","src/Imagenes/Cuerda2izq.png","src/Imagenes/Cuerda3izq.png",
                            "src/Imagenes/Cuerda4izq.png","src/Imagenes/Cuerda5izq.png","src/Imagenes/Cuerda6izq.png",
                            "src/Imagenes/Cuerda7izq.png","src/Imagenes/Cuerda8izq.png","src/Imagenes/Cuerda9izq.png",
                            "src/Imagenes/Cuerda10izq.png","src/Imagenes/Cuerda11izq.png","src/Imagenes/Cuerda12izq.png",
                            "src/Imagenes/Cuerda13izq.png"};
                            return dir;
            }
            else
                            if (i == 6) {
                                String dir[]= {"src/Imagenes/Cuerda1der.png","src/Imagenes/Cuerda2der.png","src/Imagenes/Cuerda3der.png",
                                "src/Imagenes/Cuerda4der.png","src/Imagenes/Cuerda5der.png","src/Imagenes/Cuerda6der.png",
                                "src/Imagenes/Cuerda7der.png","src/Imagenes/Cuerda8der.png","src/Imagenes/Cuerda9der.png",
                                "src/Imagenes/Cuerda10der.png","src/Imagenes/Cuerda11der.png","src/Imagenes/Cuerda12der.png",
                                "src/Imagenes/Cuerda13der.png"};
                                return dir;
            }
            else
                                if (i == 7) {
                                    String dir[]= {"src/Imagenes/Steveatacaizq.png"};
                                    return dir;
            }
            else
                                    if (i == 8) {
                                        String dir[]= {"src/Imagenes/Steveatacader.png"};
                                    return dir;
            }
            else
                                        if (i == 9){
                                            String dir[]= {"src/Imagenes/Steveminandoizq.png"};
                                            return dir;
            }
            else
                                            if (i == 10) {
                                                String dir[]= {"src/Imagenes/Steveminandoder.png"};
                                                return dir;
            }
        }
        else
            if (Ventana.juego.tipoDeJuego == 1) {
                if (i==0) {
                String dir[]= {"src/Imagenes/Herodefrente.png"};
                return dir;
            }
            if (i == 1) {
                String dir[]= {"src/Imagenes/Hero1izq.png","src/Imagenes/Hero2izq.png","src/Imagenes/Hero3izq.png"};
                        return dir;
            }
            else
                if (i == 2 || i == 4) {
                String dir[]= {"src/Imagenes/Herodeespalda.png"};
                return dir;
            }
            else
                    if (i == 3) {
                        String dir[]= {"src/Imagenes/Hero1der.png","src/Imagenes/Hero2der.png","src/Imagenes/Hero3der.png"};
                        return dir;
            }
            else
                        if (i == 5) {
                            String dir[]={"src/Imagenes/RPGpasandobarraizq1.png","src/Imagenes/RPGpasandobarraizq2.png"};
                            return dir;
            }
            else
                            if (i == 6) {
                                String dir[]= {"src/Imagenes/RPGpasandobarrader1.png","src/Imagenes/RPGpasandobarrader2.png"};
                                return dir;
            }
            else
                                if (i == 7) {
                                    String dir[]= {"src/Imagenes/Heroatacaizq.png"/*,"src/Imagenes/frame3.png"/*,"src/Imagenes/frame4.png"*/};
                                    return dir;
                }
            else
                                    if (i == 8) {
                                        String dir[]= {"src/Imagenes/Heroatacader.png"/*,"src/Imagenes/frame6.png"/*,"src/Imagenes/frame7.png"*/};
                                        return dir;
                }
            else
                                        if (i == 9) {
                                            String dir[]= {"src/Imagenes/RPGdestruirizq.png"};
                                            return dir;
                }
            else
                                            if (i == 10) {
                                                String dir[]= {"src/Imagenes/RPGdestruirder.png"};
                                                return dir;
                }
        }
        return null;
    }
    
    public void mover(int Direccion){
        if (Direccion == 1) {
            this.x=this.x-pixelesDezplMovimiento;
        }
        else
            if (Direccion == 2) {
                this.y= this.y-pixelesDezplMovimiento;
            }
        else
                if (Direccion == 3) {
                    this.x= this.x+pixelesDezplMovimiento;
                }
        else
                    if (Direccion == 4) {
                        this.y= this.y+pixelesDezplMovimiento;
                    }
        
    }
    
    public void caer(){
        this.mover(4);
    }
    
}

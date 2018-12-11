/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author sebastiancaicedo
 */
public class Bloque extends Rectangle{
    
    public static int tamPixelesX/*=32*/;
    public static int tamPixelesY/*=32*/;
    public static final int tiempoVolverAparecer=120;
    public static final int putosPorCogerMina=10;
    
    String tipo;
    private Image imagen;
    public Sprite sprites;
    private int nivel;

    public Bloque(String tipo, int x, int y, int width, int height, int nivel) {
        super(x, y, width, height);
        this.tipo = tipo;
        this.nivel= nivel;
        this.imagen= imagenDelBloque(tipo,nivel);
        this.sprites= imagenesYAnimacion(tipo);
        
        /*if (Ventana.juego.tipoDeJuego == 0) {
            tamPixelesX=32;
            tamPixelesY=32;
        }*/
    }

    public static void setTamPixelesX(int tamPixelesX) {
        Bloque.tamPixelesX = tamPixelesX;
    }

    public static void setTamPixelesY(int tamPixelesY) {
        Bloque.tamPixelesY = tamPixelesY;
    }
    
    
    
    private Sprite imagenesYAnimacion(String tipo){
            if (tipo.equals("m")) {
                if (Ventana.juego.tipoDeJuego == 0) {
                    String direcciones[]={"src/Imagenes/gold_ingot0.png","src/Imagenes/gold_ingot1.png","src/Imagenes/gold_ingot2.png",
                                        "src/Imagenes/gold_ingot3.png","src/Imagenes/gold_ingot4.png","src/Imagenes/gold_ingot5.png","src/Imagenes/gold_ingot6.png",
                                        "src/Imagenes/gold_ingot7.png","src/Imagenes/gold_ingot8.png","src/Imagenes/gold_ingot9.png","src/Imagenes/gold_ingot10.png",
                                        "src/Imagenes/gold_ingot11.png","src/Imagenes/gold_ingot12.png","src/Imagenes/gold_ingot13.png","src/Imagenes/gold_ingot14.png",
                                        "src/Imagenes/gold_ingot15.png","src/Imagenes/gold_ingot16.png","src/Imagenes/gold_ingot0.png","src/Imagenes/gold_ingot0.png",
                                        "src/Imagenes/gold_ingot0.png","src/Imagenes/gold_ingot0.png","src/Imagenes/gold_ingot0.png","src/Imagenes/gold_ingot0.png",
                                        "src/Imagenes/gold_ingot0.png","src/Imagenes/gold_ingot0.png","src/Imagenes/gold_ingot0.png","src/Imagenes/gold_ingot0.png"};
                    return new Sprite(direcciones);
                }
                else
                    if (Ventana.juego.tipoDeJuego == 1) {
                    String direcciones[]= {"src/Imagenes/Moneda0.png","src/Imagenes/Moneda0.png",           
                        "src/Imagenes/Moneda1.png","src/Imagenes/Moneda1.png",         
                        "src/Imagenes/Moneda1.png","src/Imagenes/Moneda1.png",         
                        "src/Imagenes/Moneda2.png","src/Imagenes/Moneda2.png",
                        "src/Imagenes/Moneda2.png","src/Imagenes/Moneda2.png",
                        "src/Imagenes/Moneda2.png","src/Imagenes/Moneda2.png",
                    "src/Imagenes/Moneda0.png","src/Imagenes/Moneda0.png"};
                    return new Sprite(direcciones);
                }
            }
        return null;
    }
    
    
    private Image imagenDelBloque(String tipo,int nivel){
        if (Ventana.juego.tipoDeJuego == 0) {
            if (tipo.equals("1")) {
                if (nivel == 1 || nivel == 3) {
                    return new ImageIcon(getClass().getResource("/Imagenes/bedrock.png")).getImage();//bedrock
                }
                else
                    if (nivel == 2) {
                        return new ImageIcon(getClass().getResource("/Imagenes/cobblestone.png")).getImage();
                }

            }
            else
                if (tipo.equals("2") || tipo.equals("3")) {
                    if (nivel == 1) {
                        return new ImageIcon(getClass().getResource("/Imagenes/brick.png")).getImage();//brick
                    }
                    else
                        if (nivel == 2 || nivel == 3) {
                            return new ImageIcon(getClass().getResource("/Imagenes/grass_side.png")).getImage();
                    }
            }
            else
                    if (tipo.equals("4")) {
                        return new ImageIcon(getClass().getResource("/Imagenes/ladder.png")).getImage();
            }         
            else
                        if (tipo.equals("5")) {//cambiar por 5 escalera con bloque
                            return new ImageIcon(getClass().getResource("/Imagenes/ladder_brick.png")).getImage();
            }
            else
                            if (tipo.equals("6")) {
                                return new ImageIcon(getClass().getResource("/Imagenes/lead.png")).getImage();
            }
        }
        else
            if (Ventana.juego.tipoDeJuego == 1){
                if (tipo.equals("1")) {
                    if (nivel == 1 || nivel == 3) {
                        return new ImageIcon(getClass().getResource("/Imagenes/nodes2.png")).getImage();//bedrock
                    }
                    else
                        if (nivel == 2) {
                            return new ImageIcon(getClass().getResource("/Imagenes/nodes1.png")).getImage();
                    }

                }
                else
                    if (tipo.equals("2") || tipo.equals("3")) {
                        if (nivel == 1) {
                            return new ImageIcon(getClass().getResource("/Imagenes/tierra.png")).getImage();//brick
                        }
                        else
                            if (nivel == 2 || nivel == 3) {
                                return new ImageIcon(getClass().getResource("/Imagenes/madera.png")).getImage();
                        }
                }
                else
                        if (tipo.equals("4")) {
                            return new ImageIcon(getClass().getResource("/Imagenes/ladder.png")).getImage();
                }         
                else
                            if (tipo.equals("5")) {//cambiar por 5 escalera con bloque
                                return new ImageIcon(getClass().getResource("/Imagenes/ladder_brick.png")).getImage();
                }
                else
                                if (tipo.equals("6")) {
                                    return new ImageIcon(getClass().getResource("/Imagenes/lead.png")).getImage();
                }
            }
        return null;
    }

    public Image getImagen() {
        return imagen;
    }
    
    
    
    
    

}

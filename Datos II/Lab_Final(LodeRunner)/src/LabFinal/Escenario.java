/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author sebastiancaicedo
 */
public class Escenario {
    protected int estado;//0 inicio,1 imagen indicadora de nivel, 2 jugando, 3 ganar, 4 peder
    protected Image imagen;
    protected Sonido sonido;
    
    ArrayList<Image> juegos= new ArrayList();
    private int i=0;//indice que indica el juego seleccionado del arrayList de juegos(tipo del juego o numero del juego)
    
    public Escenario(int estado) {
        
        this.estado = estado;
        imagenYSonidoEstadoActual(this.estado);
        //this.imagen= imagenEstadoActual(this.getEstado());
        juegos.add( imagen);
        juegos.add( new ImageIcon(getClass().getResource("/Imagenes/InicioRPG.png")).getImage());
    }
    
    protected void imagenYSonidoEstadoActual(int estado){
        if (estado == 0) {
                this.imagen= new ImageIcon(getClass().getResource("/Imagenes/InicioMC.png")).getImage();
                this.sonido= new Sonido("MCInicio",-1);
            
        }
        else
            if (estado == 3) {
                if (Ventana.juego.tipoDeJuego == 0) {
                    this.imagen= new ImageIcon(getClass().getResource("/Imagenes/MCganaste.png")).getImage();
                    this.sonido= new Sonido("Ganaste",0);
                }
                else
                    if (Ventana.juego.tipoDeJuego == 1) {
                        this.imagen= new ImageIcon(getClass().getResource("/Imagenes/RPGganaste.png")).getImage();
                        this.sonido= new Sonido("RPGganaste",0);
                }
                
        }
            else 
                if (estado == 4) {
                    if (Ventana.juego.tipoDeJuego == 0) {
                        this.imagen= new ImageIcon(getClass().getResource("/Imagenes/MCperdiste.png")).getImage();
                        this.sonido= new Sonido("Explode", 0);
                    }
                    else
                        if (Ventana.juego.tipoDeJuego == 1) {
                            this.imagen= new ImageIcon(getClass().getResource("/Imagenes/RPGperdiste.png")).getImage();
                            this.sonido= new Sonido("RPGperdiste",0);
                    }
                        
        }
    }
    
    private void imagenYSonidoJuegoSeleccionado(int indice){
        this.detenerSonido();
        if (indice == 0) {
            this.imagen= new ImageIcon(getClass().getResource("/Imagenes/InicioMC.png")).getImage();
            this.sonido= new Sonido("MCInicio",-1);
        }
        else
            if (indice == 1) {
                this.imagen= new ImageIcon(getClass().getResource("/Imagenes/InicioRPG.png")).getImage();
                this.sonido= new Sonido("RPGinicio",-1);
        }
        this.sonar();
    }
    
    public void pintar(Graphics2D g){
        g.drawImage(this.getImagen(),0, 0,null);
        if (estado == 0) {
            g.setColor(Color.WHITE);
            g.drawString("<----     Seleccione la Versión    ---->", 300, 500);
        }
    }
    
    public void sonar(){
        try {
            this.getSonido().Sonar();
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Escenario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Escenario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Escenario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void detenerSonido(){
        this.sonido.detener();
    }
    
    public void teclaPresionada(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            this.detenerSonido();
            if (this.estado == 0){ 
                Ventana.juego=new Juego(1, i);
                try {
                        Ventana.actualizarEscenario(new Nivel(Ventana.juego.nivel, 1));
                    
                } catch (Exception ex) {
                    Logger.getLogger(Escenario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else 
                if (this.estado == 3) {
                    
                try {
                    if (Ventana.juego.nivel < Juego.totalNiveles) {
                        Ventana.actualizarEscenario(new Nivel(++Ventana.juego.nivel, 1));
                    }
                    else
                    {
                        Ventana.actualizarEscenario(new Escenario(0));
                    }
                    
                } catch (Exception ex) {
                    Logger.getLogger(Escenario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                    if (this.estado == 4) {
                try {
                    Ventana.actualizarEscenario(new Nivel(Ventana.juego.nivel, 1));
                } catch (Exception ex) {
                    Logger.getLogger(Escenario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (estado == 0) {
                if (i < juegos.size()-1) {
                    i++;
                }
                else
                {
                    i=0;
                }
                imagenYSonidoJuegoSeleccionado(i);
            }
            
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (estado == 0) {
                if (i > 0) {
                    i--;
                }
                else
                {
                    i=juegos.size()-1;
                }
                imagenYSonidoJuegoSeleccionado(i);
            }
            
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            this.sonido.detener();
            Ventana.actualizarEscenario(new Escenario(0));
        }
        
    }
    
    public void teclaLevantada(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public Image getImagen() {
        return imagen;
    }


    public Sonido getSonido() {
        return sonido;
    }
    
    
}

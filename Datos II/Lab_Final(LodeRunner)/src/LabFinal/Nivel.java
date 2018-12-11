/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
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
public class Nivel extends Escenario{
    
    private int nivelActual;
    private Image imagenFondo;
    private File archivoMapaNivel;
    private int filas;
    private int col;
    private String[][] mapaNivel;
    
    //Lista de Bloques para mayor eficiencia en el juego
    private ArrayList<Bloque> bloquesNoDestructibles= new ArrayList<Bloque>();
    private ArrayList<Bloque> bloquesNormales= new ArrayList<Bloque>();
    private ArrayList<Bloque> bloquesFalsos= new ArrayList<Bloque>();
    private ArrayList<Bloque> escaleras= new ArrayList<Bloque>();
    private ArrayList<Bloque> escaleraConBloque= new ArrayList<Bloque>();
    private ArrayList<Bloque> barrasDeSoporte= new ArrayList<Bloque>();
    private ArrayList<Bloque> minas= new ArrayList<Bloque>();
    private ArrayList<Bloque> bloquesDestruidos= new ArrayList<Bloque>();
        
    private ArrayList<Enemigo> enemigos= new ArrayList<Enemigo>();
    private ArrayList<Enemigo> enemigosMuertos= new ArrayList<Enemigo>();
    private Rectangle spawnPoint;

    
    private Personaje personaje;
    private Arma espada;
            
    private static final int distanciaLimiteMoverCamara=300;
    
    private int tiempo=0;
    
    
    private int puntoReferenciaPintarBloques;//para empezar a pintar los bloques justo para que termine en el final de la ventana
    private int puntodeReferenciaPintarPersonaje;

    
    public Nivel(int nivelActual, int estado) throws Exception {
        super(estado);
        this.nivelActual = nivelActual;
        contructorCompleto(this.nivelActual);
        //cargarNivel();
        
    }
    
    private void contructorCompleto(int nivelActual){
            try {
                if (nivelActual == 1 || nivelActual == 2) {
                    this.filas=15;
                    this.col=30;
                    
                }
                else
                    if (nivelActual == 3) {
                    this.filas=18;
                    this.col=30;
                }
                if (Ventana.juego.tipoDeJuego == 0) {
                    Bloque.setTamPixelesX(32);
                    Bloque.setTamPixelesY(32);
                    
                    Personaje.setTamPixelesX(32);
                    Personaje.setTamPixelesY(64);
                    Enemigo.setTamPixelesX(32);
                    Enemigo.setTamPixelesY(64);
                }
                else
                    if (Ventana.juego.tipoDeJuego == 1) {
                        Bloque.setTamPixelesX(32);
                        Bloque.setTamPixelesY(32);

                        Personaje.setTamPixelesX(24);
                        Personaje.setTamPixelesY(40);
                        Enemigo.setTamPixelesX(32);
                        Enemigo.setTamPixelesY(40);
                }
                puntoReferenciaPintarBloques= Ventana.defaultHeight - (this.filas*Bloque.tamPixelesY);//para empezar a pntar justo para que termine en el final de la ventana
                if (Ventana.juego.tipoDeJuego == 0) {
                    puntodeReferenciaPintarPersonaje= puntoReferenciaPintarBloques- Bloque.tamPixelesY;
                }
                else
                {
                    puntodeReferenciaPintarPersonaje= puntoReferenciaPintarBloques-(Personaje.tamPixelesY-Bloque.tamPixelesY);
                }
                
                imagenYSonidoEstadoActual(this.nivelActual);
                this.archivoMapaNivel= new File(archivoDelNivel(this.nivelActual));
                this.mapaNivel= Mundo.generarMatriz(new Mundo(filas, col));
                this.imagenFondo= imagenFondoDelNivel(this.nivelActual);
                cargarNivel();
            } catch (Exception ex) {
                Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void cargarNivel() throws Exception{
        this.mapaNivel= LectorEscritor.cargarDatos(archivoMapaNivel, this.filas, this.col);
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.col; j++) {
                
                String pos= mapaNivel[i][j];
                
                if (pos.equals("1")) {
                    this.bloquesNoDestructibles.add(new Bloque("1",Bloque.tamPixelesX*j,Bloque.tamPixelesY*i+puntoReferenciaPintarBloques,Bloque.tamPixelesX,Bloque.tamPixelesY,nivelActual));
                }
                else
                    if (pos.equals("2")) {
                        this.bloquesNormales.add(new Bloque("2",Bloque.tamPixelesX*j,Bloque.tamPixelesY*i+puntoReferenciaPintarBloques,Bloque.tamPixelesX,Bloque.tamPixelesY,nivelActual));
                }
                else
                        if (pos.equals("3")) {
                            this.bloquesFalsos.add(new Bloque("3", Bloque.tamPixelesX*j, Bloque.tamPixelesY*i+puntoReferenciaPintarBloques, Bloque.tamPixelesX, Bloque.tamPixelesY,nivelActual));
                    
                }
                else
                            if (pos.equals("4")) {
                                this.escaleras.add(new Bloque("4",Bloque.tamPixelesX*j,Bloque.tamPixelesY*i+puntoReferenciaPintarBloques,Bloque.tamPixelesX,Bloque.tamPixelesY,nivelActual));
                }
                else
                                if (pos.equals("5")) {
                                    this.escaleraConBloque.add(new Bloque("5",Bloque.tamPixelesX*j,Bloque.tamPixelesY*i+puntoReferenciaPintarBloques,Bloque.tamPixelesX,Bloque.tamPixelesY,nivelActual));
                }
                else
                                    if (pos.equals("6")) {
                                        this.barrasDeSoporte.add(new Bloque("6",Bloque.tamPixelesX*j,Bloque.tamPixelesY*i+puntoReferenciaPintarBloques,Bloque.tamPixelesX,Bloque.tamPixelesY,nivelActual));

                }
                else
                                        if (pos.equals("m")) {
                                            this.minas.add(new Bloque("m",Bloque.tamPixelesX*j,Bloque.tamPixelesY*i+puntoReferenciaPintarBloques,Bloque.tamPixelesY,Bloque.tamPixelesX,nivelActual));
                }
                else
                                            if (pos.equals("p")) {
                                                this.personaje= new Personaje(Bloque.tamPixelesX*j, Bloque.tamPixelesY*i+puntodeReferenciaPintarPersonaje, Personaje.tamPixelesX, Personaje.tamPixelesY);
                }
                else
                                                if (pos.equals("e")) {
                                                    this.enemigos.add(new Enemigo(Bloque.tamPixelesX*j, Bloque.tamPixelesY*i+puntodeReferenciaPintarPersonaje, Enemigo.tamPixelesX, Enemigo.tamPixelesY));
                }
                else
                                                    if (pos.equals("a")) {
                                                        this.espada= new Arma(Arma.tamPixelsX*j, Arma.tamPixelsY*i+puntoReferenciaPintarBloques, Arma.tamPixelsX, Arma.tamPixelsY);
                }
                else
                                                        if (pos.equals("s")) {
                                                            this.spawnPoint= new Rectangle(Bloque.tamPixelesX*j, Bloque.tamPixelesY*i+puntodeReferenciaPintarPersonaje, Bloque.tamPixelesX, Bloque.tamPixelesY);
                }
                
            }
        }
    }
    
    private String archivoDelNivel(int nivel){
        if (nivel == 1) {
            return "src/ArchivosMundos/Nivel1.txt";
        }
        else
            if (nivel == 2) {
            return "src/ArchivosMundos/Nivel2.txt";
        }
        else
                if (nivel == 3) {
                    return "src/ArchivosMundos/Nivel3.txt";
        }
        return null;
    }
    
    @Override
    protected void imagenYSonidoEstadoActual(int nivel){
        if (Ventana.juego.tipoDeJuego == 0) {
            if (this.estado == 2) {//cambiar musica para cada nivel
                this.sonido= new Sonido("MCmusicaNivel", -1);
            }
            else
            {
                this.sonido= new Sonido("Fuse_explode", 0);
                if (nivel == 1) {
                    this.imagen= new ImageIcon(getClass().getResource("/Imagenes/MCindicadornivel1.png")).getImage();
                }
                else
                    if (nivel == 2) {
                        this.imagen= new ImageIcon(getClass().getResource("/Imagenes/MCindicadornivel2.png")).getImage();
                }
                else
                        if (nivel == 3) {
                            this.imagen= new ImageIcon(getClass().getResource("/Imagenes/MCindicadornivel3.png")).getImage();
                }
            }
        }
        else
            if (Ventana.juego.tipoDeJuego == 1){//Imagen indicadora del nivel del otro tipo de juego 
                if (this.estado == 2) {//cambiar musica para cada nivel
                    if (nivelActual == 1) {
                        this.sonido= new Sonido("RPGnivel1", -1);
                    }
                    else
                        if (nivelActual == 2) {
                            this.sonido= new Sonido("RPGnivel2", -1);
                    }
                    else   
                            if (nivelActual == 3) {
                                this.sonido= new Sonido("RPGnivel3", -1);
                    }
                }
                else
                {
                    this.sonido= new Sonido("RPGindicadornivel", 0);
                    if (nivel == 1) {
                        this.imagen= new ImageIcon(getClass().getResource("/Imagenes/RPGindicadornivel1.png")).getImage();
                    }
                    else
                        if (nivel == 2) {
                            this.imagen= new ImageIcon(getClass().getResource("/Imagenes/RPGindicadornivel2.png")).getImage();
                    }
                    else
                            if (nivel == 3) {
                                this.imagen= new ImageIcon(getClass().getResource("/Imagenes/RPGindicadornivel3.png")).getImage();
                    }
                }
            }
    }
    
    private Image imagenFondoDelNivel(int nivel){
        ImageIcon img= null;
        if (Ventana.juego.tipoDeJuego == 0) {
            if (nivel == 1) {
                img = new ImageIcon(getClass().getResource("/Imagenes/MCfondonivel1.png"));
            }
            else
                if (nivel == 2){
                    img = new ImageIcon(getClass().getResource("/Imagenes/MCfondonivel2.png"));
                }
            else
                    if (nivel == 3){
                        img = new ImageIcon(getClass().getResource("/Imagenes/MCfondonivel3.png"));
                    }
        }
        else
            if (Ventana.juego.tipoDeJuego == 1){
                if (nivel == 1) {
                img = new ImageIcon(getClass().getResource("/Imagenes/RPGfondonivel1.png"));
            }
            else
                if (nivel == 2){
                    img = new ImageIcon(getClass().getResource("/Imagenes/RPGfondonivel2.png"));
                }
            else
                    if (nivel == 3){
                        img = new ImageIcon(getClass().getResource("/Imagenes/RPGfondonivel3.png"));
                    }
            }
        return img.getImage();
    }
    
    @Override
    public void pintar(Graphics2D g){
        tiempo++;
        if (estado == 1) {
            g.drawImage(this.imagen, 0, 0, null);
        }
        else
        { 
            if (!verifMuerteporEnemigo()) {
                pintarMapa(g);
            }
            else
            {
                this.sonido.detener();
                actualizarPuntaje(4);
                Ventana.actualizarEscenario(new Escenario(4));
            }
        }
    }
    
    private void pintarMapa(Graphics2D g){
        g.clearRect(0, 0, Ventana.defaultWidth, Ventana.defaultHeight);
        g.drawImage(imagenFondo, 0, 0, null);
        pintarPuntajes(g);
        int fin;
        
        fin= this.bloquesNoDestructibles.size();
        for (int i = 0; i < fin; i++) {
            g.drawImage(bloquesNoDestructibles.get(i).getImagen(), bloquesNoDestructibles.get(i).x, bloquesNoDestructibles.get(i).y, null);
        }
        
        fin = this.bloquesNormales.size();
        for (int i = 0; i < fin/*bloquesNormales.size()*/; i++) {
            g.drawImage(this.bloquesNormales.get(i).getImagen(), this.bloquesNormales.get(i).x, this.bloquesNormales.get(i).y, null);
        }
        
        fin= this.bloquesFalsos.size();
        for (int i = 0; i < fin; i++) {
            g.drawImage(this.bloquesFalsos.get(i).getImagen(), this.bloquesFalsos.get(i).x, bloquesFalsos.get(i).y, null);
        }
        
        fin= this.escaleras.size();
        for (int i = 0; i < fin; i++) {
            g.drawImage(this.escaleras.get(i).getImagen(), this.escaleras.get(i).x, this.escaleras.get(i).y, null);
        }
        
        fin= this.escaleraConBloque.size();
        for (int i = 0; i < fin; i++) {
            g.drawImage(this.escaleraConBloque.get(i).getImagen(), this.escaleraConBloque.get(i).x, this.escaleraConBloque.get(i).y, null);
        }
        
        fin= this.barrasDeSoporte.size();
        for (int i = 0; i < fin; i++) {
            g.drawImage(this.barrasDeSoporte.get(i).getImagen(), this.barrasDeSoporte.get(i).x, this.barrasDeSoporte.get(i).y, null);
        }
        
        fin= this.minas.size();
        for (int i = 0; i < fin; i++) {
            g.drawImage(this.minas.get(i).sprites.next(), this.minas.get(i).x, this.minas.get(i).y, null);
        }
        
        pintarMovPersonaje(g);
        pintarMovEnemigo(g);
        if (!personaje.tieneArma) {
            pintarEspada(g);
        }
        aparecerBloque();
        aparecerEnemigos();
        verifMuertePorBloque(personaje);
        for (int i = 0; i < enemigos.size(); i++) {
            verifMuertePorBloque(enemigos.get(i));   
        }
        /*if (personaje.atacar) {
            atacar(g);
        }*/
    }
    
    private void pintarMovPersonaje(Graphics2D g){
        
        if (!personaje.seMueve && verifGrounded(personaje)) {
            if (!pasandoBarra(personaje)) {
                if (personaje.atacar) {
                    atacar(g);
                }
                else
                    if (personaje.destruirBloque == 1) {
                        g.drawImage(personaje.spriteMinandoIzq.next(), personaje.x-personaje.width, personaje.y, null);
                        personaje.destruirBloque=0;
                }
                    else
                        if (personaje.destruirBloque == 3) {
                            g.drawImage(personaje.spriteMinandoDer.next(), personaje.x, personaje.y, null);
                            personaje.destruirBloque=0;
                }
                else
                {
                    g.drawImage(personaje.spriteQuieto.next(), personaje.x, personaje.y, null);
                }
            }
            else
            {
                
                g.drawImage(personaje.spriteBarraDer.getimagenSprite(0).getImage(), personaje.x, personaje.y, null);
            }
            
        }
        else
        {
            if (verifGrounded(personaje)) {
                
        
            if (personaje.direccion == 1) {
                if (!hayBloqueCerca(1,personaje)) {
                    if (pasandoBarra(personaje)) {
                            g.drawImage(personaje.spriteBarraIzq.next(), personaje.x, personaje.y, null);
                            this.personaje.mover(1);
                    }
                    else
                    {
                        g.drawImage(personaje.spriteIzq.next(), personaje.x, personaje.y, null);
                        if (!verifTrasladar(1)) {//O se traslada el mundo o se mueve el personaje
                            this.personaje.mover(1);//1 es izquierda 
                        }
                        else
                        {
                            trasladarBloques(1);
                        }
                        verifCogerMinas();
                        if (!personaje.tieneArma) {
                            verifCogerArma();
                        }
                        
                    }
                }
            
                else
                {
                    personaje.seMueve=false;
                }
                
            }
            else
                if (personaje.direccion == 2) {
                    if (!hayBloqueCerca(2,personaje)) {
                        if (hayEscaleras(personaje)) {
                            g.drawImage(personaje.spriteSubir.next(), personaje.x, personaje.y, null);
                            this.personaje.mover(2);
                            verifCogerMinas();
                            if (!personaje.tieneArma) {
                                verifCogerArma();
                            }
                        }
                        else
                        {
                            personaje.seMueve=false;
                        }
                        
                    }
                    else
                    {
                        personaje.seMueve=false;
                    }
                    
            }
            else
                    if (personaje.direccion == 3) {
                        if (!hayBloqueCerca(3,personaje)) {
                            if (pasandoBarra(personaje)) {
                                g.drawImage(personaje.spriteBarraDer.next(), personaje.x, personaje.y, null);
                                this.personaje.mover(3);
                            }
                            else
                            {
                                g.drawImage(personaje.spriteDer.next(), personaje.x, personaje.y, null);
                                if (!verifTrasladar(3)) {
                                    this.personaje.mover(3);
                                }
                                else
                                {
                                    trasladarBloques(-1);
                                }
                                verifCogerMinas();
                                if (!personaje.tieneArma) {
                                    verifCogerArma();
                                }
                            }
                        }
                        else
                        {
                            personaje.seMueve=false;
                        }
            }
            else
                        if (personaje.direccion == 4) {
                            if (!hayBloqueCerca(4,personaje)){                         
                                g.drawImage(personaje.spriteSubir.next(), personaje.x, personaje.y, null);
                                personaje.mover(4);
                                verifCogerMinas();
                                if (!personaje.tieneArma) {
                                    verifCogerArma();
                                }
                            }
                            else
                            {
                                personaje.seMueve= false;
                            }
                        }
            }
            else
            {
                g.drawImage(personaje.spriteQuieto.next(), personaje.x, personaje.y,null);
                personaje.caer();
                verifCogerMinas();
                if (!personaje.tieneArma) {
                    verifCogerArma();
                }
                
            }
        }
        
    }
    
    private void pintarMovEnemigo(Graphics2D g){
        Enemigo enemigo;
        for (int i = 0; i < enemigos.size(); i++) {
            enemigo= enemigos.get(i);
            //g.drawImage(enemigo.imagen, enemigo.x, enemigo.y, null);
            if (verifGrounded(enemigo)) {
                if (!hayBloqueCerca(1, enemigo)) {
                        enemigo.Perseguir(1,personaje);
                    
                }
                if (!hayBloqueCerca(2, enemigo)) {
                    if (hayEscaleras(enemigo)) {
                        enemigo.Perseguir(2,personaje);
                        //g.drawImage(enemigo.imagen, enemigo.x, enemigo.y, null);
                    }
                    
                }
                if (!hayBloqueCerca(3, enemigo)) {
                    enemigo.Perseguir(3,personaje);
                    
                }
                if (!hayBloqueCerca(4, enemigo)) {
                    enemigo.Perseguir(4,personaje);
                    //g.drawImage(enemigo.imagen, enemigo.x, enemigo.y, null);
                }
                if (enemigo.seMueve) {
                    if (enemigo.direccion == 1) {
                        g.drawImage(enemigo.spriteIzq.next(), enemigo.x, enemigo.y, null);
                    }
                    else
                        if (enemigo.direccion == 3) {
                            g.drawImage(enemigo.spriteDer.next(), enemigo.x, enemigo.y, null);
                    }
                    else
                            if (enemigo.direccion == 2) {
                                g.drawImage(enemigo.spriteSubir.next(), enemigo.x, enemigo.y, null);
                    }
                    else
                                if (enemigo.direccion == 4) {
                                    g.drawImage(enemigo.spriteSubir.next(), enemigo.x, enemigo.y, null);
                    }
                }
                
                
            }
            else
            {
                enemigo.caer();
                g.drawImage(enemigo.spriteQuieto.next(), enemigo.x, enemigo.y, null);
            }
            
        }
    }
    
    private void pintarPuntajes(Graphics2D g){
        g.setColor(Color.RED);
        g.drawString("Nivel: "+ Ventana.juego.nivel, 25, 25);
        g.drawString("Enemigos Asesinados: "+ Ventana.juego.enemigosAsesinados, 100, 25);
        g.drawString("Puntaje: "+Ventana.juego.puntaje,300 , 25);
        if (personaje.tieneArma) {
            g.drawString("Tiene el arma: "+"SI", 400, 25);
        }
        else
        {
            g.drawString("Tiene el arma: "+"NO", 400, 25);
        }
        
    }
    
    private void pintarEspada(Graphics2D g){
        if (espada.aparecio== false) {
            aparecerEspada();
        }
        else
        {
            g.drawImage(espada.imagen, espada.x, espada.y, null);
            if (!verifGrounded(espada)) {
                espada.caer();
            }
        }
    }
    
    private boolean hayEscaleras(Rectangle elemento){
        int fin;
        fin= escaleras.size();
        for (int i = 0; i < fin; i++) {
            if (elemento.intersects(escaleras.get(i))) {
                return true;
            }
        }
        fin= escaleraConBloque.size();
        for (int i = 0; i < fin; i++) {
            if (elemento.intersects(escaleraConBloque.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    private boolean verifGrounded(Rectangle elemento){
        int fin;
        Bloque bloque;
        fin= bloquesNoDestructibles.size();
        for (int i = 0; i < fin; i++) {
            bloque= bloquesNoDestructibles.get(i);
            if (elemento.intersects(bloque.x,bloque.y-1,bloque.width,bloque.height)) {
                return true;
            }
        }
        fin=bloquesNormales.size();
        for (int i = 0; i < fin; i++) {
            bloque= bloquesNormales.get(i);
            if (elemento.intersects(bloque.x,bloque.y-1,bloque.width,bloque.height)) {
                return true;
            }
        }
        fin= escaleras.size();
        for (int i = 0; i < fin; i++) {
            bloque= escaleras.get(i);
            if (elemento.intersects(bloque)) {
                return true;
            }
        }
        fin= escaleraConBloque.size();
        for (int i = 0; i < fin; i++) {
            bloque=escaleraConBloque.get(i);
            if (elemento.intersects(bloque.x,bloque.y-1,bloque.width,bloque.height)) {
                return true;
            }
        }
        if (elemento == personaje) {
            fin=barrasDeSoporte.size();
            for (int i = 0; i < fin; i++) {
                bloque=barrasDeSoporte.get(i);
                if (elemento.intersects(bloque.x,bloque.y,bloque.width,3)) {
                    return true;
                    
                }
            }
        }
        
        return false;
    }
    
    private void verifCogerMinas(){//verifica si el jugador coge las minas y la elimina si si
        for (int i = 0; i < minas.size(); i++) {
            if (personaje.intersects(minas.get(i))) {
                try {
                    new Sonido("Pop", 0).Sonar();
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
                }
                minas.remove(i);
                actualizarPuntaje(1);
                
            }
        }
        if (minas.isEmpty()) {
            this.sonido.detener();
            actualizarPuntaje(5);
            Ventana.actualizarEscenario(new Escenario(3));
        }
    }
    
    private boolean hayBloqueCerca(int direccion, Rectangle elemento){
        Bloque bloque;
        for (int i = 0; i < bloquesNoDestructibles.size(); i++) {
            bloque= bloquesNoDestructibles.get(i);
            if (direccion == 1) {
                if (elemento.intersects(bloque.x+1,bloque.y,bloque.width,bloque.height)) {
                    return true;
                }
            }
            else
                if (direccion == 2){
                    if (elemento.intersects(bloque.x,bloque.y+1,bloque.width,bloque.height)) {
                        return true;
                    }
                }
            else
                    if (direccion == 3){
                        if (elemento.intersects(bloque.x-1,bloque.y,bloque.width,bloque.height)) {
                            return true;
                        }
                    }
            else
                        if (direccion == 4){
                            if (elemento.intersects(bloque.x,bloque.y-1,bloque.width,bloque.height)) {
                                return true;
                            }
                        }
        }
        
        for (int i = 0; i < bloquesNormales.size(); i++) {
            bloque= bloquesNormales.get(i);
            if (direccion == 1) {
                if (elemento.intersects(bloque.x+1,bloque.y,bloque.width,bloque.height)) {
                    return true;
                }
            }
            else
                if (direccion == 2){
                    if (elemento.intersects(bloque.x,bloque.y+1,bloque.width,bloque.height)) {
                        return true;
                    }
                }
            else
                    if (direccion == 3){
                        if (elemento.intersects(bloque.x-1,bloque.y,bloque.width,bloque.height)) {
                            return true;
                        }
                    }
            else
                        if (direccion == 4){
                            if (elemento.intersects(bloque.x,bloque.y-1,bloque.width,bloque.height)) {
                                return true;
                            }
                        }
        }
        return false;
    }
    
    private boolean pasandoBarra(Rectangle elemento){
        for (int i = 0; i < barrasDeSoporte.size(); i++) {
            if (elemento.intersects(barrasDeSoporte.get(i).x,barrasDeSoporte.get(i).y,barrasDeSoporte.get(i).width,3)) {
                return true;
            }
        }
        return false;
    }
    
    
    private void trasladarBloques(int sentido){//Mover la camara
        int fin;
        fin= bloquesNoDestructibles.size();
        for (int i = 0; i < fin; i++) {
            bloquesNoDestructibles.get(i).x+= Personaje.pixelesDezplMovimiento*sentido;
        }
        fin= bloquesNormales.size();
        for (int i = 0; i < fin; i++) {
            bloquesNormales.get(i).x+= Personaje.pixelesDezplMovimiento*sentido;
        }
        fin= bloquesFalsos.size();
        for (int i = 0; i < fin; i++) {
            bloquesFalsos.get(i).x+=Personaje.pixelesDezplMovimiento*sentido;
        }
        fin= minas.size();
        for (int i = 0; i < fin; i++) {
            minas.get(i).x+= Personaje.pixelesDezplMovimiento*sentido;
        }
        fin= escaleras.size();
        for (int i = 0; i < fin; i++) {
            escaleras.get(i).x+= Personaje.pixelesDezplMovimiento*sentido;
        }
        fin= escaleraConBloque.size();
        for (int i = 0; i < fin; i++) {
            escaleraConBloque.get(i).x+= Personaje.pixelesDezplMovimiento*sentido;
        }
        fin= barrasDeSoporte.size();
        for (int i = 0; i < fin; i++) {
            barrasDeSoporte.get(i).x+= Personaje.pixelesDezplMovimiento*sentido;
        }
        fin= enemigos.size();
        for (int i = 0; i < fin; i++) {
            enemigos.get(i).x+= Personaje.pixelesDezplMovimiento*sentido;
        }
        if (!bloquesDestruidos.isEmpty()) {
            fin=bloquesDestruidos.size();
            for (int i = 0; i < fin; i++) {
                bloquesDestruidos.get(i).x+= Personaje.pixelesDezplMovimiento*sentido;
            }
        }
        //if (espada.aparecio) {
            espada.x+= Personaje.pixelesDezplMovimiento*sentido;
        //}
    }
    
    private boolean verifTrasladar(int direccion){
        if (direccion == 1) {
            if (bloquesNoDestructibles.get(0).x < 0) {
                if (this.personaje.x < distanciaLimiteMoverCamara) {
                    return true;
                }
            }
        }
        else
            if (direccion == 3) {
                if (bloquesNoDestructibles.get(bloquesNoDestructibles.size()-1).x > Ventana.defaultWidth-Bloque.tamPixelesX) {
                    if (this.personaje.x > Ventana.defaultWidth - distanciaLimiteMoverCamara) {
                        return true;
                    }
                }
                
        }
        return false;
    }
    
    private void destruirBloque(int dir){
        Bloque bloque;
        int posBloqDestruir;
        int i=0;boolean sw=false;
        if (dir==1) {
            posBloqDestruir = columnaActual()-1;
            personaje.destruirBloque= 1;
        }
        else
        {
            posBloqDestruir = columnaActual()+1;
            personaje.destruirBloque= 3;
        }
        while(sw == false && i < bloquesNormales.size()){
            bloque= bloquesNormales.get(i);
            if (bloque.x == posBloqDestruir*Bloque.tamPixelesX && bloque.y == personaje.y+Personaje.tamPixelesY) {
                bloquesDestruidos.add(bloque);
                bloquesNormales.remove(i);
                sw=true;
            }
            i++;
        }
        
    }
    
    private void atacar(Graphics2D g){
        for (int i = 0; i < enemigos.size(); i++) {
            Enemigo enemigo= enemigos.get(i);
                if (enemigo.intersects(new Rectangle(personaje.x-Personaje.tamPixelesX, personaje.y, Personaje.tamPixelesX, Personaje.tamPixelesY))) {
                    for (int j = 0; j < personaje.spriteAtacarIzq.size; j++) {
                        g.drawImage(personaje.spriteAtacarIzq.next(), personaje.x-personaje.width, personaje.y, null);
                    }
                    actualizarPuntaje(2);
                    enemigosMuertos.add(new Enemigo(spawnPoint.x, spawnPoint.y, Enemigo.tamPixelesX, Enemigo.tamPixelesY));
                    enemigos.remove(i);
                }
                else
                    if (enemigo.intersects(new Rectangle(personaje.x+Personaje.tamPixelesX, personaje.y, Personaje.tamPixelesX, Personaje.tamPixelesY))) {
                        for (int k = 0; k < personaje.spriteAtacarDer.size; k++) {
                            g.drawImage(personaje.spriteAtacarDer.next(), personaje.x, personaje.y, null);
                        }
                        actualizarPuntaje(2);
                        enemigosMuertos.add(new Enemigo(spawnPoint.x, spawnPoint.y, Enemigo.tamPixelesX, Enemigo.tamPixelesY));
                        enemigos.remove(i);
                    }
        }
        personaje.atacar=false;
    }
    
    private int columnaActual(){
        return personaje.x/Bloque.tamPixelesX;
    }
    
    private void aparecerBloque(){
        if (!bloquesDestruidos.isEmpty()) {
            if (tiempo%Bloque.tiempoVolverAparecer == 0) {
                bloquesNormales.add(bloquesDestruidos.get(0));
                bloquesDestruidos.remove(0);
            }
        }
        
    }
    
    private void aparecerEspada(){
        if (tiempo == espada.tiempoAparicion) {
            espada.aparecio=true;
        }
    }
    
    private void aparecerEnemigos(){
        if (!enemigosMuertos.isEmpty()) {
            if (tiempo%Enemigo.tiempoAparicion == 0) {
                enemigos.add(enemigosMuertos.get(0));
                enemigosMuertos.remove(0);
            }
            
        }
        
    }
    
    private void verifCogerArma(){
        if (personaje.intersects(espada)) {
            try {
                new Sonido("Arma", 0).Sonar();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
            }
            personaje.tieneArma=true;
            actualizarPuntaje(3);
        }
    }
    
    private void verifMuertePorBloque(Rectangle elemento){
        for (int i = 0; i < bloquesNormales.size(); i++) {
            if (bloquesNormales.get(i).intersects(elemento)) {
                if (elemento == personaje) {
                    this.sonido.detener();
                    actualizarPuntaje(4);
                    Ventana.actualizarEscenario(new Escenario(4));
                }
                else
                {
                    enemigosMuertos.add(new Enemigo(spawnPoint.x, spawnPoint.y, Enemigo.tamPixelesX, Enemigo.tamPixelesY));
                    enemigos.remove((Enemigo)elemento);
                }
            }
        }
    }
    
    private boolean verifMuerteporEnemigo(){
        for (int i = 0; i < enemigos.size(); i++) {
            if (personaje.intersects(enemigos.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    private boolean verifAtacar(){
        if (personaje.tieneArma) {
            for (int i = 0; i < enemigos.size(); i++) {
                if (enemigos.get(i).intersects(personaje.x-personaje.width,personaje.y,personaje.width,personaje.height) || enemigos.get(i).intersects(personaje.x+personaje.width,personaje.y,personaje.width,personaje.height)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void actualizarPuntaje(int n){
        if (n == 1) {//Cogio mina
            Ventana.juego.puntaje+= Bloque.putosPorCogerMina;
        }
        else
            if (n == 2) {//Mato enemigo
                Ventana.juego.puntaje+= Enemigo.puntosPorMuerte;
                Ventana.juego.enemigosAsesinados++;
        }
        else
                if (n == 3) {//cogio espada
                    Ventana.juego.puntaje+= Arma.puntosPorCogerEspada;
        }
        else
                    if (n == 4) {//muerte
                        if (Ventana.juego.puntaje > Personaje.puntosPorMuerte) {
                            Ventana.juego.puntaje-= Personaje.puntosPorMuerte;
                        }
                        else
                        {
                            Ventana.juego.puntaje = 0;
                        }
                        
        }
        else
                        if (n == 5) {//puntos por tiempo de juego
                            Ventana.juego.puntaje+= 200000/tiempo;
        }
    }
    
    @Override
    public void teclaPresionada(KeyEvent e){
        
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.estado == 1) {
                this.sonido.detener();
                this.estado=2;
                imagenYSonidoEstadoActual(this.estado);
                try {
                    this.sonido.Sonar();
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Nivel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (verifGrounded(personaje)) {
                personaje.isGrounded=true;
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    if (!hayBloqueCerca(1,personaje)) {
                        personaje.seMueve=true;
                        personaje.direccion=1;
                    }
                    else
                    {
                        personaje.seMueve=false;
                    }                   
                }
                else
                        if(e.getKeyCode() == KeyEvent.VK_UP){
                            if (!hayBloqueCerca(2,personaje)) {
                                if (hayEscaleras(personaje)) {
                                    personaje.seMueve=true;
                                    personaje.direccion=2; 
                                }
                                else
                                {
                                    personaje.seMueve= false;
                                }
                                
                            }
                            else
                            {
                                personaje.seMueve=false;
                            }
                                                     
                        }
                else
                            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                                if (!hayBloqueCerca(3,personaje)) {
                                    personaje.seMueve=true;
                                    personaje.direccion=3;
                                }
                                else
                                {
                                    personaje.seMueve=false;
                                }   
                            }
                else
                                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                                    if (!hayBloqueCerca(4,personaje)) {
                                        personaje.seMueve=true;
                                        personaje.direccion=4;      
                                    }
                                    else
                                    {
                                        personaje.seMueve=false;
                                    }
                                     
                                }
            }
            else
            {
                personaje.isGrounded=false;
            }
        }
        
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            destruirBloque(1);
        }         
        if (e.getKeyCode() == KeyEvent.VK_X) {
            destruirBloque(3);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (verifAtacar()) {
                personaje.atacar=true;
//atacar();
            }
        }
        
        if (e.getKeyCode() == KeyEvent.VK_R) {
            this.sonido.detener();
            Ventana.actualizarEscenario(new Escenario(0));
        }
    }
    
    @Override
    public void teclaLevantada(KeyEvent e){
        if (this.estado == 2) {
            personaje.seMueve=false;
            personaje.direccion=0;
        }
        
    }
    
    public int getNivelActual() {
        return nivelActual;
    } 
    
}

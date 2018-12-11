/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author COMPUTER
 */
public class Sonido {
    
   Clip ol;
   String dir;
   int times;// -1 reproduccion infinita hasta ser interrumpido

    public Sonido(String dir, int times) {
        this.dir = "Sonidos\\"+dir+".wav";
        this.times = times;
    }
   
   public void Sonar() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
           File sf=new File(dir); 
           AudioFileFormat aff; 
           AudioInputStream ais; 
           aff=AudioSystem.getAudioFileFormat(sf); 
           ais=AudioSystem.getAudioInputStream(sf);
           AudioFormat af=aff.getFormat();
           DataLine.Info info = new DataLine.Info( 
                   Clip.class, 
                   ais.getFormat(), 
                   ((int) ais.getFrameLength() * 
                           af.getFrameSize()));
           ol = (Clip) AudioSystem.getLine(info);
           ol.open(ais);
           ol.loop(times);
           //ol.loop(-1);
    }
    public void detener() {
            if (ol != null) {
                ol.stop();
                ol.close();
            }

    }
}

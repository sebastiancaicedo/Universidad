/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabFinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author sebastiancaicedo
 */
public class LectorEscritor {
    
    
    
    public static String[][] cargarDatos(File file,int numFilas, int numCol) throws Exception{
        String[][]  retorno= new String[numFilas][numCol];
        BufferedReader buferedreader= new BufferedReader(new FileReader(file));
        String linea= buferedreader.readLine();
        int i=0;
        while (linea != null) {
           
            //for (int i = 0; i < numFilas; i++) {
                 String[] datos= linea.split(";");
                for (int j = 0; j < datos.length; j++) {
                    retorno[i][j]= datos[j];
                }
                linea= buferedreader.readLine();
            //}
            i++;
            
        }
        buferedreader.close();
        
        return retorno;
    }
    
}


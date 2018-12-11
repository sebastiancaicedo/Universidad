/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author sebastiancaicedo
 */
public class LectorEscritor {
    
    String path;

    public LectorEscritor(String path) {
        this.path = path;
    }
    
    public ArrayList<Empleado> getSlowEmpleado() throws FileNotFoundException{
        ArrayList<Empleado> empleados= new ArrayList<Empleado>();
        /*File f= new File("hola.txt");
        if(f.exists()){
            //funcion que verifica si el archivo existe
        }
        else
        {
            f.createNewFile();//si no existe, lo crea
        }*/
        Scanner scaner= new Scanner(new File(path));
        while(scaner.hasNext()){//pregunta si hay algo mas que leer cualquier cosa tru si si, false si no
            String linea= scaner.nextLine();
            String []datos= linea.split(" ");
            empleados.add(new Empleado(datos[0], datos[1], Integer.parseInt(datos[2])));
        }
        scaner.close();
        return empleados;
    }
    
    public ArrayList<Empleado> getFastEmpleado() throws Exception{
        ArrayList<Empleado> empleados= new ArrayList<Empleado>();
        
        BufferedReader buferedreader= new BufferedReader(new FileReader(new File(path)));
        String line= buferedreader.readLine();
        StringTokenizer stringtokenizer;//otro metodo como el split
        while(line != null){
            //String []datos= line.split(" ");//El split es uno de los metodos mas lentos
            stringtokenizer= new StringTokenizer(line, " ");//ya se debe saber cuantos espacios tiene la linea dividad por espacios para poder usar el tokenizer
            empleados.add(new Empleado(stringtokenizer.nextToken(), stringtokenizer.nextToken(), Integer.parseInt(stringtokenizer.nextToken())));
            line= buferedreader.readLine();
        }
        buferedreader.close();
        return empleados;
    }
    
    public void ecribir(String linea) throws IOException{
        PrintWriter pw= new PrintWriter(new BufferedWriter(new FileWriter(new File(path),true)));//si es true, escribe al final del archivo. false al inicio
        pw.println(linea);
        pw.close();
    }
}

package lab.rio.bonito;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class LectorEscritor {
    
    //File archivo = new File("Datos.txt");
    
    public void escritor(ArrayList A, String ruta) throws IOException{
        File archivo = new File(ruta);
        if (archivo.exists()){
            archivo.delete();
        }
        
        archivo.createNewFile();
        
        FileWriter escritor = new FileWriter(archivo,true);
       
        BufferedWriter writer = new BufferedWriter(escritor); 

        for (int i = 0; i < A.size(); i++) {
            writer.write(A.get(i).toString());
            writer.newLine();
        }
        
        writer.close();
        escritor.close(); 
    }
    
    public ArrayList lector(String ruta) throws FileNotFoundException{ 
        File archivo = new File(ruta);
        FileReader leerArchiv=new FileReader(archivo);  
        BufferedReader lineaArchivo=new BufferedReader(leerArchiv); 
        
        ArrayList<String> Lineas=new ArrayList<String>();
        
        while(true){ 
            String line; 
            try{ 
                line=lineaArchivo.readLine(); 
                if(line == null){
                   break;
                }
            }catch(IOException e){
                line="";
            }  
            Lineas.add(line); 
                
        }

        return Lineas;
        
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

/**
 *
 * @author sebastiancaicedo
 */
public class BusquedaSecuencial {
    
    public static void main(String[] args) {
        int i=1;
        
        int I[]={12,18,24,32,77};
        int x1=32;
        int x2=100;
        
        while(x1 != I[i]){
            i++;
        }
        System.out.println(i);
    }
    
}

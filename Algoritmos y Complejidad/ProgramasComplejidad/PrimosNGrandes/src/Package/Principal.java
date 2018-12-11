/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.InputMismatchException;

/**
 *
 * @author sebastiancaicedo
 */
public class Principal {
    
    static BigDecimal num1= new BigDecimal("2305843009213693951"); //"5316911983139663487003542222693990401");//5316911983139663487003542222693990401
    //BigInteger num2= new BigInteger("1857784135967729259941757547676466931927244119216984137122079863430329739504470799495811266247764730356552640891729");
    
    public static BigDecimal modulo(BigDecimal num1, BigDecimal num2) {
        try {
            BigDecimal resultado = new BigDecimal(num1.remainder(num2).toString());
            return resultado;
        } catch (InputMismatchException e) {
            return BigDecimal.ZERO;
        }
    }
    
    public static BigDecimal Suma(BigDecimal num1, BigDecimal num2) {

        BigDecimal sum = num1.add(num2);
        return sum;

    }
    
    public static BigDecimal dividir(BigDecimal a, BigDecimal b) {
        return a.divide(b, MathContext.DECIMAL128);
    }
    public static BigDecimal inversoMultiplicativo(BigDecimal entrada) {
        BigDecimal one = BigDecimal.ONE;
        return one.divide(entrada, MathContext.DECIMAL128);
    }
    
    public static BigDecimal Raiz(BigDecimal num, BigDecimal n) {
        //n = new BigDecimal("1.0").divide(n);
        n = inversoMultiplicativo(n);
        BigDecimal f = num;
        try {
            double res = Math.pow(num.doubleValue(), n.doubleValue());
            return new BigDecimal(res);
        } catch (Exception es) {
            BigDecimal i = BigDecimal.ONE;
            System.out.println("" + f + " " + n);
            while (i.compareTo(n) < 0) {
                f = f.multiply(num);
                i = i.add(new BigDecimal("1.0"));
            }
            return f;
        }
    }
    
    public static boolean verfiPrimo(BigDecimal n){
        boolean sw=true;
        BigDecimal d= new BigDecimal("2");
        BigDecimal dos= new BigDecimal("2");
        while(!d.equals(Raiz(n, dos)) && sw==true){
            if (modulo(n, d).toBigInteger() == BigInteger.ZERO) {
                sw= false;
                System.out.println(d+" Es un divisor de "+n);
            }
            d= Suma(d, new BigDecimal(1));
            //d= d.add(new BigDecimal(BigInteger.ONE));
        }
        /*for (int i = 1; i < n.divideAndRemainder(); i++) {
            if (n.mod(i.toString()) == 0) {
                return false;
            }
        }
        return true;*/
        return sw;
    }
    public static void main(String[] args) {
        System.out.println("Comenzando");
        if (verfiPrimo(num1)) {
            System.out.println("El numero es primo");
        }
        else
        {
            System.out.println("No es primo");
        }
        
    }
}

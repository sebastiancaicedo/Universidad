/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraUninorte;

import java.math.BigDecimal;

public class Discrete {
    // Combinatoria
    /*public static BigDecimal factorial(BigDecimal num)  {//nelson
     if (num.intValue() == 1 || num.intValue() == 0) {
     return BigDecimal.ONE;
     } else {
     return num.multiply(factorial(num.subtract(BigDecimal.ONE)));
     }
     }*/

    public static BigDecimal combinatoria(BigDecimal n, BigDecimal r) throws Exception {
        return factorial(n).divide(factorial(r).multiply(factorial(n.subtract(r))));
    }

    public static BigDecimal factorial(BigDecimal num) {//nelson
        BigDecimal factorial = BigDecimal.ONE;
        while (num.compareTo(BigDecimal.ZERO) != 0) {
            factorial = factorial.multiply(num);
            num = num.subtract(BigDecimal.ONE);
        }
        return factorial;
    }

    //Factorial
    /*
     BigDecimal fact = new BigDecimal("1");
     public  BigDecimal factorial(int n) {
              
     for(int i=1; i<=n; i++ ){
     fact=fact.multiply(new BigDecimal(i));
     }
     return fact;
          
     }*/
}

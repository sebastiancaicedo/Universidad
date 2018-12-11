/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraUninorte;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.InputMismatchException;

public class Arithmetic {

    //   Inverso de n(1/n)
    public static BigDecimal inversoMultiplicativo(BigDecimal entrada) {
        BigDecimal one = BigDecimal.ONE;
        return one.divide(entrada, MathContext.DECIMAL128);
    }
//Módulo

    public static BigDecimal modulo(BigDecimal num1, BigDecimal num2) {
        try {
            BigDecimal resultado = new BigDecimal(num1.remainder(num2).toString());
            return resultado;
        } catch (InputMismatchException e) {
            return BigDecimal.ZERO;
        }
    }
//División/

    public static BigDecimal dividir(BigDecimal a, BigDecimal b) {
        return a.divide(b, MathContext.DECIMAL128);
    }
//Multiplicación*

    public static BigDecimal multiplicar(BigDecimal A, BigDecimal B) {
        BigDecimal X = A.multiply(B);
        return X;
    }
//Resta-

    public static BigDecimal subtract(BigDecimal firstNumber, BigDecimal secondNumber) {
        BigDecimal finalNumber;
        finalNumber = firstNumber.subtract(secondNumber);
        return finalNumber;
    }

//Suma+
    public static BigDecimal Suma(BigDecimal num1, BigDecimal num2) {

        BigDecimal sum = num1.add(num2);
        return sum;

    }
//Unario-

    public static String signMinus(BigDecimal n) {
        return n.negate().toString();
    }

}

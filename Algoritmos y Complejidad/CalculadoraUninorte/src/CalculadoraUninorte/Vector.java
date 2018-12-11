/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraUninorte;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Vector {

//Búsqueda
    public static String buscar(ArrayList<BigDecimal> numeros, BigDecimal x) {
        for (int i = 0; i < numeros.size(); i++) {
            BigDecimal u = numeros.get(i);
            if (u.compareTo(x) == 0) {
                return ("El elemento " + x + " esta dentro del vector en la posicion " + (i + 1));
            }
        }
        return ("no se encontró el elemento.");
    }
//Sort

    public static ArrayList<BigDecimal> sort(ArrayList<BigDecimal> array) {
        BigDecimal clone;
        for (int j = 0; j < array.size(); j++) {
            for (int i = j + 1; i < array.size(); i++) {
                if (array.get(i).compareTo(array.get(j)) == -1) {
                    clone = array.get(j);
                    array.set(j, array.get(i));
                    array.set(i, clone);
                }
            }
        }
        return array;
    }

    public static String[] separar(String s) {
        return s.split(",");
    }
}

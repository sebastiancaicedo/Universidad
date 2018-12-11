package CalculadoraUninorte;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

public class Trigonometry {

    //PI
    public static BigDecimal PI(long tam) {

        Apfloat p = ApfloatMath.pi(tam);// Dentro del llamado va una cantidad long que sera la precision de PI
        BigDecimal pi = new BigDecimal(p.toString());
        return pi;
    }

    //Sen
    public static BigDecimal sinus(String imput, boolean grados) {
        try {
            double result = new Double(imput);
            if (grados == false) {
                result = Math.toRadians(result);
            }
            result = Math.sin(result);
            return BigDecimal.valueOf(result);
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    //Cos
    public static Double cos(String input, boolean grados) {

        BigDecimal ans = new BigDecimal(0);
        BigDecimal term = new BigDecimal(1);
        BigDecimal n = (new BigDecimal(input)).remainder(new BigDecimal("6.2831853071795864769252867665590057683943387987502116"), MathContext.UNLIMITED);
        for (int i = 1; i < 10000; i++) {
            ans = ans.add(term);
            term = term.multiply(n.pow(2)).divide(new BigDecimal(2 * i * (2 * i - 1)), 40, RoundingMode.HALF_UP).negate();
        }
        double answer = Double.valueOf(ans.toString());
        if (grados == false) {
            answer = Math.toRadians(answer);
        }
        return answer;
    }

    //Tan
    public static BigDecimal tan(BigDecimal n1, boolean Grados) { //Si el usuario lo ha digitado en  grados ha de recibir True la funcion o radianes:False

        if (Grados == false) {

            Apfloat x = new Apfloat(n1, 100);

            Apfloat tx = ApfloatMath.tan(ApfloatMath.toRadians(x));
            
            BigDecimal res = new BigDecimal(tx.toString(true));

            return res;
        } else {
            Apfloat x = new Apfloat(n1, 100);

            Apfloat tx = ApfloatMath.tan(x);
            
            BigDecimal res = new BigDecimal(tx.toString(true));
            
            return res;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraUninorte;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Powers {

//Exponenciación**
    public static BigDecimal potencia(BigDecimal n, BigDecimal r) throws Exception {
        BigDecimal resul = BigDecimal.ONE;
        if (r.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ONE.divide(potencia(n, r.multiply(new BigDecimal("-1"))));
        }
        if (r.compareTo(BigDecimal.ZERO) == 0 && n.compareTo(BigDecimal.ZERO) != 0) {
            return BigDecimal.ONE;
        } else if (r.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        } else {
            while (r.compareTo(BigDecimal.ONE) >= 0) {
                resul = resul.multiply(n);
                r = r.subtract(BigDecimal.ONE);
            }
            return resul;
        }
    }

    /*10**
     public static BigInteger potencia10(BigInteger bigExp) {
     BigInteger resultado = BigInteger.ONE;
     BigInteger bigBase = BigInteger.TEN;
     //BigInteger bigExp= new BigInteger(String.valueOf(exp));
     for (BigInteger i = BigInteger.valueOf(0);
     i.compareTo(BigInteger.ZERO) > 0;
     i = i.add(BigInteger.ONE)) {
     resultado = resultado.multiply(bigBase);
     }
     return resultado;
     }
     */
//Radicación
    public static BigDecimal Raiz(BigDecimal num, BigDecimal n) {
        //n = new BigDecimal("1.0").divide(n);
        n = Arithmetic.inversoMultiplicativo(n);
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
//X**2

    public static BigDecimal pot2(String imput) {

        BigDecimal result = new BigDecimal(imput);
        return result.multiply(result);

    }
//X**3

    public static BigDecimal pot3(String input) {
        BigDecimal n = new BigDecimal(input);
        return n.multiply(n).multiply(n);
    }
//Log_10

    public static BigDecimal LogBase10(BigDecimal n) {
        if (n.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal j = BigDecimal.ZERO;
            while (n.compareTo(BigDecimal.TEN) >= 0) {
                n = n.divide(BigDecimal.TEN);
                System.out.println(n);
                j = j.add(BigDecimal.ONE);
            }
            return Ln(n).divide(Ln(BigDecimal.TEN), MathContext.DECIMAL128).add(j);
        } else {
            throw new NumberFormatException("No existe logaritmo de números negativos1");
        }
    }
//Logaritmo natural
    public static BigDecimal LN10 = new BigDecimal("2.3025850929940456840179914546843642076011014886287729760333279009675726096773524802359972050895982983419677840422862486334095254650828067566662873690987816894829072083255546808437998948262331985283935053089653777326288461633662222876982198867");

    public static BigDecimal E = new BigDecimal("2.71828182845904523536028747135266249775724709369995957496696762772407663035354"
            + "759457138217852516642742746639193200305992181741359662904357290033429526059563"
            + "073813232862794349076323382988075319525101901157383418793070215408914993488416"
            + "750924476146066808226480016847741185374234544243710753907774499206955170276183"
            + "860626133138458300075204493382656029760673711320070932870912744374704723069697"
            + "720931014169283681902551510865746377211125238978442505695369677078544996996794"
            + "686445490598793163688923009879312773617821542499922957635148220826989519366803"
            + "318252886939849646510582093923982948879332036250944311730123819706841614039701"
            + "983767932068328237646480429531180232878250981945581530175671736133206981125099"
            + "618188159304169035159888851934580727386673858942287922849989208680582574927961"
            + "048419844436346324496848756023362482704197862320900216099023530436994184914631"
            + "409343173814364054625315209618369088870701676839642437814059271456354906130310"
            + "720851038375051011574770417189861068739696552126715468895703503540212340784981"
            + "933432106817012100562788023519303322474501585390473041995777709350366041699732"
            + "972508868769664035557071622684471625607988265178713419512466520103059212366771"
            + "943252786753985589448969709640975459185695638023637016211204774272283648961342"
            + "251644507818244235294863637214174023889344124796357437026375529444833799801612"
            + "549227850925778256209262264832627793338656648162772516401910590049164499828931");

    public static BigDecimal Ln(BigDecimal n) {//Cristian
        BigDecimal sumax = BigDecimal.ZERO;
        BigDecimal b = new BigDecimal(200);
        BigDecimal denominador = BigDecimal.ZERO;
        BigDecimal i = BigDecimal.ZERO;
        BigDecimal primertermino = BigDecimal.ZERO;
        BigDecimal segundotermino = BigDecimal.ZERO;
        BigDecimal exp = BigDecimal.ZERO;
        BigDecimal num1 = BigDecimal.ZERO;
        BigDecimal num2 = BigDecimal.ZERO;
        BigDecimal divexp = BigDecimal.ZERO;
        BigDecimal suma = BigDecimal.ZERO;
        while (b.compareTo(i) >= 0) {
            num1 = n.subtract(BigDecimal.ONE);
            num2 = n.add(BigDecimal.ONE);
            denominador = (new BigDecimal("2").multiply(i));
            exp = denominador.add(BigDecimal.ONE);
            primertermino = BigDecimal.ONE.divide(exp, MathContext.DECIMAL128);
            segundotermino = num1.divide(num2, MathContext.DECIMAL128);
            divexp = segundotermino.pow(exp.intValue());
            suma = primertermino.multiply(divexp);
            sumax = sumax.add(suma);
            i = i.add(BigDecimal.ONE);
        }
        sumax = sumax.multiply(new BigDecimal("2"));

        return sumax;
    }

    public BigDecimal logaritmoNatural(BigDecimal entrada) throws IllegalArgumentException {//Sebastian garrido
        if (entrada.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El logaritmo solo acepta entradas positivas.");
        }

        if (entrada.compareTo(BigDecimal.ONE) == 0) {
            return BigDecimal.ZERO;
        }

        if (entrada.compareTo(E) == 0) {
            return BigDecimal.ONE;
        }

        if (entrada.compareTo(BigDecimal.TEN) == 0) {
            return LN10;
        }

        int magnitud = 0;
        BigDecimal reducido;
        BigDecimal mantisa;
        if (entrada.abs().compareTo(BigDecimal.ONE) >= 0) {
            magnitud = entrada.toString().length() - entrada.scale();
            mantisa = entrada.movePointLeft(magnitud);
            reducido = mantisa.subtract(BigDecimal.ONE, MathContext.DECIMAL128);
        } else {
            mantisa = entrada;
            reducido = entrada.subtract(BigDecimal.ONE, MathContext.DECIMAL128);
        }

        BigDecimal bigMagnitud = LN10.multiply(new BigDecimal(magnitud), MathContext.DECIMAL128);

        BigDecimal salida = reducido;
        for (int i = 2; i < 100; i++) {
            BigDecimal num = new BigDecimal(i);
            BigDecimal termino = reducido.pow(i, MathContext.DECIMAL128).divide(num, MathContext.DECIMAL128);

            if (i % 2 == 0) {
                salida = salida.subtract(termino, MathContext.DECIMAL128);
            } else {
                salida = salida.add(termino, MathContext.DECIMAL128);
            }
        }

        return salida.add(bigMagnitud, MathContext.DECIMAL128);
    }

}

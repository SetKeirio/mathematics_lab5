package algorithm;

import support.input.Console;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class NewtonSimilar {

    ArrayList<BigDecimal> data;
    BigDecimal a, b, e, x;
    BigDecimal r;
    int n;

    public NewtonSimilar(ArrayList<BigDecimal> y){
        data = y;
        x = data.get(0);
        data.remove(0);
        n = data.size() / 2;
    }

    public ArrayList<BigDecimal> solve(){
        ArrayList<BigDecimal> answer = new ArrayList<BigDecimal>();
        for (int i = 0; i < n; i++){
            answer.add(new BigDecimal(0));
        }
        ArrayList<ArrayList<BigDecimal>> coefficients = new ArrayList<ArrayList<BigDecimal>>();
        for (int i = 0; i < n; i++){
            coefficients.add(new ArrayList<BigDecimal>());
        }
        for (int i = 0; i < n; i++){
            coefficients.get(i).add(data.get(2 * i + 1));
        }
        for (int i = 0; i < (n - 1); i++){
            for (int i1 = 0; i1 < (-i + n - 1); i1++){
                coefficients.get(i1).add(coefficients.get(i1 + 1).get(i).subtract(coefficients.get(i1).get(i)));
            }
            /*BigDecimal c = new BigDecimal(1);
            ArrayList<BigDecimal> temp = new ArrayList<BigDecimal>();
            for (int i1 = 0; i1 < n; i1++){
                if ((!(i == i1)) && (data.get(2 * i1).compareTo(data.get(2 * i)) != 0)) {
                    System.out.println(i1);
                    System.out.println(i);
                    temp.add(new BigDecimal(1));
                    temp.add(data.get(2 * i1).multiply(new BigDecimal(-1)));
                    Console.printEquations(temp);
                    if (temp.size() >= 4){
                        temp = Calculate.coefficients(temp);
                    }
                    Console.printEquations(temp);
                    c = c.multiply(data.get(2 * i).subtract(data.get(2 * i1)));
                }

            }
            //System.out.println(c);
            for (int i1 = 0; i1 < answer.size(); i1++){
                answer.set(i1, answer.get(i1).add(temp.get(i1).setScale(7).divide(c, RoundingMode.HALF_EVEN).multiply(data.get(2 * i + 1))));
            }*/
            Console.printEquations(answer);
        }

        BigDecimal h = data.get(0).subtract(data.get(2)).abs();
        for (int i = 0; i < coefficients.size(); i++){
            Console.printEquations(coefficients.get(i));
        }
        answer.set(answer.size() - 1, coefficients.get(0).get(0));
        ArrayList<BigDecimal> temp = new ArrayList<BigDecimal>();
        for (int i = 1; i < n; i++){
            temp = new ArrayList<BigDecimal>();
            BigDecimal factorial = Calculate.factorial(i);
            temp.add(new BigDecimal(1).setScale(7).divide(h, RoundingMode.HALF_EVEN));
            temp.add(data.get(0).multiply(new BigDecimal(-1)).setScale(7).divide(h, RoundingMode.HALF_EVEN));
            for (int i1 = 1; i1 < i; i1++) {
                temp.add(new BigDecimal(1).setScale(7).divide(h, RoundingMode.HALF_EVEN));
                temp.add(data.get(0).multiply(new BigDecimal(-1)).setScale(7).divide(h, RoundingMode.HALF_EVEN).subtract(new BigDecimal(i1)));
                if (temp.size() >= 4){
                    temp = Calculate.coefficients(temp);
                }
            }
            for (int i1 = 0; i1 < temp.size(); i1++){
                temp.set(i1, temp.get(i1).multiply(coefficients.get(0).get(i)).setScale(7).divide(factorial, RoundingMode.HALF_EVEN));
            }
            for (int i1 = 0; i1 < temp.size(); i1++){
                answer.set(answer.size() - temp.size() + i1, answer.get(answer.size() - temp.size() + i1).add(temp.get(i1)));
            }
        }
        Console.printEquations(answer);
        return answer;
    }
}

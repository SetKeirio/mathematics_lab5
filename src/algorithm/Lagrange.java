package algorithm;

import support.input.Console;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.SortedMap;

public class Lagrange {

    ArrayList<BigDecimal> data;
    BigDecimal a, b, e, x;
    BigDecimal r;
    int n;

    public Lagrange(ArrayList<BigDecimal> y){
        data = y;
        x = data.get(0);
        data.remove(0);
        n = data.size() / 2;
    }

    public ArrayList<BigDecimal> solve(){
        ArrayList<BigDecimal> answer = new ArrayList<BigDecimal>();
        Console.printEquations(data);
        for (int i = 0; i < n; i++){
            answer.add(new BigDecimal(0));
        }
        for (int i = 0; i < n; i++){
            BigDecimal c = new BigDecimal(1);
            ArrayList<BigDecimal> temp = new ArrayList<BigDecimal>();
            for (int i1 = 0; i1 < n; i1++){
                if (!(i == i1)) {
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
                answer.set(i1, answer.get(i1).add(temp.get(i1).setScale(20, RoundingMode.HALF_EVEN).multiply(data.get(2 * i + 1)).divide(c, RoundingMode.HALF_EVEN)));
            }
            Console.printEquations(answer);
        }
        return answer;
    }
}

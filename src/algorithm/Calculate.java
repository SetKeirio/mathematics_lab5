package algorithm;

import support.input.Console;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Calculate {

    public static BigDecimal factorial(int x){
        BigDecimal answer = new BigDecimal(1);
        for (int i = 1; i <= x; i++){
            answer = answer.multiply(new BigDecimal(i));
        }
        return answer;
    }
    public static ArrayList<BigDecimal> coefficients(ArrayList<BigDecimal> x){
        ArrayList<BigDecimal> answer = new ArrayList<BigDecimal>();
        for (int i = 0; i < (x.size() - 1); i++){
            answer.add(new BigDecimal(0));
        }
        for (int i = 0; i < (x.size() - 2); i++){
            answer.set(i, answer.get(i).add(x.get(i).multiply(x.get(x.size() - 2))));
            answer.set(i + 1, answer.get(i + 1).add(x.get(i).multiply(x.get(x.size() - 1))));
            //Console.printEquations(answer);
        }
        return answer;
    }
}

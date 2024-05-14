package algorithm;

import support.input.Console;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class NewtonDifferent {

    ArrayList<BigDecimal> data;
    BigDecimal a, b, e, x;
    BigDecimal r;
    int n;

    public NewtonDifferent(ArrayList<BigDecimal> y){
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
        ArrayList<BigDecimal> coefficients = new ArrayList<BigDecimal>();
        for (int i = 0; i < n; i++){
            coefficients.add(new BigDecimal(0));
        }
        ArrayList<BigDecimal> temp = new ArrayList<BigDecimal>();
        for (int i = 0; i < n; i++){
            temp.add(data.get(2 * i + 1));
        }
        answer.set(n - 1, temp.get(0));
        for (int i = 0; i < (n - 1); i++){
            BigDecimal c = new BigDecimal(1);
            for (int i1 = 0; i1 < (n - 1 - i); i1++){
                coefficients.set(i1, temp.get(i1 + 1).subtract(temp.get(i1)).setScale(7).divide(data.get(2 * (i1 + i + 1)).subtract(data.get(2 * i1)), RoundingMode.HALF_EVEN));
            }
            coefficients.remove(coefficients.size() - 1);
            temp.remove(temp.size() - 1);
            for (int i1 = 0; i1 < coefficients.size(); i1++){
                temp.set(i1, coefficients.get(i1));
            }
            answer.set(-i - 2 + n, temp.get(0));
        }
        coefficients = new ArrayList<BigDecimal>();
        temp = new ArrayList<BigDecimal>();
        for (int i = 0; i < n; i++){
            coefficients.add(answer.get(i));
            answer.set(i, new BigDecimal(0));
        }
        answer.set(answer.size() - 1, coefficients.get(coefficients.size() - 1));

        for (int i = 1; i < n; i++){
            temp = new ArrayList<BigDecimal>();
            temp.add(coefficients.get(n - i - 1));
            temp.add(coefficients.get(n - i - 1).multiply(data.get(0)).multiply(new BigDecimal(-1)));
            for (int i1 = 1; i1 < i; i1++) {
                temp.add(new BigDecimal(1));
                temp.add(data.get(2 * i1).multiply(new BigDecimal(-1)));
                if (temp.size() >= 4){
                    temp = Calculate.coefficients(temp);
                }
            }
            for (int i1 = 0; i1 < temp.size(); i1++){
                answer.set(answer.size() - temp.size() + i1, answer.get(answer.size() - temp.size() + i1).add(temp.get(i1).setScale(7, RoundingMode.HALF_EVEN)));
            }
        }
        Console.printEquations(answer);
        return answer;
    }
}

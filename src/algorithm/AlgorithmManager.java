package algorithm;

import support.input.Console;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class AlgorithmManager {
    public ArrayList<BigDecimal> solve(int function, ArrayList<BigDecimal> data){
        ArrayList<BigDecimal> answer = new ArrayList<BigDecimal>();
        BigDecimal temp = new BigDecimal(0);
        switch (function) {
            case 1:
                answer = lagrange(data);
                break;
            case 2:
                answer = newtonDifferent(data);
                break;
            case 3:
                answer = newtonSimilar(data);
                break;

        }
        return answer;
    }

    public ArrayList<BigDecimal> lagrange(ArrayList<BigDecimal> data){
        Lagrange method = new Lagrange(data);
        ArrayList<BigDecimal> answer = method.solve();
        return answer;
    }

    public ArrayList<BigDecimal> newtonDifferent(ArrayList<BigDecimal> data){
        NewtonDifferent method = new NewtonDifferent(data);
        ArrayList<BigDecimal> answer = method.solve();
        return answer;
    }

    public ArrayList<BigDecimal> newtonSimilar(ArrayList<BigDecimal> data){
        NewtonSimilar method = new NewtonSimilar(data);
        ArrayList<BigDecimal> answer = method.solve();
        return answer;
    }




}

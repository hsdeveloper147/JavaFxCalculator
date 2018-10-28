package Calculator;

public class Model {

    public float calculate(long n1,long n2,String op) {

        switch (op){
            case "+":
                return n1 + n2;

            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                if(n2 == 0) return 0;
                return ((float)n1 / (float)n2);
            default:
                return 0;
        }
    }
}

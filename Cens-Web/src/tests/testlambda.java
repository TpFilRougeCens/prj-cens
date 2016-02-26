package tests;

/**
 * Created by steven.cdi12 on 26/02/2016.
 */
public class testlambda {
    public static void main(String[] args) {

        testlambda test = new testlambda();
        MathOperation addition = (a, b) -> a + b;

        System.out.println("10 + 5 = " + test.operate(10, 5, addition));

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}

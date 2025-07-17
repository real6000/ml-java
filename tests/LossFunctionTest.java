import core.Matrix;
import loss.*;

public class LossFunctionTest {
    public static void main(String[] args) {
        Matrix predicted = new Matrix(1, 1);
        predicted.data[0][0] = 0.9;

        Matrix target = new Matrix(1, 1);
        target.data[0][0] = 1.0;

        LossFunction mse = new MSE();
        System.out.println("MSE Loss: " + mse.calculate(target, predicted));

        LossFunction ce = new CrossEntropy();
        System.out.println("CrossEntropy Loss: " + ce.calculate(target, predicted));
    }


}

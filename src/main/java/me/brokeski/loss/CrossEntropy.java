package me.brokeski.loss;


import me.brokeski.core.Matrix;

/**
 * Cross Entropy Loss Function.
 * Typically used for classification problems.
 *
 * Formula:
 *     Loss = - Σ [ target * log(output) + (1 - target) * log(1 - output) ]
 * Assumes outputs are already passed through a sigmoid.
 *
 * Produced in 2025
 */

public class CrossEntropy implements LossFunction{
    @Override
    public double compute(Matrix output, Matrix target) {
        double epsilon = 1e-9; // To prevent log(0)
        double sum = 0;
        for(int i = 0; i < output.rows; i++){
            for(int j = 0; j < output.cols; j++){
                double y= target.data[i][j];
                double yHat = output.data[i][j];
                yHat = Math.max(epsilon, Math.min(1 - epsilon, yHat)); // clamp to avoid NaN
                sum += -y * Math.log(yHat) - (1 - y) * Math.log(1 - yHat);
            }
        }
        return sum / (output.rows * output.cols);
    }

    @Override
    public Matrix derivative(Matrix output, Matrix target) {
        double epsilon = 1e-9;
        Matrix grad = new Matrix(output.rows, output.cols);
        for (int i = 0; i < output.rows; i++) {
            for (int j = 0; j < output.cols; j++) {
                double y = target.data[i][j];
                double yHat = output.data[i][j];
                yHat = Math.max(epsilon, Math.min(1 - epsilon, yHat)); // avoid div/0
                grad.data[i][j] = -(y / yHat) + ((1 - y) / (1 - yHat));
            }
        }
        return grad;
    }
}

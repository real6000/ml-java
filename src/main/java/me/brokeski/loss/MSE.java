package me.brokeski.loss;

import me.brokeski.core.Matrix;

/**
 * Mean Squared Error (MSE) loss function.
 * Loss: (1/n) * Σ (output - target)^2
 * Gradient: 2 * (output - target)
 *
 * Produced in 2025
 */

public class MSE implements LossFunction{
    @Override
    public double compute(Matrix output, Matrix target) {
        double sum = 0;
        for (int i = 0; i < output.rows; i++) {
            for (int j = 0; j < output.cols; j++) {
                double diff = output.data[i][j] - target.data[i][j];
                sum += diff * diff;
            }
        }
        return sum / (output.rows * output.cols);
    }

    @Override
    public Matrix derivative(Matrix output, Matrix target) {
        Matrix grad = new Matrix(output.rows, output.cols);
        for (int i = 0; i < output.rows; i++) {
            for (int j = 0; j < output.cols; j++) {
                grad.data[i][j] = 2 * (output.data[i][j] - target.data[i][j]);
            }
        }
        return grad;
    }
}

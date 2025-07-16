package me.brokeski.activations;

import me.brokeski.core.Matrix;

/**
 * ReLU activation function: f(x) = max(0, x)
 *
 * 2025
 */

public class ReLU implements ActivationFunction {

    @Override
    public Matrix activate(Matrix input) {
        Matrix result = new Matrix(input.rows, input.cols);
        for (int i = 0; i < input.rows; i++) {
            for (int j = 0; j < input.cols; j++) {
                result.data[i][j] = Math.max(0, input.data[i][j]);
            }
        }
        return result;
    }

    @Override
    public Matrix derivative(Matrix input) {
        Matrix grad = new Matrix(input.rows, input.cols);
        for (int i = 0; i < input.rows; i++) {
            for (int j = 0; j < input.cols; j++) {
                grad.data[i][j] = input.data[i][j] > 0 ? 1 : 0;
            }
        }
        return grad;
    }
}
